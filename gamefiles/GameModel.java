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

import java.util.ArrayList;

/****************************************************************.
 * Class for the main logic for the maze game
*****************************************************************/
public class GameModel {
	/**.
	 * Board object for the matrix representing the board
	**/
	private Board currentBoard;
    /**
     * ArrayList representing the different boards in a level
     */
    private ArrayList<Board> gameBoards;
    /**.
     * Variable for the size of the board
    **/
    private final int size = 10;
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
        currentBoard = new Board();
        //currentBoard.setBoard_1();
        currentBoard.setBoard_2a();
    }

    /**.
     * Function to check if a move is valid
     * @param none
     * @return boolean saying if the move is valid
    **/
    public boolean moveUp() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((currentBoard.getValue(i, j).getPlayer() != TileEnum.Player.NONE)
                     && currentBoard.getValue(i - 1, j).isInGroup(TileEnum.Group.PATH)) {
                    currentBoard.setValue(i, j, TileEnum.PATH_DEFAULT);
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
                if ((currentBoard.getValue(i, j).getPlayer() != TileEnum.Player.NONE)
                     && currentBoard.getValue(i + 1, j).isInGroup(TileEnum.Group.PATH)) {
                    //boardMatrix[i][j] = TileEnum.PATH_DEFAULT;
                    //boardMatrix[i + 1][j].setPlayer(currentPlayer);
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
                if ((currentBoard.getValue(i, j).getPlayer() != TileEnum.Player.NONE)
                     && currentBoard.getValue(i, j-1).isInGroup(TileEnum.Group.PATH)) {
                    //boardMatrix[i][j] = TileEnum.PATH_DEFAULT;
                    //boardMatrix[i][j - 1].setPlayer(currentPlayer);
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
                if ((currentBoard.getValue(i, j).getPlayer() != TileEnum.Player.NONE)
                     && currentBoard.getValue(i, j+1).isInGroup(TileEnum.Group.PATH)) {
                    //boardMatrix[i][j] = TileEnum.PATH_DEFAULT;
                    //boardMatrix[i][j + 1].setPlayer(currentPlayer);
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
                if (currentBoard.getValue(i, j) == TileEnum.KEY) {
                    if (currentBoard.getValue(i + 1, j).getPlayer() != TileEnum.Player.NONE) {
                        currentBoard.setValue(i, j, TileEnum.PATH_DEFAULT);
                        //boardMatrix[i + 1][j].setPlayer(currentPlayer);
                        return true;
                    } else if (currentBoard.getValue(i - 1, j).getPlayer() != TileEnum.Player.NONE) {
                        currentBoard.setValue(i, j, TileEnum.PATH_DEFAULT);
                        //boardMatrix[i - 1][j].setPlayer(currentPlayer);
                        return true;
                    } else if (currentBoard.getValue(i, j + 1).getPlayer() != TileEnum.Player.NONE) {
                        currentBoard.setValue(i, j, TileEnum.PATH_DEFAULT);
                        //boardMatrix[i][j + 1].setPlayer(currentPlayer);
                        return true;
                    } else if (currentBoard.getValue(i, j - 1).getPlayer() != TileEnum.Player.NONE) {
                        currentBoard.setValue(i, j, TileEnum.PATH_DEFAULT);
                        //boardMatrix[i][j - 1].setPlayer(currentPlayer);
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
        /*
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (boardMatrix[i][j] == TileEnum.CHEST_CLOSED) {
                    if (boardMatrix[i + 1][j].getPlayer() == TileEnum.Player.PLAYER_KEY) {
                        boardMatrix[i][j] = TileEnum.CHEST_OPEN;
                        return true;
                    } else if (boardMatrix[i - 1][j].getPlayer() == TileEnum.Player.PLAYER_KEY) {
                        boardMatrix[i][j] = TileEnum.CHEST_OPEN;
                        return true;
                    } else if (boardMatrix[i][j + 1].getPlayer() == TileEnum.Player.PLAYER_KEY) {
                        boardMatrix[i][j] = TileEnum.CHEST_OPEN;
                        return true;
                    } else if (boardMatrix[i][j - 1].getPlayer() == TileEnum.Player.PLAYER_KEY) {
                        boardMatrix[i][j] = TileEnum.CHEST_OPEN;
                        return true;
                    }
                }
            }
        }
        */
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
        return currentBoard.getValue(row, col);
    }

}
