import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

//Badysiak Paweł s21166 gr.41c
public class FileService {

    public static void createOutputFileIfMissing(String outputFile) {
        try {
            Files.createFile(Path.of(outputFile));
        } catch (FileAlreadyExistsException f) {
            //
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveEncodedToFile(String outputFile, String line, HashMap<String, String> encodedSymbols) {
        try (OutputStream outputStream = Files.newOutputStream(Path.of(outputFile), StandardOpenOption.CREATE)) {
            outputStream.write(EncodeService.createEncodedString(line, encodedSymbols).getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveDecodedToFile(String outputFile, String decoded) {
        try (OutputStream outputStream = Files.newOutputStream(Path.of(outputFile), StandardOpenOption.CREATE)) {
            outputStream.write(decoded.getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveDictionary(String dictionary, HashMap<String, String> encodedSymbols) {
        try (OutputStream outputStream = Files.newOutputStream(Path.of(dictionary), StandardOpenOption.CREATE)) {
            outputStream.write(EncodeService.getEncodedSymbolsAsString(encodedSymbols).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readDictionaryFile() {
        try {
            return Files.readString(Path.of("dictionary.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
