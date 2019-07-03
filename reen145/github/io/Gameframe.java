package reen145.github.io;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/****************************************************************.
 * Class for the main jFrame for the maze game
*****************************************************************/
public class Gameframe extends JFrame {
	private static final long serialVersionUID = 1L;
	/**.
	 * menu dropdown
	*/
	private JMenuBar menus;
	/**.
	 * file button
	*/
	private JMenu fileMenu;
	/**.
	 * quit button
	*/
	private JMenuItem quitItem;
	/**.
	 * new game button
	*/
	private JMenuItem gameItem;
	
	/**.
	 * game panel with all buttons
	*/
	private Main panel;
	/****************************************************************.
	 * Constructor for the main frame for the maze game
	 * @param dSize - length of each side of the maze
	 * @param dIcon - side length of each square icon
	*****************************************************************/
	public Gameframe(final int dSize, final int dIcon) {
		setName("The Maze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fileMenu = new JMenu("File");
		quitItem = new JMenuItem("Quit");
		gameItem = new JMenuItem("New Game");
		
		ButtonListener listener = new ButtonListener();
		quitItem.addActionListener(listener);
		gameItem.addActionListener(listener);

		fileMenu.add(gameItem);
		fileMenu.add(quitItem);
		menus = new JMenuBar();
		setJMenuBar(menus);
		menus.add(fileMenu);
		
		panel = new Main();
		add(panel);
		getContentPane().setPreferredSize(
				new Dimension(dSize * dIcon, dSize * dIcon));
		pack();
		setVisible(true);
	}
		/**.
		Represents a listener for button push (action) events.
		**/
		private class ButtonListener implements ActionListener {
			/**.
			Updates the game when a button is pressed
			@param event - the button that got pressed
			**/
			public void actionPerformed(final ActionEvent event) {
			JComponent comp = (JComponent) event.getSource();
				if (comp == gameItem) {

				}

				if (comp == quitItem) {
					System.exit(1);
				}
			}

		}
}
