package trees_examples;

/**
 * testTree
 * @author Gabriel Felipe Cegatta dos Santos
 * @since 17/05/2019
 */
public class testTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        
        tree.insert(tree.getRoot(), 20);
        tree.insert(tree.getRoot(), 15);
        tree.insert(tree.getRoot(), 30);
        tree.insert(tree.getRoot(), 2);
        tree.insert(tree.getRoot(), 17);
        tree.insert(tree.getRoot(), 45);
        tree.insert(tree.getRoot(), 1);
        tree.insert(tree.getRoot(), 18);
        tree.insert(tree.getRoot(), 35);
        tree.insert(tree.getRoot(), 60);
        tree.insert(tree.getRoot(), 32);
        tree.insert(tree.getRoot(), 80);
        tree.insert(tree.getRoot(), 48);
        tree.insert(tree.getRoot(), 25);
        tree.insert(tree.getRoot(), 90);
        
//        tree = tree.deleteNode(tree, tree.getRoot(), 60);
//        tree.walkOnCentral(tree.getRoot());
        new treeGUI(tree);
    }
}
