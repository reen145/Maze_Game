/*******************************************************************************
Filename: GameModel.java
@author: Timothy Bomers and Ryan Hilbert
@version 1.0
Due Date: 07-15-2019
Instructor: Dr. Jag Nandigam
Description: This file contains a class that models the rules and mechanics
    of the Maze Game. It contains a matrix of enums representing the current
    state of the board, and modifies the matrix in accordance with any valid
    moves given to it by the GamePanel.
*******************************************************************************/
package gamefiles;

/****************************************************************.
 * Class for the main logic for the maze game
*****************************************************************/
public class GameModel {
	/**.
	 * Array for the matrix representing the board
	**/
    private TileEnum[][]  boardMatrix;
    /**.
     * Variable for the size of the board
    **/
    private int size;
    /**.
     * Constructor for the game board
     * @param none
    **/
    public GameModel() {
        setDefaultBoard();
    }

    /**.
     * Function to set the board to the default setup
     * @param none
    **/
    private void setDefaultBoard() {
        size = 10;
        boardMatrix = new TileEnum[size][size];
        //sets a boarder of walls
        for (int i = 0; i < size; i += (size - 1)) {
            for (int j = 0; j < size; j++) {
                boardMatrix[0][j] = TileEnum.WALL;
                boardMatrix[j][0] = TileEnum.WALL;
                boardMatrix[i][j] = TileEnum.WALL;
                boardMatrix[j][i] = TileEnum.WALL;
            }
        }
        //sets everything inside the border to be a path
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                boardMatrix[i][j] = TileEnum.PATH;
            }
        }
        // Set up static maze
        boardMatrix[1][3] = TileEnum.WALL;
        boardMatrix[1][2] = TileEnum.WALL;
        boardMatrix[2][3] = TileEnum.WALL;
        boardMatrix[2][4] = TileEnum.WALL;
        boardMatrix[2][6] = TileEnum.WALL;
        boardMatrix[1][6] = TileEnum.WALL;
        boardMatrix[3][1] = TileEnum.WALL;
        boardMatrix[4][1] = TileEnum.WALL;
        boardMatrix[4][2] = TileEnum.WALL;
        boardMatrix[3][4] = TileEnum.WALL;
        boardMatrix[3][6] = TileEnum.WALL;
        boardMatrix[3][7] = TileEnum.WALL;
        boardMatrix[5][1] = TileEnum.WALL;
        boardMatrix[5][2] = TileEnum.WALL;
        boardMatrix[5][3] = TileEnum.WALL;
        boardMatrix[5][4] = TileEnum.WALL;
        boardMatrix[6][3] = TileEnum.WALL;
        boardMatrix[6][5] = TileEnum.WALL;
        boardMatrix[7][7] = TileEnum.WALL;
        boardMatrix[8][7] = TileEnum.WALL;
        boardMatrix[9][7] = TileEnum.WALL;
        boardMatrix[1][1] = TileEnum.CHEST;
        boardMatrix[8][8] = TileEnum.PLAYER;
        boardMatrix[1][8] = TileEnum.KEY;
    }

    /**.
     * Function to check which type a tile is
     * @param row the row to check
     * @param col the column to check
     * @return the type of type of the tile in question
    **/
    private TileEnum checkTile(final int row, final int col) {
        return boardMatrix[row][col];
    }

    /**.
     * Function to check if a move is valid
     * @param none
     * @return boolean saying if the move is valid
    **/
    public boolean moveUp() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (boardMatrix[i][j] == TileEnum.PLAYER
                        && boardMatrix[i - 1][j] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i - 1][j] = TileEnum.PLAYER;
                    return true;
                } else if (boardMatrix[i][j] == TileEnum.PLAYERKEY
                        && boardMatrix[i - 1][j] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i - 1][j] = TileEnum.PLAYERKEY;
                    return true;
                }
            }
        }
        return false;
    }
    
    /**.
     * resets the board
     * @param none
     */
    public void resetBoard() {
        setDefaultBoard();
    }

    /**.
     * Function to check if a move is valid
     * @param none
     * @return boolean saying if the move is valid
    **/
    public boolean moveDown() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (boardMatrix[i][j] == TileEnum.PLAYER
                        && boardMatrix[i + 1][j] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i + 1][j] = TileEnum.PLAYER;
                    return true;
                } else if (boardMatrix[i][j] == TileEnum.PLAYERKEY
                        && boardMatrix[i + 1][j] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i + 1][j] = TileEnum.PLAYERKEY;
                    return true;
                }
            }
        }
        return false;
    }

    /**.
     * Function to check if a move is valid
     * @param none
     * @return boolean saying if the move is valid
    **/
    public boolean moveLeft() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (boardMatrix[i][j] == TileEnum.PLAYER
                        && boardMatrix[i][j - 1] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i][j - 1] = TileEnum.PLAYER;
                    return true;
                } else if (boardMatrix[i][j] == TileEnum.PLAYERKEY
                        && boardMatrix[i][j - 1] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i][j - 1] = TileEnum.PLAYERKEY;
                    return true;
                }
            }
        }
        return false;
    }

    /**.
     * Function to check if a move is valid
     * @param none
     * @return boolean saying if the move is valid
    **/
    public boolean moveRight() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (boardMatrix[i][j] == TileEnum.PLAYER
                        && boardMatrix[i][j + 1] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i][j + 1] = TileEnum.PLAYER;
                    return true;
                } else if (boardMatrix[i][j] == TileEnum.PLAYERKEY
                        && boardMatrix[i][j + 1] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i][j + 1] = TileEnum.PLAYERKEY;
                    return true;
                }
            }
        }
        return false;
    }

    /**.
     * Function to check if a key was selected
     * @param none
     * @return boolean saying if the move is valid
    **/
    public boolean keySelected() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (boardMatrix[i][j] == TileEnum.KEY) {
                    if (boardMatrix[i + 1][j] == TileEnum.PLAYER) {
                        boardMatrix[i][j] = TileEnum.PATH;
                        boardMatrix[i + 1][j] = TileEnum.PLAYERKEY;
                        return true;
                    } else if (boardMatrix[i - 1][j] == TileEnum.PLAYER) {
                        boardMatrix[i][j] = TileEnum.PATH;
                        boardMatrix[i - 1][j] = TileEnum.PLAYERKEY;
                        return true;
                    } else if (boardMatrix[i][j + 1] == TileEnum.PLAYER) {
                        boardMatrix[i][j] = TileEnum.PATH;
                        boardMatrix[i][j + 1] = TileEnum.PLAYERKEY;
                        return true;
                    } else if (boardMatrix[i][j - 1] == TileEnum.PLAYER) {
                        boardMatrix[i][j] = TileEnum.PATH;
                        boardMatrix[i][j - 1] = TileEnum.PLAYERKEY;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**.
     * Function to check if a chest is selected
     * @param none
     * @return boolean saying if the move is valid
    **/
    public boolean chestSelected() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (boardMatrix[i][j] == TileEnum.CHEST) {
                    if (boardMatrix[i + 1][j] == TileEnum.PLAYERKEY) {
                        boardMatrix[i][j] = TileEnum.CHESTOPEN;
                        boardMatrix[i + 1][j] = TileEnum.PLAYER;
                        return true;
                    } else if (boardMatrix[i - 1][j] == TileEnum.PLAYERKEY) {
                        boardMatrix[i][j] = TileEnum.CHESTOPEN;
                        boardMatrix[i - 1][j] = TileEnum.PLAYER;
                        return true;
                    } else if (boardMatrix[i][j + 1] == TileEnum.PLAYERKEY) {
                        boardMatrix[i][j] = TileEnum.CHESTOPEN;
                        boardMatrix[i][j + 1] = TileEnum.PLAYER;
                        return true;
                    } else if (boardMatrix[i][j - 1] == TileEnum.PLAYERKEY) {
                        boardMatrix[i][j] = TileEnum.CHESTOPEN;
                        boardMatrix[i][j - 1] = TileEnum.PLAYER;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**.
     * Function to check if a move is valid
     * @param row the row selected
     * @param col the column selected
     * @return boolean saying if the move is valid
    **/
    public boolean click(final int row, final int col) {
        return true;
    }

    /**.
     * Function to check if a move is valid
     * @param row the row selected
     * @param col the column selected
     * @return tile type of the tile in question
    **/
    public TileEnum getTileValue(final int row, final int col) {
        return boardMatrix[row][col];
    }

}
