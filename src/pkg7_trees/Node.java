package pkg7_trees;

/**
 * Node
 * @author Gabriel Felipe Cegatta dos Santos
 * @since 17/05/2019
 */
public class Node {
    private int value = 0;
    private Node left;
    private Node right;

    public Node(int value) {
        this.left = null;
        this.value = value;
        this.right = null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
