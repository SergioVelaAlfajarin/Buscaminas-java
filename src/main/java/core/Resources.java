package core;

import javax.swing.*;

public class Resources {
	public static ImageIcon getCellImage(int type) {
		return switch (type){
			case 1 -> new ImageIcon("src/main/resources/Tile1.png");
			default -> new ImageIcon("src/main/resources/Tile2.png");
		};
	}
}
