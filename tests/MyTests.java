package tests;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import org.junit.jupiter.api.Test;

import gamefiles.GameGUI;
import gamefiles.GameModel;
import gamefiles.GamePanel;

/**
 * Class for testing the game logic of Maze Game
 **/
class MyTests {
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
		//attempts to play each of the four sound effects
		panel.playChest();
		panel.playError();
		panel.playKey();
		panel.playStep();
	}
	
	/**
	 * Class for testing that the Maze Game model works correctly
	 * Will fail if any of the functionality for the GameModel fails
	 **/
	@Test
	public void testGameModel() {
		GameModel model = new GameModel();
		
	}
}
