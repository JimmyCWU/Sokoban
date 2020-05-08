package sokoban;

public enum Direction {
	UP(-1,0) ,DOWN(1,0),LEFT(0,-1),RIGHT(0,1);
	
	public int adjustX;
	public int adjustY;

	private Direction(int X, int Y) {
		this.adjustX = X;
		this.adjustY = Y;
	}

}


