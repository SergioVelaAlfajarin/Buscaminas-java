package core;

import core.cells.Position;
import core.data.Difficulties;
import core.grid.Grid;

import java.util.Arrays;

class PositionTest {

	@org.junit.jupiter.api.Test
	void getSurroundingPositionsTest() {
		Grid grid = new Grid(Difficulties.HARD);

		Position[] positions = grid.getSurroundingPositions(new Position(1,1));
		Position[] positions2 = grid.getSurroundingPositions(new Position(8,12));
		Position[] positions3 = grid.getSurroundingPositions(new Position(0,0));

		System.out.println(Arrays.toString(positions));
		System.out.println(Arrays.toString(positions2));
		System.out.println(Arrays.toString(positions3));
	}
}