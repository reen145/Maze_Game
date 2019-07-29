package gamefiles;

/**.
 * class containing info on what a tile represents
 **/
public class TileData {
	/**.
     * enum with fields for different tile types
     **/
    protected enum TileEnum {
    	//Fields for group path
        /**.
         * default tile is a path
         **/
        PATH_DEFAULT(Group.PATH), PATH_BRICK(Group.PATH), PATH_COBBLE(Group.PATH), PATH_GRASS(Group.PATH),
        //fields for the walls
        /**.
         * wall
         **/
        WALL_DEFAULT(Group.WALL),
        //fields for the
        /**.
         * chest states and key
         **/
        CHEST_CLOSED(Group.OBJECT), CHEST_OPEN(Group.OBJECT), KEY(Group.OBJECT), DOOR(Group.OBJECT);

        /**.
         * type of tile
         **/
        private Group group;

        /**.
         * constructor
         * @param g group
         **/
        TileEnum(final Group g) {
            group = g;
        }
    }
    /**.
     * group status for a tile
     **/
    protected enum Group {
        /**.
         * entry fields
         **/
        PATH, WALL, OBJECT,
    }
    /**.
     * group status for the player
     **/
    protected enum Player  {
        /**.
         * entry fields
         **/
        NONE, PLAYER, PLAYER_KEY
    }

    /**.
     * tile type
     **/
    private TileEnum myTileEnum;

    /**.
     * player status
     **/
    private Player myPlayer;

    /**.
     * constructor for the TileData class with parameters
     * @param theTileEnum type of tile
     * @param thePlayer player status
     **/
    TileData(final TileEnum theTileEnum, final Player thePlayer) {
        this.myPlayer = thePlayer;
        this.myTileEnum = theTileEnum;
    }

    /**.
     * default constructor
     **/
    TileData() {
        this.myPlayer = Player.NONE;
        this.myTileEnum = TileEnum.PATH_DEFAULT;
    }

    /**.
     * get the type of selected tile
     * @return the group
     **/
    public Group getType() {
        return myTileEnum.group;
    }

    /**.
     * check to see if the tile is of the given group
     * @param checkGroup the group to compare to
     * @return boolean true or false
     **/
    public boolean checkType(final Group checkGroup) {
        if (checkGroup == myTileEnum.group) {
            return true;
        }
        return false;
    }

    /**.
     * getter for the tile enum type
     * @return tile enum for selected tile
     **/
    public TileEnum getTileEnum() {
        return myTileEnum;
    }

    /**.
     * set selected tile to given state
     * @param theTileEnum state to be set
     **/
    public void setTileEnum(final TileEnum theTileEnum) {
        this.myTileEnum = theTileEnum;
    }

    /**.
     * get player for selected tile
     * @return player status
     **/
    public Player getPlayer() {
        return myPlayer;
    }

    /**.
     * set player for selected tile
     * @param thePlayer player status to set
     **/
    public void setPlayer(final Player thePlayer) {
        this.myPlayer = thePlayer;
    }
}
