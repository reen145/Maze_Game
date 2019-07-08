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

    public GameModel() {
        setDefaultBoard();
    }

    private void setDefaultBoard() {
        int size = 10;
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
        for (int i = 1; i < 9; i++) {
            for(int j = 0; j < 10; j++) {
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

    private TileEnum checkTile(int x, int y) {
        return boardMatrix[x][y];
    }

    public boolean move(int x, int y) {
        return true;
    }

    public boolean click(int x, int y) {
        return true;
    }
}
