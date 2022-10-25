package core.grid;

import core.data.Difficulties;
import core.cells.Cell;
import core.cells.Position;
import main.Main;

import java.util.*;

public class Grid {
	private final Difficulties dif;
	private final int CELLS_REQUIRED_TO_WIN;
	private int cellsOpenedCount;
	private final Cell[][] cells;

	public Grid(Difficulties difficulty){
		this.dif = difficulty;
		this.cells = generateGameCells();
		CELLS_REQUIRED_TO_WIN = dif.getCellCount() - dif.mines_count;
		cellsOpenedCount = 0;

		generateMines();
		calculateSurroundingMines();
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


	private void generateMines() {
		ArrayList<Position> randomPositions = generateRandomPos();
		for (Position p : randomPositions) {
			getCellByPos(p).setMine();
		}
	}

	private ArrayList<Position> generateRandomPos() {
		ArrayList<Position> randomPositions = new ArrayList<>();
		Random rn = new Random();
		for (int i = 0; i < dif.mines_count; i++) {
			int row = rn.nextInt(dif.rows);
			int col = rn.nextInt(dif.cols);
			Position p = new Position(row,col);

			while(isPosRepeated(randomPositions, p)){
				row = rn.nextInt(dif.rows);
				col = rn.nextInt(dif.cols);
				p = new Position(row,col);
			}
			randomPositions.add(p);
		}
		System.out.println(randomPositions);
		return randomPositions;
	}

	private boolean isPosRepeated(ArrayList<Position> randomPositions, Position pos) {
		return randomPositions.stream().anyMatch(position -> position.equals(pos));
	}


	private void calculateSurroundingMines() {
		for (Cell[] c1 : cells){
			for (Cell c2 : c1){
				Cell[] surrCells = getSurroundingCells(c2);
				int counter = (int) Arrays.stream(surrCells).filter(Cell::isMine).count();
				c2.setSurroundingMines(counter);
			}
		}
	}

	public Cell[] getSurroundingCells(Cell c){
		int row = c.position.row();
		int col = c.position.column();

		LinkedList<Cell> list = new LinkedList<>();
		list.add(getCellByPos(row - 1, col - 1));
		list.add(getCellByPos(row - 1, col));
		list.add(getCellByPos(row - 1, col + 1));
		list.add(getCellByPos(row, col - 1));
		list.add(getCellByPos(row, col + 1));
		list.add(getCellByPos(row + 1, col - 1));
		list.add(getCellByPos(row + 1, col));
		list.add(getCellByPos(row + 1, col + 1));

		var surroundingCellsRaw = list.stream().filter(Objects::nonNull).toArray();
		var surroundingCells = new Cell[surroundingCellsRaw.length];
		Arrays.setAll(surroundingCells, i -> (Cell) surroundingCellsRaw[i]);

		return surroundingCells;
	}


	public Cell getCellByPos(int row, int col){
		Position p = new Position(row,col);
		return getCellByPos(p);
	}

	public Cell getCellByPos(Position pos){
		return Arrays.stream(cells)
				.flatMap(Arrays::stream)
				.filter(cell -> cell.position.equals(pos))
				.findFirst()
				.orElse(null);
	}

	public void increaseCellsOpened(){
		cellsOpenedCount++;

		if(cellsOpenedCount >= CELLS_REQUIRED_TO_WIN){
			Main.endGame(Main.GAME_WON);
		}
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

	public void openAllMines() {
		for (Cell[] c1 : cells) {
			for (Cell c2 : c1) {
				if (c2.isMine()) {
					c2.openMine();
				}
			}
		}
	}
}
