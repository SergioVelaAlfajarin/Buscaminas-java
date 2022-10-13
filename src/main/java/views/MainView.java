package views;

import core.Difficulties;
import core.Grid;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Locale;

public class MainView extends JFrame {
	private final JPanel panel;

	public MainView(){
		this.panel = new JPanel();

		setSize(250,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setContent();
		buildButtons();
		setLocationRelativeTo(null);
	}

	private void setContent() {
		var layout = new GridLayout(Difficulties.getValuesCount(),1);
		layout.setVgap(30);
		layout.layoutContainer(panel);
		panel.setLayout(layout);
		panel.setBorder(new EmptyBorder(20,20,20,20));
		add(panel);
	}

	private void buildButtons() {
		Arrays.stream(Difficulties.values())
				.forEach(dif ->{
					JButton btn = new JButton(dif.name());
					btn.setLocale(Locale.ROOT);
					btn.addActionListener(this::onClick);
					panel.add(btn);
				});
	}

	private void onClick(ActionEvent e) {
		String actionCmd = e.getActionCommand();
		Difficulties dif = Difficulties.getByName(actionCmd).orElse(Difficulties.EASY);
		Grid g = new Grid(dif);
		startGame(g);
	}

	private void startGame(Grid g) {
		setVisible(false);
		GameView gm = new GameView(g, this);
		gm.setVisible(true);
	}
}
