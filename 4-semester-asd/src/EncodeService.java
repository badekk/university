import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Badysiak Paweł s21166 gr.41c
public class EncodeService {
    public static Node createTree(String input) {
        Node root = null;
        try {
            Queue first = createQueue(input);
            while (first.hasNextElem() && first.getData().getCount() != 0) {
                Node left = first.pollFirstElem();
                Node right = first.pollFirstElem();
                root = new Node(left, right);
                first.addElem(root);
            }
            return root;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void traverseTree(Node node, String s, HashMap<String, String> encodedSymbols) {

        if (Utils.isCharacterNode(node)) {
            encodedSymbols.put(node.getCharacter(), s);
            return;
        }

        traverseTree(node.getLeft(), s + Utils.ZERO, encodedSymbols);
        traverseTree(node.getRight(), s + Utils.ONE, encodedSymbols);
    }

    public static Queue createQueue(String input) throws IOException {
        List<Node> grouped = Arrays.stream(input.toUpperCase().split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(Node::new)
                .sorted(Comparator.comparingInt(x -> x.getCount()))
                .collect(Collectors.toList());

        Iterator<Node> iterator = grouped.iterator();

        return new Queue(iterator);
    }

    public static String createEncodedString(String line, HashMap<String, String> encodedSymbols) {
        String encoded = line.toUpperCase();
        for (Map.Entry<String, String> entry : encodedSymbols.entrySet()) {
            encoded = encoded.replace(entry.getKey(), entry.getValue());
        }
        return encoded;
    }

    public static String getEncodedSymbolsAsString(HashMap<String, String> encodedSymbols) {
        return encodedSymbols.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map((x) -> x.getKey() + ":" + x.getValue())
                .collect(Collectors.joining(Utils.DELIMITER));
    }
}
