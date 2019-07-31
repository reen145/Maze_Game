/*******************************************************************************
Filename: GameModel.java
@author: Timothy Bomers and Ryan Hilbert
@version 1.0
Due Date: 07-15-2019
Instructor: Dr. Jag Nandigam
Description: This file contains a class that models the rules and mechanics
    of the Maze Game. It contains a Board that models the current state of
    game, and modifies the board in accordance with any valid
    moves given to it by the GamePanel.
*******************************************************************************/
package gamefiles;

/****************************************************************
 * Class for the main logic for the maze game
*****************************************************************/
public class GameModel {
	/**
	 * Board object for the matrix representing the game board
	**/
	private Board currentBoard;
    /**
     * Variable declaring the size of the board
    **/
    private final int size = 10;

    /**
     * Default Constructor for the game model
    **/
    public GameModel() {
        setDefaultBoard();
    }

     /**
     * Function to set the board to the default state
      *     Erases any previous data and sets the level
      *     to level 1.
    **/
    private void setDefaultBoard() {
        currentBoard = new Board();
        currentBoard.setBoard1();
    }

    /**
     * Helper method that handles when a level is won
     */
    public void levelWon() {
        switch (currentBoard.getNextLvl())
        {
            case LVL1:
                break;
            case LVL2a:
                currentBoard.setBoard2a(TileData.Player.PLAYER, 7, 7);
                break;
            case LVL2b:
                break;
        }
    }


    /**
     * Function to execute a move to the tile above
     * @return boolean saying if the move is valid
    **/
    public boolean moveUp() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((currentBoard.getValue(i, j).getPlayer() 
                		!= TileData.Player.NONE)
                		&& currentBoard.getValue(i - 1, j).getType()
                		== TileData.Group.PATH) {
                    currentBoard.getValue(i, j).setPlayer(TileData.Player.NONE);
                    currentBoard.getValue(i - 1, j)
                    .setPlayer(currentBoard.getCurrentPlayer());
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Resets the board to the default state
     */
    public void resetBoard() {
        setDefaultBoard();
    }

    /**
     * Function to move the player to the tile below
     * @return boolean saying if the move is valid
    **/
    public boolean moveDown() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((currentBoard.getValue(i, j).getPlayer()
                		!= TileData.Player.NONE)
                        && currentBoard.getValue(i + 1, j).getType()
                        == TileData.Group.PATH) {
                    currentBoard.getValue(i, j).setPlayer(TileData.Player.NONE);
                    currentBoard.getValue(i + 1, j)
                    .setPlayer(currentBoard.getCurrentPlayer());
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Function to move the player to the tile to the left
     * @return boolean saying if the move is valid
    **/
    public boolean moveLeft() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((currentBoard.getValue(i, j).getPlayer()
                		!= TileData.Player.NONE)
                        && currentBoard.getValue(i, j - 1).getType()
                        == TileData.Group.PATH) {
                    currentBoard.getValue(i, j).setPlayer(TileData.Player.NONE);
                    currentBoard.getValue(i, j - 1)
                    .setPlayer(currentBoard.getCurrentPlayer());
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Function to move the player to the tile to the right
     * @return boolean saying if the move is valid
    **/
    public boolean moveRight() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((currentBoard.getValue(i, j).getPlayer()
                		!= TileData.Player.NONE)
                        && currentBoard.getValue(i, j + 1).getType()
                        == TileData.Group.PATH) {
                    currentBoard.getValue(i, j).setPlayer(TileData.Player.NONE);
                    currentBoard.getValue(i, j + 1)
                    .setPlayer(currentBoard.getCurrentPlayer());
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Function to handle the Key being selected, if valid
     * @return boolean saying if the move is valid
    **/
    public boolean keySelected() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (currentBoard.getValue(i, j).getTileEnum()
                        == TileData.TileEnum.KEY) {
                    if (currentBoard.getValue(i + 1, j).getPlayer()
                            != TileData.Player.NONE) {
                        currentBoard.getValue(i, j)
                                .setTileEnum(TileData.TileEnum.PATH_DEFAULT);
                        currentBoard.setCurrentPlayer(TileData.Player.PLAYER_KEY);
                        return true;
                    } else if (currentBoard.getValue(i - 1, j).getPlayer()
                            != TileData.Player.NONE) {
                        currentBoard.getValue(i, j)
                                .setTileEnum(TileData.TileEnum.PATH_DEFAULT);
                        currentBoard.setCurrentPlayer(TileData.Player.PLAYER_KEY);
                        return true;
                    } else if (currentBoard.getValue(i, j + 1).getPlayer()
                            != TileData.Player.NONE) {
                        currentBoard.getValue(i, j)
                                .setTileEnum(TileData.TileEnum.PATH_DEFAULT);
                        currentBoard.setCurrentPlayer(TileData.Player.PLAYER_KEY);
                        return true;
                    } else if (currentBoard.getValue(i, j - 1).getPlayer()
                            != TileData.Player.NONE) {
                        currentBoard.getValue(i, j)
                                .setTileEnum(TileData.TileEnum.PATH_DEFAULT);
                        currentBoard.setCurrentPlayer(TileData.Player.PLAYER_KEY);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Function to handle if the door was selected
     * @return boolean saying if the move is valid
     **/
    public boolean doorSelected() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (currentBoard.getValue(i, j).getTileEnum()
                        == TileData.TileEnum.DOOR) {
                    if (i < 9 && currentBoard.getValue(i + 1, j)
                            .getPlayer() != TileData.Player.NONE) {
                        openDoor();
                        return true;
                    } else if (i > 0 && currentBoard.getValue(i - 1, j)
                            .getPlayer() != TileData.Player.NONE) {
                        openDoor();
                        return true;
                    } else if (j < 9 && currentBoard.getValue(i, j + 1)
                            .getPlayer() != TileData.Player.NONE) {
                        openDoor();
                        return true;
                    } else if (j > 0 && currentBoard.getValue(i, j - 1)
                            .getPlayer() != TileData.Player.NONE) {
                        openDoor();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * helper method to handle switching levels when using a door
     */
    private void openDoor() {
        switch(currentBoard.getDoorLvl()) {
            case LVL2a:
                currentBoard.setBoard2a(currentBoard.getCurrentPlayer(), 7, 1);
                break;
            case LVL2b:
                currentBoard.setBoard2b(currentBoard.getCurrentPlayer(), 7, 8);
                break;
        }
    }

    /**
     * Function to handle a chest being selected
     * @return boolean saying if the move is valid
    **/
    public boolean chestSelected() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (currentBoard.getValue(i, j).getTileEnum() == TileData.TileEnum.CHEST_CLOSED) {
                    if (currentBoard.getValue(i + 1, j).getPlayer() == TileData.Player.PLAYER_KEY) {
                        currentBoard.getValue(i, j).setTileEnum(TileData.TileEnum.CHEST_OPEN);
                        currentBoard.setCurrentPlayer(TileData.Player.PLAYER);
                        return true;
                    } else if (currentBoard.getValue(i - 1, j).getPlayer() == TileData.Player.PLAYER_KEY) {
                        currentBoard.getValue(i, j).setTileEnum(TileData.TileEnum.CHEST_OPEN);
                        currentBoard.setCurrentPlayer(TileData.Player.PLAYER);
                        return true;
                    } else if (currentBoard.getValue(i, j + 1).getPlayer() == TileData.Player.PLAYER_KEY) {
                        currentBoard.getValue(i, j).setTileEnum(TileData.TileEnum.CHEST_OPEN);
                        currentBoard.setCurrentPlayer(TileData.Player.PLAYER);
                        return true;
                    } else if (currentBoard.getValue(i, j - 1).getPlayer() == TileData.Player.PLAYER_KEY) {
                        currentBoard.getValue(i, j).setTileEnum(TileData.TileEnum.CHEST_OPEN);
                        currentBoard.setCurrentPlayer(TileData.Player.PLAYER);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Function to return the data held in a given tile
     * @param row the row selected
     * @param col the column selected
     * @return a TileData object representing the data of the tile
    **/
    public TileData getTileValue(final int row, final int col) {
        return currentBoard.getValue(row, col);
    }

}
