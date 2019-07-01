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

import java.applet.Applet;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	private int size = 10;
	/**.
	 * Matrix containing all game tiles
    **/
	private JButton[][] matrix;
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
		Path path = Paths.get("/reen145.github.io/Icons/wall.png");
		iconWall = new ImageIcon(path.toString());
		matrix = new JButton[size][size];
		matrix[0][0] = new JButton(iconWall);
		matrix[0][0].setSize(256, 256);
		add(matrix[0][0]);
		 
		/*for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				
			}
		}*/
	}
	
	/**.
	 * Main method for the maze game
	 * @param args arguments that can be passed to the main method
    **/
	public static void main(final String[] args) {
		int size = 10;
		Gameframe frame = new Gameframe(size);
		Main panel = new Main();
		frame.add(panel);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	/**.
	 * Scales an image for use in the game
	 * taken from:
	 * https://stackoverflow.com/questions/
	 	15558202/how-to-resize-image-in-java
	 * @param imageToScale the image to scale
	 * @param dWidth the width of the image
	 * @param dHeight the height of the image
	 * @return scaledImage the image
    **/
public static BufferedImage scale(final BufferedImage imageToScale, 
		final int dWidth, final int dHeight) {
    BufferedImage scaledImage = null;
    if (imageToScale != null) {
        scaledImage = new BufferedImage(dWidth, dHeight, 
        		imageToScale.getType());
        Graphics2D graphics2D = scaledImage.createGraphics();
        graphics2D.drawImage(imageToScale, 0, 0, dWidth, dHeight, null);
        graphics2D.dispose();
    }
    return scaledImage;
	}
}