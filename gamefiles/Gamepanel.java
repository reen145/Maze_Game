/*******************************************************************************
Title: Maze Game jPanel
Filename: Gamepanel.java
@author: Ryan Hilbert and Tim Bomers
@version 1.0
Due Date: July 15, 2019
Instructor: Dr Jag Nandigam
Description: Thie file contains the class that will represent the panel of The
Maze Game. It has a grid of custom jButtons called Tiles that fall into
different categories, with icons and possible actions associated with each.
This also handles user input through the arrow keys and mouse, allowing
movement and interaction with the maze itself.
*******************************************************************************/
package gamefiles;
// import necessary libraries
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

/**.
 * Class for the main jPanel to be used in the maze game
**/
public class Gamepanel extends JPanel {
	private static final long serialVersionUID = 1L;
	/**.
	 * Determines the size of the maze
	 * MUST AGREE WITH GAME GUI SIZE
    **/
	private int size = 10;

	/**.
	 * Matrix containing all game tiles
	 **/
	private Tile[][] tileMatrix;
	
	/**.
	 * Constructor creates a jPanel for the maze game
	 * @param s - size of matrix
    **/
	public Gamepanel(final int s) {
		// set size variable for this instance of the game
		size = s;
		
		// set the layout to be a grid
		setLayout(new GridLayout(size, size));

		// uses input maps to record key strokes
		InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = getActionMap();
		// one for each of the arrow keys
		im.put(KeyStroke.getKeyStroke(
				KeyEvent.VK_UP, 0, false), "UP");
		im.put(KeyStroke.getKeyStroke(
				KeyEvent.VK_DOWN, 0, false), "DOWN");
		im.put(KeyStroke.getKeyStroke(
				KeyEvent.VK_LEFT, 0, false), "LEFT");
		im.put(KeyStroke.getKeyStroke(
				KeyEvent.VK_RIGHT, 0, false), "RIGHT");

		// these functions listen for when an arrow key is pressed
		am.put("UP", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				//model.moveUp();
				System.out.println("presssed up");
			}
		});

		am.put("DOWN", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("pressed down");
			}
		});

		am.put("LEFT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("pressed left");
			}
		});
		
		am.put("RIGHT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("pressed right");
			}
		});
		// allow and start input map functionality
		setFocusable(true);
		requestFocusInWindow();
		// populate maze with icons
		populate();
		
	}
	
	/**.
	 * Populates the maze with walls, treasure, the player, etc
	 * @param none
    **/
	public void populate() {
		// instantiate the array of tiles
		tileMatrix = new Tile[size][size];
		
		// initializes each index of the tile matrix
		// each index is a member of the Tile class
		// each will have the 'path' icon and TILETYPE
		// adds a button listener for each tile
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				tileMatrix[row][col] = new Tile(TileEnum.PATH);
				ButtonListener listener = new ButtonListener();
				tileMatrix[row][col]
						.addActionListener(listener);
				add(tileMatrix[row][col]);
			}
		}
		// inserts wall tiles
		setWalls();
	}
	/**.
	 * Populates the maze with walls
	 * @param void
    **/
	public void setWalls() {
		// sets each tile on the outer border with a wall
		for (int i = 0; i < size; i += (size - 1)) {
			for (int j = 0; j < size; j++) {
				tileMatrix[0][j].setType(TileEnum.WALL);
				tileMatrix[j][0].setType(TileEnum.WALL);
				tileMatrix[i][j].setType(TileEnum.WALL);
				tileMatrix[j][i].setType(TileEnum.WALL);
			}
		}
		// Set up static maze
		tileMatrix[1][3].setType(TileEnum.WALL);
		tileMatrix[1][2].setType(TileEnum.WALL);
		tileMatrix[2][3].setType(TileEnum.WALL);
		tileMatrix[2][4].setType(TileEnum.WALL);
		tileMatrix[2][6].setType(TileEnum.WALL);
		tileMatrix[1][6].setType(TileEnum.WALL);
		tileMatrix[3][1].setType(TileEnum.WALL);
		tileMatrix[4][1].setType(TileEnum.WALL);
		tileMatrix[4][2].setType(TileEnum.WALL);
		tileMatrix[3][4].setType(TileEnum.WALL);
		tileMatrix[3][6].setType(TileEnum.WALL);
		tileMatrix[3][7].setType(TileEnum.WALL);
		tileMatrix[5][1].setType(TileEnum.WALL);
		tileMatrix[5][2].setType(TileEnum.WALL);
		tileMatrix[5][3].setType(TileEnum.WALL);
		tileMatrix[5][4].setType(TileEnum.WALL);
		tileMatrix[6][3].setType(TileEnum.WALL);
		tileMatrix[6][5].setType(TileEnum.WALL);
		tileMatrix[7][7].setType(TileEnum.WALL);
		tileMatrix[8][7].setType(TileEnum.WALL);
		tileMatrix[9][7].setType(TileEnum.WALL);
		tileMatrix[1][1].setType(TileEnum.CHEST);
		tileMatrix[8][8].setType(TileEnum.PLAYER);
		tileMatrix[1][8].setType(TileEnum.KEY);
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
		// checks the grid of buttons for an event source
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					// found the source
					if (comp == tileMatrix[row][col]) {
						System.out.println("TEST");
					}
				}	
			}
		}
	}
}
