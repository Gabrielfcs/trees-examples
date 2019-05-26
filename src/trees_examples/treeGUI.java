package trees_examples;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * treeGUI
 * @author Gabriel Felipe Cegatta dos Santos
 * @since 26/05/2019
 */
public class treeGUI extends JFrame {

	private JPanel contentPane;
	public Tree tree;
	public DrawTree drawer;
	
	/**
	 * Create the frame.
	 */
	public treeGUI(Tree tree) {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 500, 500);
            contentPane = new JPanel();
            contentPane.setLayout(new BorderLayout(0, 0));
            drawer = new DrawTree(tree);

            contentPane.add(drawer);
            setContentPane(contentPane);
            this.tree = tree;
            setVisible(true);
	}

}