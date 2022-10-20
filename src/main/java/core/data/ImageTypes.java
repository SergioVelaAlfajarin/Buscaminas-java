package core.data;

public enum ImageTypes { //TODO muy provisional
	TILE_HIDDEN ("TileHidden_%d.png"),
	TILE_MARKED ("TileMarked_%d.png"),
	TILE_MINE   ("TileMine_%d.png"),
	TILE_SHOWN_0("Tile0_%d.png"),
	TILE_SHOWN_1("Tile1_%d.png"),
	TILE_SHOWN_2("Tile2_%d.png"),
	TILE_SHOWN_3("Tile3_%d.png"),
	TILE_SHOWN_4("Tile4_%d.png"),
	TILE_SHOWN_5("Tile5_%d.png"),
	TILE_SHOWN_6("Tile6_%d.png"),
	TILE_SHOWN_7("Tile7_%d.png"),
	TILE_SHOWN_8("Tile8_%d.png"),
	TILE_SHOWN_9("Tile9_%d.png");

	private final String name;

	ImageTypes(String name){
		this.name = name;
	}

	public String getFileName(int type){
		return String.format(name,type);
	}

	public static ImageTypes getBySurroundedMines(int mines){
		return switch (mines){
			case 0 -> TILE_SHOWN_0;
			case 1 -> TILE_SHOWN_1;
			case 2 -> TILE_SHOWN_2;
			case 3 -> TILE_SHOWN_3;
			case 4 -> TILE_SHOWN_4;
			case 5 -> TILE_SHOWN_5;
			case 6 -> TILE_SHOWN_6;
			case 7 -> TILE_SHOWN_7;
			case 8 -> TILE_SHOWN_8;
			default -> TILE_SHOWN_9;
		};
	}
}
