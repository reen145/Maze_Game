package gameFiles;

import javax.swing.JButton;

/**.
 * Class for the tiles representing the maze
**/
public class Tile extends JButton {
	private static final long serialVersionUID = 1L;

	/**.
	 * Defines types of tiles
	**/
	public enum TILETYPE {
		/**.
		 * Tile Types
		**/
        PATH, WALL, PLAYER, CHEST
    }
	
	/**.
	 * Class for the main jPanel to be used in the maze game
	**/
    private TILETYPE type = TILETYPE.PATH;
    
    /**.
     * Constructor for creating a tile
     * @param ti - the type of tile
    **/
    public Tile(final TILETYPE ti) {
    	type = ti;
    }

    /**.
     * Getter for the tile type
     * @return type - the type of tile
    **/
    public TILETYPE getType() {
        return type;
    }
    
    /**.
     * Setter for the tile type
     * @param ti - the type of tile
    **/
    public void setType(final TILETYPE ti) {
    	type = ti;
    }
}
