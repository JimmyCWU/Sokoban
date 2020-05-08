package sokoban;

public class Point extends Placeable {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	
}
