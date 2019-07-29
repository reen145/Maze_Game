package gamefiles;

public class TileData {
    protected enum TileEnum {
        /**
         * .
         * enum fields
         **/
        //Fields for group path
        PATH_DEFAULT(Group.PATH), PATH_BRICK(Group.PATH), PATH_COBBLE(Group.PATH), PATH_GRASS(Group.PATH),
        //fields for the walls
        WALL_DEFAULT(Group.WALL),
        //fields for the
        CHEST_CLOSED(Group.OBJECT), CHEST_OPEN(Group.OBJECT), KEY(Group.PATH);

        /**.
         * type of tile
         **/
        private Group group;

        /**.
         * constructor
         * @param g group
         **/
        TileEnum(Group g) {
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
    protected enum Player  {
        /**.
         * entry fields
         **/
        NONE, PLAYER, PLAYER_KEY
    }

    TileEnum myTileEnum;

    Player myPlayer;


    TileData(TileEnum theTileEnum, Player thePlayer) {
        this.myPlayer = thePlayer;
        this.myTileEnum = theTileEnum;
    }

    TileData() {
        this.myPlayer = Player.NONE;
        this.myTileEnum = TileEnum.PATH_DEFAULT;
    }

    public Group getType() {
        return myTileEnum.group;
    }

    public boolean checkType(Group checkGroup) {
        if (checkGroup == myTileEnum.group)
            return true;
        return false;
    }

    public TileEnum getTileEnum(){
        return myTileEnum;
    }

    public void setTileEnum(TileEnum theTileEnum) {
        this.myTileEnum = theTileEnum;
    }

    public Player getPlayer() {
        return myPlayer;
    }

    public void setPlayer(Player thePlayer) {
        this.myPlayer = thePlayer;
    }
}
