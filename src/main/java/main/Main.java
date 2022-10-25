package main;

import core.data.Difficulties;
import core.grid.Grid;
import views.GameView;
import views.MainView;

import javax.swing.*;

public class Main {
	public static final int GAME_QUIT = 1,
			MINE_CLICKED = 2,
			GAME_WON = 0;

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

	public static void endGame(int gameStatus){ //0-won, 1-lost, 2-quit
		if(gameStatus == Main.GAME_WON){
			JOptionPane.showMessageDialog(null,"Has ganado");
			gameView.setGameWon(true);
		}else if (gameStatus == Main.MINE_CLICKED){
			JOptionPane.showMessageDialog(null,"Has hecho click en una bomba");
			gameView.setGameLost(true);
		}
		gameView.dispose();
		mainView.show();
	}

	public static void forceExit(String msg){
		JOptionPane.showMessageDialog(null,msg);
		System.exit(-1);
	}

	public static void forceExit(){
		forceExit("Ha ocurrido un error");
	}
}
