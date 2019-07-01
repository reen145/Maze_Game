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
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
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
		setLayout(new GridLayout(SIZE, SIZE));
		Path path = Paths.get("Icons/wall.png");
		try {
			BufferedImage wall = ImageIO.read(new File(path.toString()));
			iconWall = new ImageIcon(wall);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				matrix = new JButton[SIZE][SIZE];
				matrix[row][col] = new JButton(iconWall);
				matrix[row][col].setPreferredSize(
						new Dimension(64, 64));
				add(matrix[row][col]);
			}
		}
	}
	
	/**.
	 * Main method for the maze game
	 * @param args arguments that can be passed to the main method
    **/
	public static void main(final String[] args) {
		int size = 10;
		Gameframe frame = new Gameframe(SIZE, ISIZE);
		Main panel = new Main();
		frame.add(panel);
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

/**.
 * Converts a given Image into a BufferedImage
 * taken from:
 * https://stackoverflow.com/questions
 	/13605248/java-converting-image-to-bufferedimage
 * @param img The Image to be converted
 * @return The converted BufferedImage
 */
public static BufferedImage toBufferedImage(final Image img) {
    if (img instanceof BufferedImage) {
        return (BufferedImage) img;
    }

    // Create a buffered image with transparency
    BufferedImage bimage = new BufferedImage(img.getWidth(null),
    	img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

    // Draw the image on to the buffered image
    Graphics2D bGr = bimage.createGraphics();
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();

    // Return the buffered image
    return bimage;
	}
}
