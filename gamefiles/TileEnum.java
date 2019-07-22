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

	PATH_DEFAULT (Group.PATH),
	PATH_Brick (Group.PATH),
	PATH_COBBLE (Group.PATH),
	PATH_GRASS (Group.PATH),

	WALL_DEFAULT (Group.WALL),

	CHEST_CLOSED (Group.OBJECT),
	CHEST_OPEN (Group.OBJECT),
	KEY (Group.OBJECT),

	PLAYER_DEFAULT (Group.PLAYER),
	PLAYER_KEY (Group.PLAYER);

	private Group group;

	TileEnum(Group group) {
		this.group = group;
	}

	public boolean isInGroup(Group group) {
		return this.group == group;
	}

	public enum Group {
		PATH,
		WALL,
		OBJECT,
		PLAYER;
	}
}