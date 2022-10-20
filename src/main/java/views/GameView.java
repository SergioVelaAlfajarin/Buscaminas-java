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
	private final JPanel titlePanel, statusPanel, gamePanel, mainPanel;

	public GameView(Grid g){
		this.g = g;
		this.mainPanel = new JPanel(); // ESTUDIAR LAYOUTS JAVA
		this.titlePanel = new JPanel();
		this.statusPanel = new JPanel();
		this.gamePanel = new JPanel(new GridLayout(g.getRows(), g.getColumns(),0,0));

		buildGrid();
		setPanels();

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //TODO
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	private void setPanels() {
		//titlePanel.setBackground(Color.BLUE);
		//titlePanel.setSize(50, 30);
		//titlePanel.add(new JLabel("Title panel"));

		//statusPanel.setBackground(Color.RED);
		//statusPanel.setSize(50, 30);
		//statusPanel.add(new JLabel("Score panel"));

		//gamePanel.setBackground(Color.YELLOW);
		//gamePanel.setSize(50, 30);
		//gamePanel.add(new JLabel("Game Panel"));

		//mainPanel.add(titlePanel);
		//mainPanel.add(statusPanel);
		//mainPanel.add(gamePanel);

		frame.add(gamePanel);
	}

	private void buildGrid() {
		Cell[][] cells = g.getCells();
		for (Cell[] c1 : cells) {
			for (Cell c2: c1) {
				gamePanel.add(c2);
			}
		}
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
