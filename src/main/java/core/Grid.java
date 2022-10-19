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
	

	public Cell getCellByPos(Position pos){
		return Arrays.stream(cells)
				.flatMap(Arrays::stream)
				.filter(cell -> cell.position.equals(pos))
				.findFirst()
				.orElse(null);
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
