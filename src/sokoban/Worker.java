package sokoban;

public class Worker extends Placeable{

	public Worker (int X, int Y) {
		//super();
		this.placeX = X;
		this.placeY = Y;
		this.symbol = "w";
	}
	public String toString() {
		return this.symbol;
	}
}
