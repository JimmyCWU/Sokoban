package sokoban;

public abstract class Moveable extends Placeable  {
	public void addWorker(Worker worker) {
		this.symbol = worker.symbol;
	}
	
	public String addCrate(Crate crate) {
		this.symbol = "X";
		String result = this.symbol;
		return result;
	}
}
