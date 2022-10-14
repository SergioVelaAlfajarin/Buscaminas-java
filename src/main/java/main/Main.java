package main;

import core.Difficulties;
import core.Grid;
import views.GameView;
import views.MainView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

public class Main {
	private static MainView mainView;
	private static GameView gameView;

	public static void main(String[] args) throws URISyntaxException {
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
		mainView.show();
		//0-display message and come back to dif selection
		//1-same but with quit button
		//exit quietly
	}
}
