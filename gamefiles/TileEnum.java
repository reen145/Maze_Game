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
	 * default path
	**/
	PATH_DEFAULT(Group.PATH),
	/**.
	 * brick path
	**/
	PATH_Brick(Group.PATH),
	/**.
	 * cobble path
	**/
	PATH_COBBLE(Group.PATH),
	/**.
	 * grass path
	**/
	PATH_GRASS(Group.PATH),

	/**.
	 * wall
	**/
	WALL_DEFAULT(Group.WALL),

	/**.
	 * closed chest
	**/
	CHEST_CLOSED(Group.OBJECT),
	/**.
	 * open chest
	**/
	CHEST_OPEN(Group.OBJECT),
	/**.
	 * key
	**/
	KEY(Group.OBJECT),

	/**.
	 * player
	**/
	PLAYER_DEFAULT(Group.PLAYER),
	/**.
	 * playe rwith key
	**/
	PLAYER_KEY(Group.PLAYER);

	/**.
	 * group
	**/
	private Group group;

	/**.
	 * Constructor
	 * @param group the type of enum this will be
	**/
	TileEnum(final Group group) {
		this.group = group;
	}

	/**.
	 * Checks to see which group the enum is in
	 * @param group the group to check
	 * @return boolean saying true or false
	**/
	public boolean isInGroup(final Group group) {
		return this.group == group;
	}

	/**.
	 * the groups
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
		 *object
		**/
		OBJECT,
		/**.
		 * player
		**/
		PLAYER;
	}
}