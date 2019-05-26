package trees_examples;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * drawTree
 * @author Gabriel Felipe Cegatta dos Santos
 * @since 26/05/2019
 */

class DrawTree extends JPanel{
	
    public Tree tree;

    public DrawTree(Tree tree){
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setFont(new Font("Tahoma", Font.BOLD, 20));
        DrawTree(g, 0, getWidth(), 0, getHeight() / tree.getDepth(tree.getRoot()), tree.getRoot());
    }

    public void DrawNode(Graphics g,Node n,int w,int h,int q){
        g.setFont(new Font("Tahoma", Font.BOLD, 20));

        if(n!=null){
            g.drawString(String.valueOf(n.getValue()), (this.getWidth()/q)+w, h);
            if(n.getLeft() !=null) {
                DrawNode(g, n.getLeft(), -w, h*2, q);
            }
            if(n.getRight() !=null) {
                DrawNode(g, n.getRight(), w*2, h*2, q);
            }
        }
    }
	
	
    public void DrawTree(Graphics g, int StartWidth, int EndWidth, int StartHeight, int Level, Node node) {
        String data = String.valueOf(node.getValue());
        g.setFont(new Font("Tahoma", Font.BOLD, 20));
        FontMetrics fm = g.getFontMetrics();
        int dataWidth = fm.stringWidth(data);
        g.drawString(data, (StartWidth + EndWidth) / 2 - dataWidth / 2, StartHeight + Level / 2);

        if (node.getLeft() != null) {
            DrawTree(g, StartWidth, (StartWidth + EndWidth) / 2, StartHeight + Level, Level, node.getLeft());
        }
        
        if (node.getRight() != null) {
            DrawTree(g, (StartWidth + EndWidth) / 2, EndWidth, StartHeight + Level, Level, node.getRight());
        }
    }	
}