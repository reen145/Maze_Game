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
	 * Represents a wall
	 * '1' in status matrix 1
    **/
	private ImageIcon iconWall;
	
	/**.
	 * Represents a player
    **/
	private ImageIcon iconPlayer;
	
	/**.
	 * Represents a blank square
    **/
	private ImageIcon iconPath;
	
	/**.
	 * Represents a chest
    **/
	private ImageIcon iconChest;
	/**.
	 * Represents a chest
    **/
	private ImageIcon iconKey;
	
	/**.
	 * Constructor creates a jPanel for the maze game
	 * @param none
    **/
	public Gamepanel() {
		// set the layout to be a grid
		setLayout(new GridLayout(SIZE, SIZE));
		// instantiate the icons from the 'Icons' folder
		iconWall = new ImageIcon("Icons/wall.png");
		iconPlayer = new ImageIcon("Icons/player.png");
		iconPath = new ImageIcon("Icons/path.png");
		iconChest = new ImageIcon("Icons/chest.png");
		iconKey = new ImageIcon("Icons/key.png");


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
				tileMatrix[row][col] = 
						new Tile(Tile.TILETYPE.PATH);
				tileMatrix[row][col].setIcon(iconPath);
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
		for (int i = 0; i < SIZE; i += (SIZE - 1)) {
			for (int j = 0; j < SIZE; j++) {
				setTile(tileMatrix[0][j], 
						iconWall, Tile.TILETYPE.WALL);
				setTile(tileMatrix[j][0], 
						iconWall, Tile.TILETYPE.WALL);
				setTile(tileMatrix[i][j], 
						iconWall, Tile.TILETYPE.WALL);
				setTile(tileMatrix[j][i], 
						iconWall, Tile.TILETYPE.WALL);
			}
		}
		// Set up static maze
		setTile(tileMatrix[1][3], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[1][2], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[2][3], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[2][4], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[2][6], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[1][6], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[3][1], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[4][1], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[4][2], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[3][4], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[3][6], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[3][7], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[5][1], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[5][2], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[5][3], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[5][4], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[6][3], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[6][5], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[7][7], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[8][7], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[9][7], iconWall, Tile.TILETYPE.WALL);
		setTile(tileMatrix[1][1], iconChest, Tile.TILETYPE.CHEST);
		setTile(tileMatrix[8][8], iconPlayer, Tile.TILETYPE.PLAYER);
		setTile(tileMatrix[1][8], iconKey, Tile.TILETYPE.KEY);
	}
	/**.
	 * Sets a given tile to be a certain type
	 * @param ti - the tile to be changed
	 * @param im - the image to change to
	 * @param ty - the type of the tile
    **/
	public void setTile(final Tile ti, 
			final ImageIcon im, final Tile.TILETYPE ty) {
		ti.setIcon(iconWall);
		ti.setIcon(im);
		ti.setType(ty);
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
