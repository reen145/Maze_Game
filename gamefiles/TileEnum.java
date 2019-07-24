/*******************************************************************************
Filename: TileEnum.java
@author: Timothy Bomers and Ryan Hilbert
@version 1.0
Due Date: 07-15-2019
Instructor: Dr. Jag Nandigam
Description: An enum that represents the different types of tiles that exist
	in the game
*******************************************************************************/
package gamefiles;
/**.
 * Class for the tile type
**/
public enum TileEnum {

	/**.
	 * enum fields
	**/

	//Fields for group path
	PATH_DEFAULT(Group.PATH, Player.NONE),
	/**.
	 * brick path
	**/
	PATH_Brick(Group.PATH, Player.NONE),
	/**.
	 * cobble path
	**/
	PATH_COBBLE(Group.PATH, Player.NONE),
	/**.
	 * grass path
	**/
	PATH_GRASS(Group.PATH, Player.NONE),

	/**.
	 * wall
	**/
	WALL_DEFAULT(Group.WALL, Player.NONE),

    //fields for OBJECT type.  TODO update to current double-image ideas
	/**.
	 * closed chest
	**/
	CHEST_CLOSED(Group.OBJECT, Player.NONE),
	/**.
	 * open chest
	**/
	CHEST_OPEN(Group.OBJECT, Player.NONE),
	/**.
	 * key
	**/
	KEY(Group.OBJECT, Player.NONE);

	/**.
	 * type of tile
	**/
	private Group group;

	/**.
	 * player status
	**/
	private Player player;

	/**.
	 * constructor
	 * @param group the group
	 * @param player the player status
	**/
	TileEnum(final Group group, final Player player) {
		this.group = group;
		this.player = player;
	}

	/**.
	 * returns status of player on a given tile
	 * @return the type of player on this tile
	**/
	public Player getPlayer() {
	    return this.player;
    }
	/**.
	 * set the player status for a tile
	 * @param newPlayer the player to be put on the tile
	**/
	//test TODO remove comment
    public void setPlayer(final Player newPlayer) {
        this.player = newPlayer;
    }

    /**.
	 * checks to see if a tile is in a given group
	 * @param group the group
	 * @return true or false
	**/
	public boolean isInGroup(final Group group) {
		return this.group == group;
	}

	/**.
	 * player status for a tile
	**/
	public enum Player  {
		/**.
		 * none
		**/
	    NONE,
	    /**.
		 * player
		**/
        PLAYER,
        /**.
    	 * player with key
    	**/
        PLAYER_KEY
    }
	/**.
	 * group status for a tile
	**/
	public enum Group {
		/**.
		 * path
		**/
		PATH,
		/**.
		 * wall
		**/
		WALL,
		/**.
		 * object
		**/
		OBJECT,
		/**.
		 * player
		**/
		PLAYER;
	}
}