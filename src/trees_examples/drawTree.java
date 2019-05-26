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
	
    public static final int FONT_SIZE = 12;
    public static final int CIRCLE_SIZE = 30;
    public Tree tree;

    public DrawTree(Tree tree){
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.setFont(new Font("Tahoma", Font.BOLD, FONT_SIZE));
        DrawTree(graphics, 0, getWidth(), 0, getHeight() / tree.getHeight(tree.getRoot()), tree.getRoot());
    }

    public void DrawNode(Graphics graphics,Node node,int width,int height,int q){
        graphics.setFont(new Font("Tahoma", Font.BOLD, FONT_SIZE));

        if(node!=null){
            graphics.drawString(String.valueOf(node.getValue()), (this.getWidth()/q)+width, height);
            if(node.getLeft() !=null) {
                DrawNode(graphics, node.getLeft(), -width, height*2, q);
            }
            if(node.getRight() !=null) {
                DrawNode(graphics, node.getRight(), width*2, height*2, q);
            }
        }
    }
	
	
    public void DrawTree(Graphics graphics, int StartWidth, int EndWidth, int StartHeight, int Level, Node node) {
        String data = String.valueOf(node.getValue());
        graphics.setFont(new Font("Tahoma", Font.BOLD, FONT_SIZE));
        FontMetrics fontMetrics = graphics.getFontMetrics();
        int dataWidth = fontMetrics.stringWidth(data);
        graphics.drawOval(((StartWidth + EndWidth) / 2 - dataWidth / 2)-(CIRCLE_SIZE/4), (StartHeight + Level / 2)-(FONT_SIZE/2)-(CIRCLE_SIZE/2), CIRCLE_SIZE, CIRCLE_SIZE);
        graphics.drawString(data, (StartWidth + EndWidth) / 2 - dataWidth / 2, StartHeight + Level / 2);

        if (node.getLeft() != null) {
            DrawTree(graphics, StartWidth, (StartWidth + EndWidth) / 2, StartHeight + Level, Level, node.getLeft());
        }
        
        if (node.getRight() != null) {
            DrawTree(graphics, (StartWidth + EndWidth) / 2, EndWidth, StartHeight + Level, Level, node.getRight());
        }
    }	
}