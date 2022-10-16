package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell {
	public final Integer id, type;
	public final ImageIcon img;
	public final JLabel lbl;
	private boolean isMine;

	public Cell(int id, int type){
		this.id = id;
		this.type = type;
		this.img = Resources.getCellImage(type);
		this.lbl = new JLabel(img);
		lbl.setOpaque(false);
		lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(this.toString());
			}
		});
	}

	public void setMine(){
		this.isMine = true;
	}

	@Override
	public String toString() {
		return "Cell{" +
				"id=" + id +
				", img=" + img +
				", type=" + type +
				", isMine=" + isMine +
				'}';
	}
}
