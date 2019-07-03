package github.io;

import javax.swing.*;

public class Tile extends JButton {
    private enum TILE_TYPE {
        BLANK, WALL, PLAYER, CHEST
    }
    TILE_TYPE type = TILE_TYPE.BLANK;

    public TILE_TYPE getType() {
        return type;
    }
}
