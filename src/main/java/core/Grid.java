package core;

public class Grid {
	public final int columns, rows;

	private final Cell[][] cells;

	public Grid(Difficulties difficulty){
		this.columns = difficulty.cols;
		this.rows = difficulty.rows;
		this.cells = generateGameCells();
	}

	private Cell[][] generateGameCells() {
		return new Cell[0][];
	}
}
