/*******************************************************************************
 Filename: Board.java
 @author: Timothy Bomers and Ryan Hilbert
 @version 1.0
 Due Date: 07-30-2019
 Instructor: Dr. Jag Nandigam
 Description: This file contains a class that models the board of any given
 level of the Maze Game. It contains a matrix of rules and mechanics
 of the Maze Game. It contains a matrix of enums representing the current
 state of the board, and modifies the matrix in accordance with any valid
 moves given to it by the GamePanel.
 *******************************************************************************/

package gamefiles;

/**
 * Class representing the board the player will navigate around
 */
public class Board {
    /**
     * Represents the state of the current player
     */
    private TileData.Player currentPlayer;
    /**
     * Enum representing the levels present in the game.
     */
    protected enum lvlEnum {
        /**
         * Represents the first level
         **/
        LVL1,
        /**
         * Represents the first zone of the second level
         **/
        LVL2a,
        /**
         * Represents the second zone of the second level
         **/
        LVL2b
    }

    /**
     * Stores data about what level is next
     */
    private lvlEnum nextLvl;

    /**
     * Stores data about where door lead
     */
    private lvlEnum doorLvl;

    /**
     * represents the size of the board
     */
    private int size = 10;
    /**
     * a matrix that roepresents the current board state
     */
    private TileData[][] boardMatrix;

    /**
     * Getter method for the value of a given board cell
     * @param row the row to be accessed
     * @param col the col to be accessed
     * @return the TileEnum of the cell accessed
     */
    public TileData getValue(final int row, final int col) {
        return boardMatrix[row][col];
    }

    /**
     * Setter method for the value of a given board cell
     * @param row the row to be accessed
     * @param col the col to be accessed
     * @param value the new TileEnum Value
     */
    public  void setValue(final int row, final int col, final TileData value) {
        boardMatrix[row][col] = value;
    }

    /**
     * method to set current player
     * @param newPlayer the player to be set
     */
    public void setCurrentPlayer(final TileData.Player newPlayer) {
        this.currentPlayer = newPlayer;
    }

    /**
     * Method to retrieve player of current tile
     * @return the player status of the selected tile
     */
    public TileData.Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Method to populate a board with values
     * Sets level 1 board data
     */
    public void setBoard1() {
        initializeBoard(TileData.Player.PLAYER, TileData.TileEnum.WALL_GRASS);
        this.nextLvl = lvlEnum.LVL2a;

        // Set up static maze
        boardMatrix[1][3].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[1][2].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[2][3].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[2][4].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[2][6].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[1][6].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[3][1].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[4][1].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[4][2].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[3][4].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[3][6].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[3][7].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[5][1].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[5][2].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[5][3].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[5][4].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[6][3].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[6][5].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[7][7].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[8][7].setTileEnum(TileData.TileEnum.PATH_GRASS);
        boardMatrix[1][1].setTileEnum(TileData.TileEnum.CHEST_CLOSED);
        boardMatrix[6][1].setTileEnum(TileData.TileEnum.KEY);
        boardMatrix[7][7].setPlayer(TileData.Player.PLAYER);
    }
    /**
     * Method to populate a board with values
     * Sets level 2a board data
     * @param theCurrentPlayer the status of the player
     * @param pRow the row the player will be placed at
     * @param pCol the col the player will be placed at
     */
    public void setBoard2a(final TileData.Player theCurrentPlayer, final int pRow, final int pCol) {
        initializeBoard(theCurrentPlayer, TileData.TileEnum.WALL_DEFAULT);
        this.nextLvl = lvlEnum.LVL2a;
        this.doorLvl = lvlEnum.LVL2b;

        // Set up static maze
        boardMatrix[2][2].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[2][3].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[3][2].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[3][3].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[5][4].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[5][5].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[6][4].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[6][5].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[3][6].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[3][7].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[4][6].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[4][7].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[5][6].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[5][7].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[1][1].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[pRow][pCol].setPlayer(TileData.Player.PLAYER);
        boardMatrix[4][5].setTileEnum(TileData.TileEnum.CHEST_CLOSED);
        boardMatrix[7][0].setTileEnum(TileData.TileEnum.DOOR);
    }
    /**
     * Method to populate a board with values
     * Sets level 2b board data
     * @param theCurrentPlayer the status of the player
     * @param pRow the row the player will be placed at
     * @param pCol the col the player will be placed at
     */
    public void setBoard2b(final TileData.Player theCurrentPlayer, final int pRow, final int pCol) {
        initializeBoard(theCurrentPlayer, TileData.TileEnum.WALL_DEFAULT);
        this.doorLvl = lvlEnum.LVL2a;

        // Set up static maze
        boardMatrix[2][1].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[2][2].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[2][3].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[2][4].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[2][5].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[2][6].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[2][7].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[4][2].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[4][3].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[4][4].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[4][5].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[4][6].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[4][7].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[4][8].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[5][6].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[6][6].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[7][6].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[6][4].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[7][4].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[8][4].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[6][2].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[7][2].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[6][3].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[7][3].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[7][9].setTileEnum(TileData.TileEnum.DOOR);
        boardMatrix[1][1].setTileEnum(TileData.TileEnum.KEY);
        boardMatrix[pRow][pCol].setPlayer(currentPlayer);
    }

    /**
     * getter for where the door leads
     * @return where the door leads
     */
    public lvlEnum getDoorLvl() {
        return doorLvl;
    }

    /**
     * getter for what the next level is
     * @return  next level
     */
    public lvlEnum getNextLvl() {
        return nextLvl;
    }

    /**
     * Helper method to initialize boards
     * @param theCurrentPlayer current player state
     * @param wall the texture for walls in the level
     */
    private void initializeBoard(final TileData.Player theCurrentPlayer, final TileData.TileEnum wall) {
        currentPlayer = theCurrentPlayer;
        boardMatrix = new TileData[size][size];

        //sets everything inside the border to be a path
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boardMatrix[i][j] = new TileData();
            }
        }
        //sets wall border
        for (int i = 0; i < size; i += (size - 1)) {
            for (int j = 0; j < size; j++) {
                boardMatrix[0][j].setTileEnum(wall);
                boardMatrix[j][0].setTileEnum(wall);
                boardMatrix[i][j].setTileEnum(wall);
                boardMatrix[j][i].setTileEnum(wall);
            }
        }
    }

}
