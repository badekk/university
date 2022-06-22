import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.stream.Collectors;

//Badysiak Paweł s21166 gr.41c
public class DecodeService {

    public static String decodeLine(String line) {
        final var strings = line.split(Utils.DELIMITER);
        final var symbolSet = createSymbolSet();
        String lineToDecode = strings[0];
        StringBuilder sb = new StringBuilder("");
        while (!"".equals(lineToDecode)) {
            for (Symbol symbol : symbolSet) {
                if (lineToDecode.startsWith(symbol.getCode())) {
                    sb.append(symbol.getCharacter());
                    lineToDecode = lineToDecode.substring(symbol.getCode().length());
                }
            }
        }
        return sb.toString();
    }

    public static LinkedHashSet<Symbol> createSymbolSet() {
        String[] strings = Objects.requireNonNull(FileService.readDictionaryFile()).split(",");
        return Arrays.stream(strings)
                .map(Symbol::new)
                .sorted((o1, o2) -> {
                    int c = Integer.compare(o2.getCode().length(), o1.getCode().length());
                    if (c == 0)
                        c = o2.getCode().compareTo(o1.getCode());
                    return c;
                })
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
