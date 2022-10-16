package core;

import java.util.*;

public class Grid {
	public final Difficulties dif;
	private final Cell[] cells;

	public Grid(Difficulties difficulty){
		this.dif = difficulty;
		this.cells = generateGameCells();

		generateMines();
	}

	private void generateMines() {
		ArrayList<Integer> randomPos = new ArrayList<>();
		Random rn = new Random();

		for (int i = 0; i < dif.mines_count; i++) {
			int random = rn.nextInt(cells.length);
			while(isRepeated(random, randomPos)){
				random = rn.nextInt(cells.length);
			}
			randomPos.add(random);
			cells[random].setMine();
		}
	}

	private boolean isRepeated(int num, ArrayList<Integer> list) {
		return list.stream().mapToInt(i -> i).anyMatch(i -> i == num);
	}

	private Cell[] generateGameCells() {
		ArrayList<Cell> list = new ArrayList<>();
		for (int i = 0; i < dif.rows; i++) {
			Cell[] row = generateRow(i);
			list.addAll(List.of(row));
		}
		return list.toArray(new Cell[]{});
	}

	private Cell[] generateRow(int i) {
		Cell[] array = new Cell[dif.cols];
		if(i % 2 == 0){
			for (int j = 0; j < dif.cols; j++) {
				int type = j % 2 == 0 ? 1 : 2;
				int id = (j + 1) + (i * 8);
				array[j] = new Cell(id, type);
			}
		}else{
			for (int j = 0; j < dif.cols; j++) {
				int type = j % 2 == 0 ? 2 : 1;
				int id = (j + 1) + (i * 8);
				array[j] = new Cell(id, type);
			}
		}
		return array;
	}

	public Difficulties getDif() {
		return dif;
	}

	public Cell[] getCells() {
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
