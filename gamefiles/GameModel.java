/*******************************************************************************
Title:
Filename: 
@author: 
@version 1.0
Due Date:
Instructor:
Description:
*******************************************************************************/
package gamefiles;

/****************************************************************.
 * Class for the main logic for the maze game
*****************************************************************/
public class GameModel {
    private TileEnum[][]  boardMatrix;
    private int SIZE;
    public GameModel() {
        setDefaultBoard();
    }

    private void setDefaultBoard() {
        SIZE = 10;
        boardMatrix = new TileEnum[SIZE][SIZE];
        //sets a boarder of walls
        for (int i = 0; i < SIZE; i += (SIZE - 1)) {
            for (int j = 0; j < SIZE; j++) {
                boardMatrix[0][j] = TileEnum.WALL;
                boardMatrix[j][0] = TileEnum.WALL;
                boardMatrix[i][j] = TileEnum.WALL;
                boardMatrix[j][i] = TileEnum.WALL;
            }
        }
        //sets everything inside the border to be a path
        for (int i = 1; i < SIZE - 1; i++) {
            for(int j = 1; j < SIZE - 1; j++) {
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

    private TileEnum checkTile(int row, int col) {
        return boardMatrix[row][col];
    }

    public boolean moveUp() {
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (boardMatrix[i][j] == TileEnum.PLAYER
                        && boardMatrix[i - 1][j] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i - 1][j] = TileEnum.PLAYER;
                    return true;
                } else if(boardMatrix[i][j] == TileEnum.PLAYERKEY
                        && boardMatrix[i - 1][j] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i - 1][j] = TileEnum.PLAYERKEY;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean moveDown() {
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (boardMatrix[i][j] == TileEnum.PLAYER
                        && boardMatrix[i + 1][j] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i + 1][j] = TileEnum.PLAYER;
                    return true;
                } else if(boardMatrix[i][j] == TileEnum.PLAYERKEY
                        && boardMatrix[i + 1][j] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i + 1][j] = TileEnum.PLAYERKEY;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean moveLeft() {
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (boardMatrix[i][j] == TileEnum.PLAYER
                        && boardMatrix[i][j - 1] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i][j - 1] = TileEnum.PLAYER;
                    return true;
                }else if(boardMatrix[i][j] == TileEnum.PLAYERKEY
                        && boardMatrix[i][j - 1] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i][j - 1] = TileEnum.PLAYERKEY;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean moveRight() {
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (boardMatrix[i][j] == TileEnum.PLAYER
                        && boardMatrix[i][j + 1] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i][j + 1] = TileEnum.PLAYER;
                    return true;
                } else if(boardMatrix[i][j] == TileEnum.PLAYERKEY
                        && boardMatrix[i][j + 1] == TileEnum.PATH) {
                    boardMatrix[i][j] = TileEnum.PATH;
                    boardMatrix[i][j + 1] = TileEnum.PLAYERKEY;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean keySelected() {
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (boardMatrix[i][j] == TileEnum.KEY) {
                    if (boardMatrix[i + 1][j] == TileEnum.PLAYER) {
                        boardMatrix[i][j] = TileEnum.PATH;
                        boardMatrix[i + 1][j] = TileEnum.PLAYERKEY;
                    } else if (boardMatrix[i - 1][j] == TileEnum.PLAYER) {
                        boardMatrix[i][j] = TileEnum.PATH;
                        boardMatrix[i - 1][j] = TileEnum.PLAYERKEY;
                    } else if (boardMatrix[i][j + 1] == TileEnum.PLAYER) {
                        boardMatrix[i][j] = TileEnum.PATH;
                        boardMatrix[i][j + 1] = TileEnum.PLAYERKEY;
                    } else if (boardMatrix[i][j - 1] == TileEnum.PLAYER) {
                        boardMatrix[i][j] = TileEnum.PATH;
                        boardMatrix[i][j - 1] = TileEnum.PLAYERKEY;
                    }
                }
            }
        }
        return false;
    }

    public boolean chestSelected() {
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
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

    public boolean click(int row, int col) {
        return true;
    }

    public TileEnum getTileValue(int row, int col) {
        return boardMatrix[row][col];
    }

}
