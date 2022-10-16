package core;

import java.util.*;

public class Grid {
	public final Difficulties dif;
	private final Cell[] cells;

	public Grid(Difficulties difficulty){
		this.dif = difficulty;
		this.cells = generateGameCells();

		System.out.println();
		//generateMines();
	}

	private void generateMines() {
		ArrayList<Integer> randomPos = new ArrayList<>();
		Random rn = new Random();

		for (int i = 0; i < dif.mines_count; i++) {
			int random = rn.nextInt(cells.length);
			while(isRepeated(random, randomPos)){
				random = rn.nextInt(cells.length);
				System.out.println("generated repeated number.");
			}
			randomPos.add(random);
			cells[random].setMine();
		}
	}

	private boolean isRepeated(int num, ArrayList<Integer> list) {
		return list.stream().mapToInt(i -> i).anyMatch(i -> i == num);
	}

	private Cell[] generateGameCells() {
		var cells = new Cell[dif.getCellCount()]; //10, 14
		for (int i = 0; i < cells.length; i+=2) { //pares
			cells[i] = new Cell(i,1);
		}
		for (int i = 1; i < cells.length; i+=2) { //impares
			cells[i]= new Cell(i,2);
		}
		Arrays.sort(cells, (o1, o2) -> o1.id.compareTo(o2.id));
		return cells;
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
