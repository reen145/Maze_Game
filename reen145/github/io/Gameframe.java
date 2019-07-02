package reen145.github.io;
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
	 * size of the maze
	 */
	private int gameSize;
	/**.
	 * size of each icon
	 */
	private int iconSize;
	/****************************************************************.
	 * Constructor for the main frame for the maze game
	 * @param dSize - length of each side of the maze
	 * @param dIcon - side length of each square icon
	*****************************************************************/
	public Gameframe(final int dSize, final int dIcon) {

		gameSize = dSize;
		iconSize = dIcon;
		setName("The Maze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fileMenu = new JMenu("File");
		quitItem = new JMenuItem("quit");
		gameItem = new JMenuItem("new game");
		
		ButtonListener listener = new ButtonListener();
		quitItem.addActionListener(listener);
		gameItem.addActionListener(listener);

		fileMenu.add(gameItem);
		fileMenu.add(quitItem);
		menus = new JMenuBar();
		setJMenuBar(menus);
		menus.add(fileMenu);
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
