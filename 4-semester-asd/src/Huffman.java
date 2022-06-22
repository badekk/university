import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.stream.Collectors;

//Badysiak Paweł s21166 gr.41c
public class Huffman {

    private static Mode mode;
    private static String inputFile;
    private static String outputFile;

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            ConsoleUtil.emptyArguments();
            return;
        }

        try {
            processArguments(args);
        } catch (InvalidParameterException e) {
            System.err.println(e.getMessage());
            return;
        }

        FileService.createOutputFileIfMissing(outputFile);

        switch (mode) {
            case ENCODE:
                final var collect = Files
                        .lines(Path.of(inputFile))
                        .collect(Collectors.joining("\n"));
                        encode(collect);
                break;
            case DECODE:
                Files
                        .lines(Path.of(inputFile))
                        .forEach(Huffman::decode);
                break;
        }
    }

    private static void encode(String line) {
        var encodedSymbols = new HashMap<String, String>();
        EncodeService.traverseTree(EncodeService.createTree(line), "", encodedSymbols);
        FileService.saveEncodedToFile(outputFile, line, encodedSymbols);
        FileService.saveDictionary("dictionary.txt", encodedSymbols);
    }

    private static void decode(String line) {
        final var decoded = DecodeService.decodeLine(line);
        FileService.saveDecodedToFile(outputFile, decoded);
    }


    private static void processArguments(String[] args) throws InvalidParameterException {
        assignMode(args[0]);
        assignInput(args[1]);
        assignOutput(args);
    }

    static void assignMode(String v) throws InvalidParameterException {
        try {
            mode = Mode.valueOf(v.toUpperCase());
        } catch (Exception e) {
            throw new InvalidParameterException(ConsoleUtil.badArgument("mode"));
        }
    }

    static void assignInput(String v) throws InvalidParameterException {
        try {
            inputFile = v;
        } catch (Exception e) {
            throw new InvalidParameterException(ConsoleUtil.badArgument("input"));
        }
    }

    static void assignOutput(String[] v) {
        try {
            outputFile = v[2];
        } catch (Exception e) {
            outputFile = Utils.DEFAULT_OUTPUT;
        }
    }

}
