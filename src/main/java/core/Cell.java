package core;

import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class Cell extends JLabel{
	public final int type;
	public final Position position;
	public final Grid grid;
	public ImageIcon img;
	private boolean isMine, isOpened, isMarked;
	private int surroundingMines = 0;

	public Cell(Grid g, Position p){
		super();
		this.position = p;
		this.type = p.getType();
		this.grid = g;
		this.isMine = false;
		this.isOpened = false;
		this.isMarked = false;
		this.img = Resources.getCellImage(ImageTypes.TILE_HIDDEN, type);

		setSize(img.getIconWidth(),img.getIconHeight());
		setIcon(img);
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

	private void openCell(MouseEvent e) {
		System.out.println(this);
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
			this.isMarked = false;
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
		return type == cell.type && position.equals(cell.position);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, position);
	}

	@Override
	public String toString() {
		return "Cell{" +
				"type=" + type +
				", position=" + position +
				", img=" + img +
				", isMine=" + isMine +
				", isOpened=" + isOpened +
				", isMarked=" + isMarked +
				", surroundingMines=" + surroundingMines +
				'}';
	}
}
