package sokoban;

public class Empty extends Enterable {		
		public  Empty(int X, int Y) {
			this.placeX = X;
			this.placeY = Y;
			this.symbol = ".";
		}
		public void addWorker(Worker worker) {
			super.symbol = worker.symbol;

		}
		public String addCrate(Crate crate) {
			this.symbol = "x";
			String result = this.symbol;
			return result;
		}
		public String toString() {
			return this.symbol;
		}
}
