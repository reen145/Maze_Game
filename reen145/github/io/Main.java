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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

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
	 * Constructor creates a jPanel for the maze game
	 * @param none
    **/
	public Main() {
		setLayout(new GridLayout(SIZE, SIZE));
		Path path = Paths.get("Icons/wall.png");
		try {
			BufferedImage wall = ImageIO.read(
					new File(path.toString()));
			iconWall = new ImageIcon(wall);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		buttonMatrix = new JButton[SIZE][SIZE];
		statusMatrix = new int[SIZE][SIZE];
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				buttonMatrix[row][col] = new JButton(iconWall);
				buttonMatrix[row][col].setPreferredSize(
						new Dimension(64, 64));
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
		Main panel = new Main();
		frame.add(panel);
		frame.setVisible(true);
	}
}
