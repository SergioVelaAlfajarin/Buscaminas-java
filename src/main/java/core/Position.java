package core;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public record Position(int row, int column) {
	public static Position[] getSurroundingPositions
			(Position p, int maxRow, int maxCol)
	{ //TODO
		int minPosRow = Math.max(0, p.row() -1);
		int maxPosRow = Math.min(maxRow, p.row() + 1);
		int minPosCol = Math.max(0,p.column() - 1);
		int maxPosCol = Math.min(maxCol, p.column() + 1);

		LinkedHashSet<Position> positions = new LinkedHashSet<>();
		positions.add(new Position(minPosRow, minPosCol));
		positions.add(new Position(minPosRow, p.column));
		positions.add(new Position(minPosRow, maxPosCol));
		positions.add(new Position(p.row, minPosCol));
		positions.add(new Position(p.row, maxPosCol));
		positions.add(new Position(maxPosRow, minPosCol));
		positions.add(new Position(maxPosRow, p.column));
		positions.add(new Position(maxPosRow, maxPosCol));
		return positions.toArray(new Position[]{});
	}

	public int getType(){
		return (row % 2 == 0) ?
				((column % 2 == 0) ? 1 : 2) :
				((column % 2 == 0) ? 2 : 1);
	}
}
