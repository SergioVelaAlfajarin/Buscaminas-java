package main;

import core.data.Difficulties;
import core.grid.Grid;
import views.GameView;
import views.MainView;

import javax.swing.*;

public class Main {
	//estados del juego
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
	}

	/**
	 * Creates a grid with the chosen difficulty.
	 * @param dif difficulty chosen in the MainView.
	 */
	public static void startGame(Difficulties dif) {
		mainView.hide();
		Grid g = new Grid(dif);
		gameView = new GameView(g);
		gameView.show();
	}

	/**
	 * End the game with the indicated status. 0-won, 1-lost, 2-quit.
	 * @param gameStatus status depending how the gameview has to be closed.
	 */
	public static void endGame(int gameStatus){
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

	/**
	 * Forces exit if some error occurred.
	 * @param msg msg giving feedback of the error.
	 */
	public static void forceExit(String msg){
		JOptionPane.showMessageDialog(null,msg);
		System.exit(-1);
	}

	/**
	 * Forces exit if some error occurred and gives a default message.
	 */
	public static void forceExit(){
		forceExit("Ha ocurrido un error");
	}
}
