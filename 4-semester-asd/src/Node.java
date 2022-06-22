import java.util.Map;

//Badysiak Paweł s21166 gr.41c
public class Node {

    private String character;
    private int count;

    private Node left;
    private Node right;

    public Node(String character, int count) {
        this.character = character;
        this.count = count;
    }

    public Node(Map.Entry<String, Long> e) {
        this.character = e.getKey();
        this.count = e.getValue().intValue();
    }

    public Node(Node left, Node right) {
        this.character = String.join("", left.getCharacter(), right.getCharacter());
        this.count = left.getCount() + right.getCount();
        this.left = left;
        this.right = right;
    }

    public String getCharacter() {
        return character;
    }

    public int getCount() {
        return count;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
