package views;

import core.Cell;
import core.Grid;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameView{
	private final Grid g;
	private final JFrame frame = new JFrame("Buscaminas");
	private final JPanel titlePanel, statusPanel, gamePanel, mainPanel;
	private int gameStatus;

	public GameView(Grid g){
		this.g = g;
		this.mainPanel = new JPanel(); // ESTUDIAR LAYOUTS JAVA
		this.titlePanel = new JPanel();
		this.statusPanel = new JPanel();
		this.gamePanel = new JPanel(new GridLayout(g.getRows(), g.getColumns(),0,0));
		this.gameStatus = 2; //2=game quitted

		buildGrid();
		setPanels();

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				hide();
				frame.dispose();
				Main.endGame(gameStatus);
			}
		});
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	private void setPanels() {
		titlePanel.setBackground(Color.BLUE);
		//titlePanel.setSize(50, 30);
		titlePanel.add(new JLabel("Title panel"));

		statusPanel.setBackground(Color.RED);
		//statusPanel.setSize(50, 30);
		statusPanel.add(new JLabel("Score panel"));

		//gamePanel.setBackground(Color.YELLOW);
		//gamePanel.setSize(50, 30);
		//gamePanel.add(new JLabel("Game Panel"));

		mainPanel.add(titlePanel);
		mainPanel.add(statusPanel);
		mainPanel.add(gamePanel);

		frame.add(mainPanel);
	}

	private void buildGrid() {
		Cell[] cells = g.getCells();
		for(Cell c: cells){
			gamePanel.add(c);
			//System.out.println(c);
		}
	}

	public void show(){
		frame.setVisible(true);
	}

	public void hide(){
		frame.setVisible(false);
	}
}
