package core;

import java.awt.*;

public class Cell {
	public final Image img;
	public boolean isMine;

	public Cell(int type){
		this.img = null;
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
