package core;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class PositionTest {

	@org.junit.jupiter.api.Test
	void getSurroundingPositionsTest() {
		Grid grid = new Grid(Difficulties.HARD);

		Position[] positions = Position.getSurroundingPositions(
				new Position(1,1),
				grid.getRows(),
				grid.getColumns()
		);

		Position[] positions2 = Position.getSurroundingPositions(
				new Position(10,10),
				grid.getRows(),
				grid.getColumns()
		);

		Position[] positions3 = Position.getSurroundingPositions(
				new Position(0,0),
				grid.getRows(),
				grid.getColumns()
		);

		System.out.println(Arrays.toString(positions));
		System.out.println(Arrays.toString(positions2));
		System.out.println(Arrays.toString(positions3));
	}
}