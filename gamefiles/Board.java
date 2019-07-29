package gamefiles;


import javax.swing.text.PlainDocument;

public class Board {
    /**
     * Represents the state of the current player
     */
    private TileData.Player currentPlayer;
    /**
     * represents the size of the board
     */
    private final int size = 10;
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
    public TileData getValue(int row, int col) {
        return boardMatrix[row][col];
    }

    /**
     * Setter method for the value of a given board cell
     * @param row the row to be accessed
     * @param col the col to be accessed
     * @param value the new TileEnum Value
     */
    public  void setValue(int row, int col, TileData value) {
        boardMatrix[row][col] = value;
    }

    public void setCurrentPlayer(TileData.Player newPlayer) {
        this.currentPlayer = newPlayer;
    }

    public TileData.Player getCurrentPlayer(){
        return currentPlayer;
    }

    /**
     * Method to populate a board with values
     * Sets level 1 board data
     */
    public void setBoard_1() {
        initializeBoard(TileData.Player.PLAYER);

        // Set up static maze
        boardMatrix[1][3].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[1][2].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[2][3].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[2][4].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[2][6].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[1][6].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[3][1].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[4][1].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[4][2].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[3][4].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[3][6].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[3][7].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[5][1].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[5][2].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[5][3].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[5][4].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[6][3].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[6][5].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[7][7].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[8][7].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[9][7].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
        boardMatrix[1][1].setTileEnum(TileData.TileEnum.CHEST_CLOSED);
        boardMatrix[6][1].setTileEnum(TileData.TileEnum.KEY);
        boardMatrix[8][8].setPlayer(TileData.Player.PLAYER);
    }
    /**
     * Method to populate a board with values
     * Sets level 2a board data
     */
    public void setBoard_2a(TileData.Player theCurrentPlayer) {
        initializeBoard(theCurrentPlayer);
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
        
        boardMatrix[5][8].setPlayer(TileData.Player.PLAYER);
        currentPlayer = TileData.Player.PLAYER;
    }
    /**
     * Method to populate a board with values
     * Sets level 2b board data
     */
    public void setBoard_2b(TileData.Player theCurentPlayer) {
        initializeBoard(theCurentPlayer);
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
        
        boardMatrix[5][8].setPlayer(TileData.Player.PLAYER);
        currentPlayer = TileData.Player.PLAYER;
    }

    /**
     * Helper method to initialize boards
     * @param theCurentPlayer current player state
     */
    private void initializeBoard(TileData.Player theCurentPlayer) {
        currentPlayer =theCurentPlayer;
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
                boardMatrix[0][j].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
                boardMatrix[j][0].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
                boardMatrix[i][j].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
                boardMatrix[j][i].setTileEnum(TileData.TileEnum.WALL_DEFAULT);
            }
        }
    }

}
