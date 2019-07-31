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
     **/
    private CombineIcon iconWall;

    /**.
     * Represents a grassy wall
     **/
    private CombineIcon iconGrassWall;
    
    /**.
     * Represents a door
     **/
    private CombineIcon iconDoor;

    /**.
     * Represents a player
     **/
    private ImageIcon iconPlayer;

    /**.
     * Represents a cobblestone path
     **/
    private ImageIcon iconPath;
    /**.
     * Represents a brick path
     **/
    private ImageIcon iconBrick;
    /**.
     * Represents a grass path
     **/
    private ImageIcon iconGrass;

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
    private ImageIcon iconPlayerKey;

    /**.
     * Class for the main jPanel to be used in the maze game
     **/
	private TileData type;

    /**.
     * Constructor for creating a tile
     * @param ti - the type of tile
    **/
    public Tile(final TileData ti) {
        // instantiate the icons from the 'Icons' folder 
        iconWall = new CombineIcon(new ImageIcon("Icons/pathLava.png"), new ImageIcon("Icons/blank.png"));
        iconGrassWall = new CombineIcon(new ImageIcon("Icons/grassWall.png"), new ImageIcon("Icons/blank.png"));
        iconPlayer = new ImageIcon("Icons/knight.png");
        iconPath = new ImageIcon("Icons/pathCobble.png");
        iconBrick = new ImageIcon("Icons/pathBrick.png");
        iconGrass = new ImageIcon("Icons/pathGrass.png");
        iconChest = new CombineIcon(new ImageIcon("Icons/chest.png"), new ImageIcon("Icons/pathCobble.png"));
        iconKey = new CombineIcon(new ImageIcon("Icons/key.png"), new ImageIcon("Icons/pathCobble.png"));
        iconPlayerKey = new ImageIcon("Icons/knight_key.png");
        iconChestOpen = new CombineIcon(new ImageIcon("Icons/chest_open.png"), new ImageIcon("Icons/cobble.png"));
        iconDoor = new CombineIcon(new ImageIcon("Icons/door.png"), new ImageIcon("Icons/pathCobble.png"));
    	type = ti;
    	updateImage();
    }

    /**.
     * Getter for the tile type
     * @return type - the type of tile
    **/
    public TileData getType() {
        return type;
    }
    
    /**.
     * Setter for the tile type
     * @param ti - the type of tile
    **/
    public void setType(final TileData ti) {
    	type = ti;
    	updateImage();

    }

    /**.
     * Function to update a tiles icon
    **/
    private void updateImage() {
        if (type.getPlayer() == TileData.Player.NONE) {
        	switch (type.getTileEnum()) {
            case KEY:
                this.setIcon(iconKey);
                break;
            case PATH_DEFAULT:
                this.setIcon(iconPath);
                break;
            case PATH_BRICK:
            	this.setIcon(iconBrick);
            	break;
            case PATH_GRASS:
            	this.setIcon(iconGrass);
            	break;
            case CHEST_CLOSED:
                this.setIcon(iconChest);
                break;
            case WALL_DEFAULT:
                this.setIcon(iconWall);
                break;
            case WALL_GRASS:
                this.setIcon(iconGrassWall);
                break;
            case CHEST_OPEN:
            	this.setIcon(new CombineIcon(iconChestOpen, iconPath));
            	break;
            case DOOR:
            	this.setIcon(iconDoor);
            	break;
            default:
            	break;
        	}
        } else if (type.getPlayer() == TileData.Player.PLAYER) {
        	switch (type.getTileEnum()) {
            case PATH_DEFAULT:
                this.setIcon(new CombineIcon(iconPlayer, iconPath));
                break;
            case PATH_BRICK:
            	this.setIcon(new CombineIcon(iconPlayer, iconBrick));
            	break;
            case PATH_GRASS:
            	this.setIcon(new CombineIcon(iconPlayer, iconGrass));
            	break;
            default:
            	break;
        	}
        } else if (type.getPlayer() == TileData.Player.PLAYER_KEY) {
        	switch (type.getTileEnum()) {
            case KEY:
                this.setIcon(iconKey);
                break;
            case PATH_DEFAULT:
                this.setIcon(new CombineIcon(iconPlayerKey, iconPath));
                break;
            case PATH_BRICK:
            	this.setIcon(new CombineIcon(iconPlayerKey, iconBrick));
            	break;
            case PATH_GRASS:
            	this.setIcon(new CombineIcon(iconPlayerKey, iconGrass));
            	break;
            case CHEST_CLOSED:
                this.setIcon(iconChest);
                break;
            case WALL_DEFAULT:
                this.setIcon(iconWall);
                break;
            case CHEST_OPEN:
            	this.setIcon(new CombineIcon(iconChestOpen, iconPath));
            	break;
            case DOOR:
            	this.setIcon(iconDoor);
            	break;
            	default:
            	break;
        	}
        }
    }
}
