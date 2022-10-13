package views;

import core.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameView extends JFrame {
	private final Grid g;
	private final JPanel panel;
	private final MainView mv;

	public GameView(Grid g, MainView mv){
		this.g = g;
		this.panel = new JPanel(new GridLayout(g.rows,g.columns));
		this.mv = mv;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				mv.setVisible(true);
				dispose();
			}
		});
		setResizable(false);
		add(panel);
		buildGrid();

		pack();
		setLocationRelativeTo(null);
	}

	private void buildGrid() {

	}
}
