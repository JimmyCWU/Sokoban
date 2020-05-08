package sokoban;

public abstract class Enterable extends Placeable {
	public void addWorker(Worker worker) {
		this.symbol = worker.symbol;

	}
	public void addTarget(Target target) {
		this.symbol = target.symbol;
	}
	
	public String addCrate(Crate crate) {
		this.symbol = "X";
		return this.symbol;
	}

}
	
