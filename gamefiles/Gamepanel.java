/*******************************************************************************
Title:
Filename: 
@author: 
@version 1.0
Due Date:
Instructor:
Description:
*******************************************************************************/
package gamefiles;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
	private static final int SIZE = 10;

	/**.
	 * Matrix containing all game tiles
	 **/
	private Tile[][] tileMatrix;
	
	/**.
	 * Constructor creates a jPanel for the maze game
	 * @param none
    **/
	public Gamepanel() {
		// set the layout to be a grid
		setLayout(new GridLayout(SIZE, SIZE));


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

		// listeners for each of the buttons
		am.put("UP", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				//model.moveUp();
				System.out.println("presssed up");
			}
		});

		am.put("DOWN", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("pressed down");
			}
		});

		am.put("LEFT", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("pressed left");
			}
		});
		
		am.put("RIGHT", new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				System.out.println("pressed right");
			}
		});
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
		tileMatrix = new Tile[SIZE][SIZE];
		
		// initializes each index of the tile matrix
		// each index is a member of the Tile class
		// each will have the 'path' icon and TILETYPE
		// adds a button listener for each tile
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				tileMatrix[row][col] = new Tile(TileEnum.PATH);
				ButtonListener listener = new ButtonListener();
				tileMatrix[row][col].addActionListener(listener);
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
		for (int i = 0; i < SIZE; i += (SIZE - 1)) {
			for (int j = 0; j < SIZE; j++) {
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
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				// found the source
				if (comp == tileMatrix[row][col]) {
					System.out.println("TEST");
				}
			}
		}
		}

	}
}
