package sokoban;

public class Crate extends Enterable{
	public Crate (int X, int Y) {
		this.placeX = X;
		this.placeY = Y;
		this.symbol = "x";
	}
	public String toString() {
		return this.symbol;
	}
}
