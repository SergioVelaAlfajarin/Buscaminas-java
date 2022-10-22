package views;

import core.data.Difficulties;
import main.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Locale;

public class MainView {
	private final JFrame frame = new JFrame("Buscaminas");
	private final JPanel panel = new JPanel();

	public MainView(){
		frame.setSize(250,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		setContent();
		buildButtons();
		frame.add(panel);
		frame.setLocationRelativeTo(null);
	}

	private void setContent() {
		var layout = new GridLayout(Difficulties.getValuesCount(),1);
		layout.setVgap(30);
		layout.layoutContainer(panel);
		panel.setLayout(layout);
		panel.setBorder(new EmptyBorder(20,20,20,20));
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

	private void onClick(ActionEvent e) {
		String actionCmd = e.getActionCommand();
		Difficulties dif = Difficulties.getByName(actionCmd).orElse(Difficulties.EASY);
		Main.startGame(dif);
	}
}
