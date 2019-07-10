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

import javax.swing.*;

/**.
 * Class for the tiles representing the maze
**/
public class Tile extends JButton {
	private static final long serialVersionUID = 1L;
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
     * Represents an open chest
     **/
    private ImageIcon iconChestOpen;
    /**.
     * Represents a key
     **/
    private ImageIcon iconKey;
    /**.
     * Represents a player with a key
     **/
    private ImageIcon iconPlayerKey;


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
        iconWall = new ImageIcon("Icons/wall.png");
        iconPlayer = new ImageIcon("Icons/player.png");
        iconPath = new ImageIcon("Icons/path.png");
        iconChest = new ImageIcon("Icons/chest.png");
        iconKey = new ImageIcon("Icons/key.png");
        iconPlayerKey = new ImageIcon("Icons/player_key.png");
        iconChestOpen = new ImageIcon("Icons/chest_open.png");
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

    private void updateImage() {
        switch(type) {
            case KEY:
                this.setIcon(iconKey);
                break;
            case PATH:
                this.setIcon(iconPath);
                break;
            case CHEST:
                this.setIcon(iconChest);
                break;
            case PLAYER:
                this.setIcon(iconPlayer);
                break;
            case WALL:
                this.setIcon(iconWall);
                break;
            case PLAYERKEY:
            	this.setIcon(iconPlayerKey);
            	break;
            case CHESTOPEN:
            	this.setIcon(iconChestOpen);
            	break;
        }
    }
}
