package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.swing.ActionMap;
import javax.swing.InputMap;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import gamefiles.Board;
import gamefiles.GameGUI;
import gamefiles.GameModel;
import gamefiles.GamePanel;

/**
 * Class for testing the game logic of Maze Game
 **/
class MyTests {
	/**
	 * No tests should throw exceptions unless specified
	 **/
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	/**
	 * Class for testing that the Maze Game GUI can properly initialize
	 * Will fail if the game GUI constructor fails at any point
	 **/
	@Test
	public void testGameGUI() {
		//tests initialization of a new GameGUI
		GameGUI tester = new GameGUI(10, 64);
		assertNotNull(tester);
	}
	
	/**
	 * Class for testing that the Maze Game swing panel works correctly
	 * Will fail if any of the functionality for the GamePanel class fails
	 **/
	@Test
	public void testGamePanel() {
		//tests initialization of a new gamepanel
		GamePanel panel = new GamePanel(10);
		//gets the action and input maps from the panel
		ActionMap amap = panel.getActionMap();
		InputMap imap = panel.getInputMap();
		//ensures that the action and input maps are not null
		assertNotNull(amap);
		assertNotNull(imap);
		//attempts to execute the populate board method
		panel.populate();
	}
	
	/**
	 * Class for testing that the Maze Game model works correctly
	 * Will fail if any of the functionality for the GameModel fails
	 **/
	@Test
	public void testGameModel() {
		GameModel model = new GameModel();
		//Calls all public methods and checks for exceptions where applicable
		assertNotNull(model);
		assertFalse(model.chestSelected());
		assertFalse(model.doorSelected());
		assertFalse(model.keySelected());
		assertNotNull(model.getTileValue(1, 1));
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			model.getTileValue(0, -1);
		});
		assertTrue(model.click(0, 0));
		assertTrue(model.moveUp());
		assertTrue(model.moveDown());
		assertTrue(model.moveRight());
		assertTrue(model.moveLeft());
		model.resetBoard();
	}
	
	/**
	 * Class for testing that the board class works correctly
	 * Will fail if any of the functionality for the board fails
	 **/
	@Test
	public void testBoard() {
		Board board = new Board();
		//Tests initialization
		assertNotNull(board);
		//Tests setting up the first level
		board.setBoard1();
		//Tests getting a value from a tile on the board
		assertNotNull(board.getValue(1, 1));
		//Tests trying to get a value from a tile not on the grid (out of bounds)
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			board.getValue(0, -1);
		});
		//Tests that the player is on the board
		assertNotNull(board.getCurrentPlayer());
		//Tests that there is no door on level one
		assertNull(board.getDoorLvl());
		//Tests that the next level is present
		assertNotNull(board.getNextLvl());
		//Tests setting up the second level's second stage
		board.setBoard2a(board.getCurrentPlayer(), 0, 0);
		//Tests getting a value from a tile on the board
		assertNotNull(board.getValue(1, 1));
		//Tests trying to get a value from a tile not on the grid (out of bounds)
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			board.getValue(0, -1);
		});
		//Tests that the player is on the board
		assertNotNull(board.getCurrentPlayer());
		//Tests that there is a door on level one
		assertNotNull(board.getDoorLvl());
		//Tests that the next level is present
		assertNotNull(board.getNextLvl());
		//Tests setting up the second level's second stage
		board.setBoard2a(board.getCurrentPlayer(), 0, 0);
		//Tests getting a value from a tile on the board
		assertNotNull(board.getValue(1, 1));
		//Tests trying to get a value from a tile not on the grid (out of bounds)
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			board.getValue(0, -1);
		});
		//Tests that the player is on the board
		assertNotNull(board.getCurrentPlayer());
		//Tests that there is a door on level one
		assertNotNull(board.getDoorLvl());
		//Tests that the next level is present
		assertNotNull(board.getNextLvl());
	}
}
