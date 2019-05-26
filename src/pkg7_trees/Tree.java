package pkg7_trees;

/**
 * Tree
 * @author Gabriel Felipe Cegatta dos Santos
 * @since 17/05/2019
 */
public class Tree {
    private Node root = null;
    public Tree() { }
    
    public Node getRoot() {
        return root;
    }
    
    public void insert(Node root, int value) {
        if (root == null) {
//            System.out.println("new: "+value);
            this.root = new Node(value);
        } else {
            if (value < root.getValue()) {
                if (root.getLeft() != null) {
//                    System.out.println("goToLeft: "+root.getLeft().getValue());
                    insert(root.getLeft(), value);
                } else {
                    Node node = new Node(value);
                    root.setLeft(node);
//                    System.out.println("Left: "+value);
                }
            } else {
                if (root.getRight() != null) {
//                    System.out.println("goToRight: "+root.getRight().getValue());
                    insert(root.getRight(), value);
                } else {
                    Node node = new Node(value);
                    root.setRight(node);
//                    System.out.println("Right: "+value);
                }
            }
//            System.out.println("finished");
        }
    }
    
    public void walkOnPreFixed(Node root) {
        if (root != null) {
            System.out.println(root.getValue());
            walkOnPreFixed(root.getLeft());
            walkOnPreFixed(root.getRight());
        }
    }
    
    public void walkOnPostFixed(Node root) {
        if (root != null) {
            walkOnPostFixed(root.getLeft());
            walkOnPostFixed(root.getRight());
            System.out.println(root.getValue());
        }
    }
    
    public void walkOnCentral(Node root) {
        if (root != null) {
            walkOnCentral(root.getLeft());
            System.out.print(root.getValue()+","); 
            walkOnCentral(root.getRight());
        }
    }
    
    public int getDepth(Node root) {        
        if (root == null) {
            return -1;
        } else {
            int value = root.getValue();
        }
        
        int hLeft = 1 + getDepth(root.getLeft());
        int hRight = 1 + getDepth(root.getRight());
        
        int biggestHeight = Math.max(hLeft, hRight);
        
        return biggestHeight;
    }
    
    public int getElementsQuantity(Node root) {        
        int count = 0;
        if (root != null) {
            count += getElementsQuantity(root.getLeft());
            count += getElementsQuantity(root.getRight());
            count++;
        }
        return count;
    }
    
    public Tree deleteNode(Tree tree, Node root, int value) {
        if (root == null) {
            return tree;
        }
        
        Node searchedNode = searchNode(root, value);
        Node parentNode = getParentNode(root, value);
        
        if (parentNode.getLeft() == searchedNode) {
            parentNode.setLeft(null);
        } else if (parentNode.getRight() == searchedNode) {
            parentNode.setRight(null);
        }
        
        if (hasChildren(searchedNode)) {
            return InsertChildrenIntoTree(tree, searchedNode);
        } else {
            searchedNode = null;
            return tree;
        }
    }
    
    public Tree InsertChildrenIntoTree(Tree tree, Node node) {
        if (!hasChildren(node)) {
            return tree;
        }
        if (node.getLeft() != null) {
            tree.insert(tree.getRoot(), node.getLeft().getValue());
            InsertChildrenIntoTree(tree, node.getLeft());
        }
        if (node.getRight() != null) {
            tree.insert(tree.getRoot(), node.getRight().getValue());
            InsertChildrenIntoTree(tree, node.getRight());
        }
        return tree;
    }
    
    public Node searchNode(Node root, int value) {
        if (root == null || root.getValue() == value) {
            return root;
        }
        
        Node result = searchNode(root.getLeft(), value);
        if (result == null) {
            result = searchNode(root.getRight(), value);
        }
        return result;
    }

    public Node getParentNode(Node root, int value) {
        if (root == null) {
            return root;
        }
        boolean hasLeftChild = (root.getLeft() != null && root.getLeft().getValue() == value);
        boolean hasRightChild = (root.getRight() != null && root.getRight().getValue() == value);
        if (hasLeftChild || hasRightChild) {
            return root;
        }
        Node result = getParentNode(root.getLeft(), value);
        Node result2 = getParentNode(root.getRight(), value);
        if (result != null) {
            return result;
        } else if (result2 != null) {
            return result2;
        }
        return result;
    }
    
    public boolean hasChildren(Node node) {
        if (node.getLeft() != null || node.getRight() != null) {
            return true;
        }
        return false;
    }
}
