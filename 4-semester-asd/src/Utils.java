import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;

//Badysiak Paweł s21166 gr.41c
public class Utils {

    public static final String DEFAULT_OUTPUT = "output.txt";
    public static final String DELIMITER = ",";
    public static final String ZERO = "0";
    public static final String ONE = "1";

    public static boolean isCharacterNode(Node root) {
        return Objects.isNull(root.getLeft())
                && Objects.isNull(root.getRight())
                && !"".equals(root.getCharacter());
    }

//    public static Node getNodeFromQueue(Queue queue) {
//
//        return Optional.ofNullable(poll).orElse(new Node("", 0));
//    }
}
