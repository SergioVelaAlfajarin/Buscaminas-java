package main;

import core.data.Difficulties;
import core.grid.Grid;
import views.GameView;
import views.MainView;

import javax.swing.*;

public class Main {
	public static final int GAME_QUIT = 1,
			MINE_CLICKED = 2,
			GAME_WON = 0,
			ERROR = -1;

	private static MainView mainView;
	private static GameView gameView;

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			mainView = new MainView();
			mainView.show();
		});
		/*
		URL is = Main.class.getClassLoader().getResource("Tile1.png");
		File f = new File(is.toURI());
		System.out.println(f.getAbsolutePath());

		Grid g = new Grid(Difficulties.EASY);
		System.out.println(Arrays.toString(g.getCells()));
		System.out.println(g.getDif());*/
	}

	public static void startGame(Difficulties dif) {
		mainView.hide();
		Grid g = new Grid(dif);
		gameView = new GameView(g);
		gameView.show();
	}

	public static void endGame(int status){ //0-won, 1-lost, 2-quit
		JOptionPane.showMessageDialog(null,"Status: " + status);
		gameView.dispose();
		mainView.show();
		//0-display message and come back to dif selection
		//1-same but with quit button
		//exit quietly
	}
}
