package core;

import java.util.*;

public class Grid {
	public final Difficulties dif;
	private final Cell[][] cells;

	public Grid(Difficulties difficulty){
		this.dif = difficulty;
		this.cells = generateGameCells();

		generateMines();
	}

	private void generateMines() {
		ArrayList<Integer> randomPositions = new ArrayList<>();
		Random rn = new Random();


	}

	private Cell[][] generateGameCells(){
		Cell[][] tempCells = new Cell[dif.rows][dif.cols];
		for (int currentRow = 0; currentRow < tempCells.length; currentRow++) {//recorre rows de 0 a dif.rows - 1 ambos inclusives
			tempCells[currentRow] = generateRow(currentRow);
		}
		return tempCells;
	}

	private Cell[] generateRow(int currentRow) {
		Cell[] tempCells = new Cell[dif.cols];
		for (int currentCol = 0; currentCol < tempCells.length; currentCol++) {
			Position pos = new Position(currentRow, currentCol);
			Cell cell = new Cell(this, pos);
			tempCells[currentCol] = cell;
		}
		return tempCells;
	}



	public Difficulties getDif() {
		return dif;
	}

	public Cell[][] getCells() {
		return cells;
	}

	public int getRows(){
		return dif.rows;
	}

	public int getColumns(){
		return dif.cols;
	}

	public int getMinesCount(){
		return dif.mines_count;
	}

}
