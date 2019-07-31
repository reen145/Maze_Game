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
	 **/
	@Test
	public void testGameGUI() {
		GameGUI tester = new GameGUI(10, 64);
	}
	
	/**
	 * Class for testing that the Maze Game swing panel works correctly
	 **/
	@Test
	public void testGamePanel() {
		GamePanel panel = new GamePanel(10);
		ActionMap amap = panel.getActionMap();
		InputMap imap = panel.getInputMap();
		assertNotNull(amap);
		assertNotNull(imap);
		panel.populate();
		panel.playChest();
		panel.playError();
		panel.playKey();
		panel.playStep();
	}
}
