package gamefiles;


public class Board {
    /**.
     * represents the size of the board
     */
    private final int size = 10;
    /**.
     * a matrix that roepresents the current board state
     */
    private TileEnum[][] boardMatrix;

    /**.
     * Getter method for the value of a given board cell
     * @param row the row to be accessed
     * @param col the col to be accessed
     * @return the TileEnum of the cell accessed
     */
    public TileEnum getValue(int row, int col) {
        return boardMatrix[row][col];
    }

    /**.
     * Setter method for the value of a given board cell
     * @param row the row to be accessed
     * @param col the col to be accessed
     * @param value the new TileEnum Value
     */
    public  void setValue(int row, int col, TileEnum value) {
        boardMatrix[row][col] = value;
    }

    /**.
     * Method to populate a board with values
     * Sets level 1 board data
     */
    public void setBoard_1() {
        boardMatrix = new TileEnum[size][size];
        //sets a boarder of walls
        for (int i = 0; i < size; i += (size - 1)) {
            for (int j = 0; j < size; j++) {
                boardMatrix[0][j] = TileEnum.WALL_DEFAULT;
                boardMatrix[j][0] = TileEnum.WALL_DEFAULT;
                boardMatrix[i][j] = TileEnum.WALL_DEFAULT;
                boardMatrix[j][i] = TileEnum.WALL_DEFAULT;
            }
        }
        //sets everything inside the border to be a path
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                boardMatrix[i][j] = TileEnum.PATH_DEFAULT;
            }
        }
        // Set up static maze
        boardMatrix[1][3] = TileEnum.WALL_DEFAULT;
        boardMatrix[1][2] = TileEnum.WALL_DEFAULT;
        boardMatrix[2][3] = TileEnum.WALL_DEFAULT;
        boardMatrix[2][4] = TileEnum.WALL_DEFAULT;
        boardMatrix[2][6] = TileEnum.WALL_DEFAULT;
        boardMatrix[1][6] = TileEnum.WALL_DEFAULT;
        boardMatrix[3][1] = TileEnum.WALL_DEFAULT;
        boardMatrix[4][1] = TileEnum.WALL_DEFAULT;
        boardMatrix[4][2] = TileEnum.WALL_DEFAULT;
        boardMatrix[3][4] = TileEnum.WALL_DEFAULT;
        boardMatrix[3][6] = TileEnum.WALL_DEFAULT;
        boardMatrix[3][7] = TileEnum.WALL_DEFAULT;
        boardMatrix[5][1] = TileEnum.WALL_DEFAULT;
        boardMatrix[5][2] = TileEnum.WALL_DEFAULT;
        boardMatrix[5][3] = TileEnum.WALL_DEFAULT;
        boardMatrix[5][4] = TileEnum.WALL_DEFAULT;
        boardMatrix[6][3] = TileEnum.WALL_DEFAULT;
        boardMatrix[6][5] = TileEnum.WALL_DEFAULT;
        boardMatrix[7][7] = TileEnum.WALL_DEFAULT;
        boardMatrix[8][7] = TileEnum.WALL_DEFAULT;
        boardMatrix[9][7] = TileEnum.WALL_DEFAULT;
        boardMatrix[1][1] = TileEnum.CHEST_CLOSED;
        boardMatrix[6][1] = TileEnum.KEY;
        
        //boardMatrix[8][8].setPlayer(TileEnum.Player.PLAYER);
    }
    /**.
     * Method to populate a board with values
     * Sets level 2a board data
     */
    public void setBoard_2a() {
    	boardMatrix = new TileEnum[size][size];
        //sets a boarder of walls
        for (int i = 0; i < size; i += (size - 1)) {
            for (int j = 0; j < size; j++) {
                boardMatrix[0][j] = TileEnum.WALL_DEFAULT;
                boardMatrix[j][0] = TileEnum.WALL_DEFAULT;
                boardMatrix[i][j] = TileEnum.WALL_DEFAULT;
                boardMatrix[j][i] = TileEnum.WALL_DEFAULT;
            }
        }
        //sets everything inside the border to be a path
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                boardMatrix[i][j] = TileEnum.PATH_DEFAULT;
            }
        }
        // Set up static maze
        boardMatrix[2][2] = TileEnum.WALL_DEFAULT;
        boardMatrix[2][3] = TileEnum.WALL_DEFAULT;
        boardMatrix[3][2] = TileEnum.WALL_DEFAULT;
        boardMatrix[3][3] = TileEnum.WALL_DEFAULT;
        boardMatrix[5][4] = TileEnum.WALL_DEFAULT;
        boardMatrix[5][5] = TileEnum.WALL_DEFAULT;
        boardMatrix[6][4] = TileEnum.WALL_DEFAULT;
        boardMatrix[6][5] = TileEnum.WALL_DEFAULT;
        boardMatrix[3][6] = TileEnum.WALL_DEFAULT;
        boardMatrix[3][7] = TileEnum.WALL_DEFAULT;
        boardMatrix[4][6] = TileEnum.WALL_DEFAULT;
        boardMatrix[4][7] = TileEnum.WALL_DEFAULT;
        boardMatrix[5][6] = TileEnum.WALL_DEFAULT;
        boardMatrix[5][7] = TileEnum.WALL_DEFAULT;
        
        boardMatrix[1][1] = TileEnum.CHEST_CLOSED;
        
        //boardMatrix[5][8].setPlayer(TileEnum.Player.PLAYER);
    }
    /**.
     * Method to populate a board with values
     * Sets level 2b board data
     */
    public void setBoard_2b() {
    	boardMatrix = new TileEnum[size][size];
        //sets a boarder of walls
        for (int i = 0; i < size; i += (size - 1)) {
            for (int j = 0; j < size; j++) {
                boardMatrix[0][j] = TileEnum.WALL_DEFAULT;
                boardMatrix[j][0] = TileEnum.WALL_DEFAULT;
                boardMatrix[i][j] = TileEnum.WALL_DEFAULT;
                boardMatrix[j][i] = TileEnum.WALL_DEFAULT;
            }
        }
        //sets everything inside the border to be a path
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                boardMatrix[i][j] = TileEnum.PATH_DEFAULT;
            }
        }
        // Set up static maze
        boardMatrix[2][1] = TileEnum.WALL_DEFAULT;
        boardMatrix[2][2] = TileEnum.WALL_DEFAULT;
        boardMatrix[2][3] = TileEnum.WALL_DEFAULT;
        boardMatrix[2][4] = TileEnum.WALL_DEFAULT;
        boardMatrix[2][5] = TileEnum.WALL_DEFAULT;
        boardMatrix[2][6] = TileEnum.WALL_DEFAULT;
        boardMatrix[2][7] = TileEnum.WALL_DEFAULT;
        boardMatrix[4][2] = TileEnum.WALL_DEFAULT;
        boardMatrix[4][3] = TileEnum.WALL_DEFAULT;
        boardMatrix[4][4] = TileEnum.WALL_DEFAULT;
        boardMatrix[4][5] = TileEnum.WALL_DEFAULT;
        boardMatrix[4][6] = TileEnum.WALL_DEFAULT;
        boardMatrix[4][7] = TileEnum.WALL_DEFAULT;
        boardMatrix[4][8] = TileEnum.WALL_DEFAULT;
        boardMatrix[5][6] = TileEnum.WALL_DEFAULT;
        boardMatrix[6][6] = TileEnum.WALL_DEFAULT;
        boardMatrix[7][6] = TileEnum.WALL_DEFAULT;
        boardMatrix[6][4] = TileEnum.WALL_DEFAULT;
        boardMatrix[7][4] = TileEnum.WALL_DEFAULT;
        boardMatrix[8][4] = TileEnum.WALL_DEFAULT;
        boardMatrix[6][2] = TileEnum.WALL_DEFAULT;
        boardMatrix[7][2] = TileEnum.WALL_DEFAULT;
        boardMatrix[6][3] = TileEnum.WALL_DEFAULT;
        boardMatrix[1][1] = TileEnum.CHEST_CLOSED;
        boardMatrix[7][3] = TileEnum.KEY;
        
        //boardMatrix[5][8].setPlayer(TileEnum.Player.PLAYER);
    }


}
