package sokoban;

import java.util.ArrayList;
import java.util.List;

public class Level {
	private static final String Arr_result = null;
	protected int width;
	protected int height;
	protected int move_count = 0;
	protected String name;
	protected String table;
	protected int complete_count = 0;
	protected int target_count = 1;
	protected Placeable[][] allPlaceables;
	protected Point point;
	public int listOfGames= 0;
	protected List<Level> levels = new ArrayList<Level>();
	protected String result;
	
	public Level(String name2, int h, int w, String table2) {
		// TODO Auto-generated constructor stub
		this.name = name2;
		this.height = h;
		this.width = w;
		this.table = table2;	
	}
	
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	public int getMoveCount() {
		return this.move_count;
	}
	public String getName() {
		return this.name;
	}
	public int getCompletedCount() {
		return this.complete_count;
	}
	public int targetCount() {
		return this.target_count;
	}
	public void initGame() {
		//Level level = this.levels.get(listOfGames -1);
		this.allPlaceables = new Placeable[this.height][this.width];
	    int index = 0;
		for(int i = 0 ; i < this.height; i++) {
			for(int j = 0 ; j< this.width; j++) {
				char symbol = this.table.charAt(index);
				Placeable placeable = this.makePlacable(i, j, symbol);
				this.allPlaceables[i] [j] = placeable;
				index++;
			}
		}
	}
	public Placeable makePlacable(int x, int y, char symbol) {
		Placeable placeable =null;
		switch (symbol) {
		case '#':
			placeable = new Wall(x,y);
			break;
		case '.':
			placeable = new Empty(x,y);
			break;
		case 'x':
			placeable = new Crate(x,y);
			break;
		case '+':
			placeable = new Target(x,y);
			break;
		case 'w':
			placeable = new Worker(x,y);
			break;
		
		}
			
		return placeable;
	}
	public String toString() {
		initGame();
		List<String> list = new ArrayList<String>();
		String res ="";
		for(int i = 0 ; i < this.height; i++) {
			for(int j = 0 ; j<this.width ; j++) {
					result = this.allPlaceables[i][j].toString();
					if (j==this.height) {
						list.add(result);
						list.add("\n");			
					} 
					else {
						list.add(result);						
					}
				}
			}
		for (String s : list)
			{
		    	res += s ;
			}	
		return this.name + "\n" + res + "move " +  this.move_count + "\n" + "completed " 
		      +this.complete_count + " of "
			+ this.target_count + "" + "\n";		
	}
}




