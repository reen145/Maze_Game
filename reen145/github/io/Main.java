/*************************************************************************************************
Title:
Filename: 
@author: 
@version 1.0
Due Date:
Instructor:
Description:
**************************************************************************************************/
package reen145.github.io;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JPanel {
	private static final long serialVersionUID = 1L;
	private final int SIZE = 10;
	private JLabel[][] matrix;
	private JMenuItem gameItem;
	private JMenuItem quitItem;
	private ImageIcon iconBlank;
	private ImageIcon iconPlayer1;
	private ImageIcon iconPlayer2;

	public Main() {
		
		setLayout(new GridLayout(SIZE + 1, SIZE)); // room for top row

		iconBlank = new ImageIcon("");
		iconPlayer1 = new ImageIcon("");
		iconPlayer2 = new ImageIcon("");

		matrix = new JLabel[SIZE][SIZE];

		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				matrix[row][col] = new JLabel("", iconBlank, SwingConstants.CENTER);
				add(matrix[row][col]);
			}
		}
	}
	
	public static void main (String[] args) {
		JMenuBar menus;
		JMenu fileMenu;
		JMenuItem quitItem;
		JMenuItem gameItem;

		JFrame frame = new JFrame("The Maze Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fileMenu = new JMenu("File");
		quitItem = new JMenuItem("quit");
		gameItem = new JMenuItem("new game");

		fileMenu.add(gameItem);
		fileMenu.add(quitItem);
		menus = new JMenuBar();
		frame.setJMenuBar(menus);
		menus.add(fileMenu);
		
		Main panel = new Main();
		frame.getContentPane().add(panel);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

}
