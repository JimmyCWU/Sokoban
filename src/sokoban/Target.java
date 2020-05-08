package sokoban;

public class Target extends Enterable{
	
	public Target (int X, int Y) {
		this.placeX = X;
		this.placeY = Y;
		this.symbol = "+";
	}

	public void addWorker(Worker worker) {
		
		super.symbol = "W";

		//return result;
	}
	public String addCrate(Crate crate) {
		this.symbol = "X";
		String result = this.symbol;
		return result;
	}
	public String toString() {
		return this.symbol;
	}
	
}
