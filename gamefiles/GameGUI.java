/*******************************************************************************
Filename: GameGUI
@author: Timothy Bomers and Ryan Hilbert
@version 1.0
Due Date: 07-15-2019
Instructor: Dr. Jag Nandigam
Description: The class that extends JFrame, to create the GUI for the game.
 	Contains a GamePanel object, and the executable main method.
*******************************************************************************/
package gamefiles;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/****************************************************************
 * Class for the main jFrame for the maze game
*****************************************************************/
public class GameGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	/**
	 * Determines the size of the maze
	 * MUST AGREE WITH GAME PANEL SIZE
    **/
	private static final int SIZE = 10;
	
	/**
	 * Determines the size of each icon
    **/
	private static final int ISIZE = 64;
	/**
	 * menu drop down
	*/
	private JMenuBar menus;
	/**
	 * file button
	*/
	private JMenu fileMenu;
	/**
	 * quit button
	*/
	private JMenuItem quitItem;
	/**
	 * new game button
	*/
	private JMenuItem gameItem;
	/**
	 * game panel with all buttons
	*/
	private GamePanel panel;
	/****************************************************************
	 * Constructor for the main frame for the maze game
	 * @param dSize - length of each side of the maze
	 * @param dIcon - side length of each square icon
	*****************************************************************/
	public GameGUI(final int dSize, final int dIcon) {
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
		
		panel = new GamePanel(SIZE);
		add(panel);
		getContentPane().setPreferredSize(
				new Dimension(dSize * dIcon, dSize * dIcon));
		pack();
	}
	
	/**
	 * Main method for the maze game
	 * @param args arguments that can be passed to the main method
    **/
	public static void main(final String[] args) {
		GameGUI frame = new GameGUI(SIZE, ISIZE);
		frame.setVisible(true);
		startBGMusic();
	}

	/**
	 * helper method to play music for real
	 **/
	private static void startBGMusic() {
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
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		/**
		Represents a listener for button push (action) events.
		**/
		private class ButtonListener implements ActionListener {
			/**
			Updates the game when a button is pressed
			@param event - the button that got pressed
			**/
			public void actionPerformed(final ActionEvent event) {
			JComponent comp = (JComponent) event.getSource();
				if (comp == gameItem) {
					panel.resetGame();
				}

				if (comp == quitItem) {
					System.exit(1);
				}
			}

		}
}
