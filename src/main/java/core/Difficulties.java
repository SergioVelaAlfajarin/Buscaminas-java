package core;

public enum Difficulties {
	EASY(8,10,10),
	MEDIUM(14,18,40),
	HARD(20,24,99);

	public final int rows, cols, mines_count;

	Difficulties(int rows, int cols, int mines_count){
		this.rows = rows;
		this.cols = cols;
		this.mines_count = mines_count;
	}
}
