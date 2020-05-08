package sokoban;

public class Wall extends Immoveable {
	public Wall(int X, int Y) {
		this.placeX = X;
		this.placeY = Y;
		this.symbol = "#";
	}
	public String toString() {
		return this.symbol;
	}

}
