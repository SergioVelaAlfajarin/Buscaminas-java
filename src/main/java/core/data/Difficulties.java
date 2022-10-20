package core.data;

import java.util.Optional;

public enum Difficulties {
	EASY(8,10,10),
	MEDIUM(14,18,40),
	HARD(20,24,99),
	INSANE(26,30,160);

	public final int rows, cols, mines_count;

	Difficulties(int rows, int cols, int mines_count){
		this.rows = rows;
		this.cols = cols;
		this.mines_count = mines_count;
	}

	public int getCellCount(){
		return rows * cols;
	}

	public static int getValuesCount(){
		return values().length;
	}

	public static Optional<Difficulties> getByName(String name){
		Optional<Difficulties> op = Optional.empty();
		for (Difficulties dif: Difficulties.values()) {
			if(dif.name().equalsIgnoreCase(name)){
				op = Optional.of(dif);
			}
		}
		return op;
	}
}
