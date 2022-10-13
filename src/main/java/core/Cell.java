package core;

public class Cell {
	public boolean isMine;

	public Cell(){
		
	}

	public void setMine(boolean mine) {
		isMine = mine;
	}

	@Override
	public String toString() {
		return "Cell{" +
				"isMine=" + isMine +
				'}';
	}
}
