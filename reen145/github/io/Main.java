/*******************************************************************************
Title:
Filename: 
@author: 
@version 1.0
Due Date:
Instructor:
Description:
*******************************************************************************/
package reen145.github.io;

import java.applet.Applet;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/****************************************************************.
Class for the main jPanel to be used in the maze game
*****************************************************************/
public class Main extends JPanel {
	private static final long serialVersionUID = 1L;
	private int size = 10;
	private JLabel[][] matrix;
	private JMenuItem gameItem;
	private JMenuItem quitItem;
	private ImageIcon iconBlank;
	
	/****************************************************************.
    Constructor creates a jPanel for the maze game
    @param none
    *****************************************************************/
	public Main() {

		iconBlank = new ImageIcon("");

		matrix = new JLabel[size][size];
		 
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
			}
		}
	}
	
	/****************************************************************.
    Main method for the maze game
    @param args arguments that can be passed to the main method
    *****************************************************************/
	public static void main(final String[] args) {
		int size = 10;
		JMenuBar menus;
		JMenu fileMenu;
		JMenuItem quitItem;
		JMenuItem gameItem;

		JFrame frame = new JFrame("The Maze Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(size + 1, size));

		fileMenu = new JMenu("File");
		quitItem = new JMenuItem("quit");
		gameItem = new JMenuItem("new game");

		fileMenu.add(gameItem);
		fileMenu.add(quitItem);
		menus = new JMenuBar();
		frame.setJMenuBar(menus);
		menus.add(fileMenu);
		
		Main panel = new Main();
		frame.add(panel);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

}
