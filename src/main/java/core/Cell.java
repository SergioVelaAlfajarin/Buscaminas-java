package core;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class Cell extends JLabel implements Comparable<Cell>{
	public final Integer id, type;
	public ImageIcon img;
	private boolean isMine, isOpened, isMarked;
	private int surroundingMines = 0;

	public Cell(int id, int type){
		super();
		this.id = id;
		this.type = type;
		this.isMine = false;
		this.isOpened = false;
		this.isMarked = false;
		this.img = Resources.getCellImage(ImageTypes.TILE_HIDDEN, type);

		setIcon(img);
		setSize(img.getIconWidth(),img.getIconHeight());
		setOpaque(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				openCell(e);
			}
		});
	}

	public void updateIcon(){ //updates by surrounding cells
		if(isMarked) { //if marked
			this.img = Resources.getCellImage(ImageTypes.TILE_MARKED, type);
		}else if(isMine && isOpened){
			this.img = Resources.getCellImage(ImageTypes.TILE_MINE,type);
		}else if(!isOpened){ //if not marked and not opened
			this.img = Resources.getCellImage(ImageTypes.TILE_HIDDEN,type);
		}else{ //if not marked and opened
			this.img = Resources.getCellImage(surroundingMines,type);
		}
		super.setIcon(img);
	}

	public void updateIcon(ImageTypes imgType){ //updates by chose imgtype
		this.img = Resources.getCellImage(imgType,type);
		super.setIcon(img);
	}

	private void openCell(MouseEvent e) {

		if(isOpened){
			return;
		}
		if (SwingUtilities.isRightMouseButton(e)) {
			this.isMarked = !this.isMarked;
			updateIcon();
		}else if (SwingUtilities.isLeftMouseButton(e)) {
			if(isMine){
				//Main.endGame(Main.MINE_CLICKED);
				System.out.println("pulsaste una mina");
			}
			this.isOpened = true;
			updateIcon();
		}
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

	public boolean isMine() {
		return isMine;
	}

	@Override
	public int compareTo(Cell o) {
		return id.compareTo(o.id);
	}
}
