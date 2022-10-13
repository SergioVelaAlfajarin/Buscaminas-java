package views;

import core.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameView extends JFrame {
	private final Grid g;
	private final JPanel titlePanel, statusPanel, gamePanel, mainPanel;
	private final MainView mv;

	public GameView(Grid g, MainView mv){
		this.g = g;
		this.mv = mv;

		this.mainPanel = new JPanel(new GridLayout(3,1,0,0));
		this.titlePanel = new JPanel(new GridLayout(1,1,0,0));
		this.statusPanel = new JPanel(new GridLayout(1,1,0,0));
		this.gamePanel = new JPanel(new GridLayout(g.getRows(),g.getColumns(),0,0));

		titlePanel.setBackground(Color.BLUE);
		titlePanel.setSize(50, 30);
		titlePanel.add(new JLabel("Title panel"));
		mainPanel.add(titlePanel);

		statusPanel.setBackground(Color.RED);
		statusPanel.setSize(50, 30);
		statusPanel.add(new JLabel("Score panel"));
		mainPanel.add(statusPanel);

		gamePanel.setBackground(Color.YELLOW);
		gamePanel.setSize(50, 30);
		gamePanel.add(new JLabel("Game Panel"));
		mainPanel.add(gamePanel);

		add(mainPanel);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				mv.setVisible(true);
				dispose();
			}
		});
		setResizable(false);

		buildGrid();
		//pack();

		setLocationRelativeTo(null);
	}

	private void buildGrid() {

	}
}
