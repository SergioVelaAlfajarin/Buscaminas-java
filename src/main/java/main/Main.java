package main;

import core.Difficulties;
import core.Grid;
import views.MainView;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		new MainView().setVisible(true);

		Grid g = new Grid(Difficulties.EASY);
		System.out.println(Arrays.toString(g.getCells()));
		System.out.println(g.getDif());
	}
}
