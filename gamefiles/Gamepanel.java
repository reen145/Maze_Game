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
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import gamefiles.Tile.TILETYPE;

/**.
 * Class for the main jPanel to be used in the maze game
**/
public class Gamepanel extends JPanel {
	private static final long serialVersionUID = 1L;
	/**.
	 * Determines the size of the maze
    **/
	private static final int SIZE = 10;
	
	/**.
	 * Determines the size of each icon
    **/
	private static final int ISIZE = 64;

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
	 * @param none
    **/
	public void setWalls() {
		// sets each tile on the outer border with a wall
		for (int i = 0; i < SIZE; i += (SIZE - 1)) {
			for (int j = 0; j < SIZE; j++) {
				setTile(tileMatrix[0][j], 
						iconWall, TILETYPE.WALL);
				setTile(tileMatrix[j][0], 
						iconWall, TILETYPE.WALL);
				setTile(tileMatrix[i][j], 
						iconWall, TILETYPE.WALL);
				setTile(tileMatrix[j][i], 
						iconWall, TILETYPE.WALL);
			}
		}
	}
	/**.
	 * Sets a given tile to be a certain type
	 * @param ti - the tile to be changed
	 * @param im - the image to change to
	 * @param ty - the type of the tile
    **/
	public void setTile(final Tile ti, 
			final ImageIcon im, final TILETYPE ty) {
		ti.setIcon(iconWall);
		ti.setIcon(im);
		ti.setType(ty);
	}
	
	/**.
	 * Main method for the maze game
	 * @param args arguments that can be passed to the main method
    **/
	public static void main(final String[] args) {
		Gameframe frame = new Gameframe(SIZE, ISIZE);
		frame.setVisible(true);
		startBGMusic();
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

	/**.
	 * helper method to play music for real
	 **/
	public static void startBGMusic() {
		try {
			// Open an audio input stream.
			File soundFile = new File("Sounds/background.wav");
			AudioInputStream audioIn = AudioSystem
					.getAudioInputStream(soundFile);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples 
			// from the audio input stream.
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}
