package core.cells;

public record Position(int row, int column) {
	public int getType(){
		return (row % 2 == 0) ?
				((column % 2 == 0) ? 1 : 2) :
				((column % 2 == 0) ? 2 : 1);
	}
}
