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

	PATH_DEFAULT (Group.PATH, Player.NONE),
	PATH_Brick (Group.PATH, Player.NONE),
	PATH_COBBLE (Group.PATH, Player.NONE),
	PATH_GRASS (Group.PATH, Player.NONE),

	WALL_DEFAULT (Group.WALL, Player.NONE),

	CHEST_CLOSED (Group.OBJECT, Player.NONE),
	CHEST_OPEN (Group.OBJECT, Player.NONE),
	KEY (Group.OBJECT, Player.NONE);

	private Group group;

	private Player player;

	TileEnum(Group group, Player player) {
		this.group = group;
		this.player = player;
	}

	public Player getPlayer() {
	    return this.player;
    }
    public void setPlayer(Player newPlayer) {
        this.player = newPlayer;
    }


	public boolean isInGroup(Group group) {
		return this.group == group;
	}

	public enum Player  {
	    NONE,
        PLAYER,
        PLAYER_KEY
    }
	public enum Group {
		PATH,
		WALL,
		OBJECT,
		PLAYER;
	}
}