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
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
	 * Game Model
	 **/
	private GameModel myGameModel;

	
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
				if (myGameModel.moveUp()) {
					playStep();
					updateBoard();
				} else {
					playError();
				}
			}
		});
		am.put("DOWN", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				if (myGameModel.moveDown()) {
					playStep();
					updateBoard();
				} else {
					playError();
				}
			}
		});

		am.put("LEFT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				if (myGameModel.moveLeft()) {
					playStep();
					updateBoard();
				} else {
					playError();
				}
			}
		});
		am.put("RIGHT", new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				if (myGameModel.moveRight()) {
					playStep();
					updateBoard();
				} else {
					playError();
				}
			}
		});


		// allow and start input map functionality
		setFocusable(true);
		requestFocusInWindow();

		//insitiantiates the GameModel Object
		myGameModel = new GameModel();
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
				tileMatrix[row][col] = new Tile(
					myGameModel.getTileValue(row, col));
				ButtonListener listener = new ButtonListener();
				tileMatrix[row][col]
						.addActionListener(listener);
				add(tileMatrix[row][col]);
			}
		}
	}
	/**.
	* Updates the board
	**/
	private void updateBoard() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				tileMatrix[row][col].setType(
					myGameModel.getTileValue(row, col));
			}
		}
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
						//check for movement
	if (tileMatrix[row][col].getType() 
			== TileEnum.PATH && tileMatrix[row + 1][col]
					.getType() == TileEnum.PLAYER 
					| tileMatrix[row + 1][col].getType() 
					== TileEnum.PLAYERKEY) {
						if (myGameModel.moveUp()) {
								playStep();
								updateBoard();
							}
	} else if  (tileMatrix[row][col].getType() 
			== TileEnum.PATH && tileMatrix[row - 1][col]
					.getType() == TileEnum.PLAYER 
					| tileMatrix[row - 1][col].getType() 
					== TileEnum.PLAYERKEY) {
						if (myGameModel.moveDown()) {
								playStep();
								updateBoard();
							}
	} else if  (tileMatrix[row][col].getType() 
			== TileEnum.PATH && tileMatrix[row][col + 1]
					.getType() == TileEnum.PLAYER 
					| tileMatrix[row][col + 1].getType() 
					== TileEnum.PLAYERKEY) {
						if (myGameModel.moveLeft()) {
								playStep();
								updateBoard();
							}
	} else if (tileMatrix[row][col].getType() 
			== TileEnum.PATH && tileMatrix[row][col - 1]
					.getType() == TileEnum.PLAYER 
					| tileMatrix[row][col - 1].getType() 
					== TileEnum.PLAYERKEY) {
						if (myGameModel.moveRight()) {
							 	playStep();
							 	updateBoard();
							 }
					//checks to see if the key was clicked
	} else if (tileMatrix[row][col].getType() == TileEnum.KEY) {
					if (myGameModel.keySelected()) {
								playKey();
								updateBoard();
							}
					//checks to see if the chest was clicked
	} else if (tileMatrix[row][col].getType() == TileEnum.CHEST) {
					if (myGameModel.chestSelected()) {
								updateBoard();
								playChest();
				JOptionPane.showMessageDialog(null, "You Won");
						myGameModel.resetBoard();
								updateBoard();
						myGameModel.resetBoard();
					JOptionPane.showMessageDialog(null, 
								"You Won");
						myGameModel.resetBoard();
								updateBoard();
							}
					} else {
							playError();
						}
					}
				}	
			}
		}
	}

	/**.
	 * helper method to play music for real
	 **/
	public static void playError() {
		try {
			// Open an audio input stream.
			File soundFile = new File("Sounds/error.wav");
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

	/**.
	 * helper method to play music for real
	 **/
	public static void playStep() {
		try {
			// Open an audio input stream.
			File soundFile = new File("Sounds/step.wav");
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

	/**.
	 * helper method to play music for real
	 **/
	public static void playKey() {
		try {
			// Open an audio input stream.
			File soundFile = new File("Sounds/tada.wav");
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

	/**.
	 * helper method to play music for real
	 **/
	public static void playChest() {
		try {
			// Open an audio input stream.
			File soundFile = new File("Sounds/creak.wav");
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
