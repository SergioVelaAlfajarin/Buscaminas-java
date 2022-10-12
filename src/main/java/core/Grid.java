package core;

public class Grid {
	public final int columns, rows;

	public Grid(Difficulties difficulty){
		this.columns = difficulty.cols;
		this.rows = difficulty.rows;
	}


}
