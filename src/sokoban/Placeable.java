package sokoban;

public abstract class Placeable {
	public int placeX;
	public int placeY;
	public String symbol;
	
	public String placeable(int X, int Y){
		this.placeX = X;
		this.placeY = Y;
		return this.symbol;
		
	}
	public String toString() {
		return this.symbol;
	}
	
	
}
