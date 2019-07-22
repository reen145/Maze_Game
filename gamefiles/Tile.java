/*******************************************************************************
Filename: Title.java
@author: Timothy Bomers and Ryan Hilbert
@version 1.0
Due Date: 07-15-2019
Instructor: Dr. Jag Nandigam
Description:  A class that extends JButton that represents the tiles on the
    game board.
*******************************************************************************/
package gamefiles;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**.
 * Class for the tiles representing the maze
**/
public class Tile extends JButton {
	private static final long serialVersionUID = 1L;
    /**.
     * Represents a wall
     * '1' in status matrix 1
     **/
    private CombineIcon iconWall;

    /**.
     * Represents a player
     **/
    private CombineIcon iconPlayer;

    /**.
     * Represents a blank square
     **/
    private CombineIcon iconPath;

    /**.
     * Represents a chest
     **/
    private CombineIcon iconChest;
    /**.
     * Represents an open chest
     **/
    private CombineIcon iconChestOpen;
    /**.
     * Represents a key
     **/
    private CombineIcon iconKey;
    /**.
     * Represents a player with a key
     **/
    private CombineIcon iconPlayerKey;


    /**.
     * Class for the main jPanel to be used in the maze game
     **/
	private TileEnum type;

    /**.
     * Constructor for creating a tile
     * @param ti - the type of tile
    **/
    public Tile(final TileEnum ti) {
        // instantiate the icons from the 'Icons' folder 
        iconWall = new CombineIcon(new ImageIcon("Icons/wall.png"),
        		new ImageIcon("Icons/blank.png"));
        iconPlayer = new CombineIcon(new ImageIcon("Icons/knight.png"),
        		new ImageIcon("Icons/blank.png"));
        iconPath = new CombineIcon(new ImageIcon("Icons/pathCobble.png"),
        		new ImageIcon("Icons/blank.png"));
        iconChest = new CombineIcon(new ImageIcon("Icons/chest.png"),
        		new ImageIcon("Icons/pathCobble.png"));
        iconKey = new CombineIcon(new ImageIcon("Icons/key.png"),
        		new ImageIcon("Icons/pathCobble.png"));
        iconPlayerKey = new CombineIcon(new ImageIcon("Icons/knight_key.png"),
        		new ImageIcon("Icons/blank.png"));
        iconChestOpen = new CombineIcon(new ImageIcon("Icons/chest_open.png"),
        		new ImageIcon("Icons/cobble.png"));
    	type = ti;
    	updateImage();
    }

    /**.
     * Getter for the tile type
     * @return type - the type of tile
    **/
    public TileEnum getType() {
        return type;
    }
    
    /**.
     * Setter for the tile type
     * @param ti - the type of tile
    **/
    public void setType(final TileEnum ti) {
    	type = ti;
    	updateImage();

    }

    /**.
     * Function to update a tiles icon
     * @param none
    **/
    private void updateImage() {
        switch (type) {
            case KEY:
                this.setIcon(iconKey);
                break;
            case PATH_DEFAULT:
                this.setIcon(iconPath);
                break;
            case CHEST_CLOSED:
                this.setIcon(iconChest);
                break;
            case PLAYER_DEFAULT:
                this.setIcon(iconPlayer);
                break;
            case WALL_DEFAULT:
                this.setIcon(iconWall);
                break;
            case PLAYER_KEY:
            	this.setIcon(iconPlayerKey);
            	break;
            case CHEST_OPEN:
            	this.setIcon(iconChestOpen);
            	break;
            	default:
            	break;
            	//test TODO remove
        }
    }
}
