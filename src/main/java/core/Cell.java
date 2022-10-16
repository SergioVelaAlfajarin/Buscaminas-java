package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class Cell extends JLabel implements Comparable<Cell>{
	public final Integer id, type;
	public final ImageIcon img;
	private boolean isMine, isOpened;

	public Cell(int id, int type){
		super();
		this.id = id;
		this.type = type;
		this.isOpened = false;
		this.img = Resources.getCellImage(type);

		setIcon(img);
		setOpaque(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openCell();
			}
		});
	}

	private void openCell() {
		System.out.print("clicked: ");
		System.out.println(this);
	}

	public void setMine(){
		this.isMine = true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Cell cell)) return false;
		return id.equals(cell.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Cell{" +
				"id=" + id +
				", type=" + type +
				", img=" + img +
				", isMine=" + isMine +
				'}';
	}

	@Override
	public int compareTo(Cell o) {
		return id.compareTo(o.id);
	}
}
