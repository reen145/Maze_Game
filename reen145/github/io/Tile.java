package reen145.github.io;

import javax.swing.*;

public class Tile extends JButton {
    public enum TILE_TYPE {
        PATH, WALL, PLAYER, CHEST
    }
    TILE_TYPE type = TILE_TYPE.PATH;
    
    public Tile(final TILE_TYPE ti) {
    	type = TILE_TYPE.PATH;
    }

    public TILE_TYPE getType() {
        return type;
    }
}
