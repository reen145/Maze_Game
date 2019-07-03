/*******************************************************************************
Title:
Filename: 
@author: 
@version 1.0
Due Date:
Instructor:
Description:
*******************************************************************************/
package reen145.github.io;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

/**.
 * Class for the main jPanel to be used in the maze game
**/
public class Main extends JPanel {
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
	private JButton[][] buttonMatrix;
	
	/**.
	 * Matrix containing information on game tiles
    **/
	private int[][] statusMatrix;
	
	/**.
	 * Represents a wall
    **/
	private ImageIcon iconWall;
	
	/**.
	 * Represents a player
    **/
	private ImageIcon iconPlayer;
	
	/**.
	 * Represents a blank square
    **/
	private ImageIcon iconBlank;
	
	/**.
	 * Represents a chest
    **/
	private ImageIcon iconChest;
	
	/**.
	 * Constructor creates a jPanel for the maze game
	 * @param none
    **/
	public Main() {
		setLayout(new GridLayout(SIZE, SIZE));
		iconWall = new ImageIcon("Icons/wall.png");
		iconPlayer = new ImageIcon("Icons/player.png");
		iconBlank = new ImageIcon("Icons/blank.png");
		iconChest = new ImageIcon("Icons/chest.png");
		
		// populate maze with icons
		populate();
		
	}
	
	/**.
	 * Populates the maze with walls, treasure, the player, etc
	 * @param none
    **/
	public void populate() {
		buttonMatrix = new JButton[SIZE][SIZE];
		statusMatrix = new int[SIZE][SIZE];
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				buttonMatrix[row][col] = new JButton(iconWall);
				statusMatrix[row][col] = 1;
				ButtonListener listener = new ButtonListener();
				buttonMatrix[row][col]
						.addActionListener(listener);
				add(buttonMatrix[row][col]);
			}
		}
	}
	
	/**.
	 * Main method for the maze game
	 * @param args arguments that can be passed to the main method
    **/
	public static void main(final String[] args) {
		Gameframe frame = new Gameframe(SIZE, ISIZE);
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
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if (comp == buttonMatrix[row][col]) {
					System.out.println("TEST");
				}
			}
		}
		}

	}
	public static void startBGMusic() {
		try {
			// Open an audio input stream.
			File soundFile = new File("Sounds/background.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
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
