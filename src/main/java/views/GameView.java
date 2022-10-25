package views;

import core.cells.Cell;
import core.grid.Grid;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameView{
	private final Grid g;
	private final JFrame frame = new JFrame("Buscaminas");
	private final JPanel gamePanel;
	private boolean gameWon, gameLost;

	public GameView(Grid g){
		this.g = g;
		this.gamePanel = new JPanel(new GridLayout(g.getRows(), g.getColumns(),0,0));

		buildGrid();

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				if(!gameWon && !gameLost){
					Main.endGame(Main.GAME_QUIT);
				}
			}
		});
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	private void buildGrid() {
		Cell[][] cells = g.getCells();
		for (Cell[] c1 : cells) {
			for (Cell c2: c1) {
				gamePanel.add(c2);
			}
		}

		frame.add(gamePanel);
	}

	public void setGameWon(boolean gameWon) {
		this.gameWon = gameWon;
	}

	public void setGameLost(boolean gameLost) {
		this.gameLost = gameLost;
	}

	public void dispose(){
		hide();
		frame.dispose();
	}

	public void show(){
		frame.setVisible(true);
	}

	public void hide(){
		frame.setVisible(false);
	}
}
