package sokoban;

import java.util.ArrayList;
import java.util.List;


public class Game {
	protected int levelCount;
	protected String currentLevel = "no levels";
	public String levelName = "";
	protected List<Level> levels = new ArrayList<Level>();
	public int listOfGames= 0;
	public String result;
	protected String newArr;
	protected Placeable[] [] allPlaceables;
	protected Placeable[][] allPlaceables2;
	protected Point point;
    public  int move = 0;
	public int completed = 0;

	
	public void initGame() {
		Level level = this.levels.get(listOfGames -1);
		this.allPlaceables = new Placeable[level.height][level.width];
	    int index = 0;
		for(int i = 0 ; i < level.height; i++) {
			for(int j = 0 ; j< level.width; j++) {
				char symbol = level.table.charAt(index);
				Placeable placeable = this.makePlacable(i, j, symbol);
				this.allPlaceables[i] [j] = placeable;
				index++;
			}
		}
	}
	public void getSecondBroad() {
		Level level = this.levels.get(listOfGames -1);
		this.allPlaceables2 = new Placeable[level.height][level.width];
		int index = 0;
		for(int i = 0 ; i < level.height; i++) {
			for(int j = 0 ; j< level.width; j++) {
				char symbol = level.table.charAt(index);
				Placeable placeable = this.makePlacable(i, j, symbol);
				this.allPlaceables2[i] [j] = placeable;
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

	
	public void addLevel(String name, int h, int w, String table) {
		Level level = new Level(name, h, w, table);
		this.levels.add(level);
		listOfGames++;
		initGame();
		
        
	}
	

	
	public void move(Direction direction) {
		getSecondBroad();
		int currentX =0 ;
		int currentY= 0 ;
		// get current w location
		for(int i = 0 ; i < 5; i++) {
			for(int j = 0 ; j< 6; j++) {
				//System.out.print(this.allPlaceables[i][j].toString());
				if(this.allPlaceables[i][j].toString().equals("w")) {
					currentX = i;
					currentY = j;
				}else if (this.allPlaceables[i][j].toString().equals("W")) {					
					currentX = i;
					currentY = j;
				}
			}
		}
		this.point = new Point(currentX ,currentY);
		
		//find the target location
		int targetX = currentX+ direction.adjustX;
		int targetY = currentY+ direction.adjustY;
		int crateX = currentX + direction.adjustX + direction.adjustX;
		int crateY = currentY + direction.adjustY + direction.adjustY;
	
		//send the location back to worker
		Worker worker = new Worker(currentX,currentY );
		Placeable targetEnterable = this.allPlaceables[targetX][targetY];
		
		//Empty empty = (Empty) this.allPlaceables[targetX][targetY];
		//Target target = (Target) this.allPlaceables[targetX][targetY];
		
		
		
		String obj = this.allPlaceables[targetX][targetY].toString();
		String org = this.allPlaceables[currentX][currentY].toString();
		
		String org_new = this.allPlaceables2[currentX][currentY].toString();
		String obj_new = this.allPlaceables2[targetX][targetY].toString();
		
		
	
		
		if(obj == "."){
			this.move++;
			((Enterable) targetEnterable).addWorker(worker);
			if(org_new.equals("w")) {
				
				this.allPlaceables[currentX][currentY] = this.allPlaceables2[targetX][targetY];

			}
			else if(org_new.equals("+")){
				this.allPlaceables[targetX][targetY] = new Worker(currentX,currentY);
				this.allPlaceables[currentX][currentY] = this.allPlaceables2[currentX][currentY];
			}
			else {
				this.allPlaceables[currentX][currentY] = this.allPlaceables2[currentX][currentY];
			}
					
		}
		else if(obj == "+" ) {
			this.move++;
			((Enterable) targetEnterable).addWorker(worker);
			//target.addWorker(worker);
			//targetEnterable.addWorker(worker);
			//target.addWorker(worker);
			if(org_new.equals("w")) {
				
				this.allPlaceables[currentX][currentY] = this.allPlaceables2[targetX][targetY];
				this.allPlaceables[currentX][currentY] = new Empty(currentX,currentY);
				
			}
			else{
				this.allPlaceables[currentX][currentY] = new Empty(currentX,currentY);
			}			
		}
		else if(obj == "#") {
			this.move++;			
		}
		else if(obj == "x" || obj == "X") {
			this.move++;	
			String nextOfCrate = this.allPlaceables[crateX][crateY].toString();
			Placeable targetCrate = this.allPlaceables[crateX][crateY];
			Crate crate = new Crate(crateX, crateY);
			if(nextOfCrate.equals("+")) {
				((Enterable) targetEnterable).addWorker(worker);	
				this.allPlaceables[currentX][currentY] = this.allPlaceables2[currentX][currentY];
				//this.allPlaceables[currentX][currentY] = new Target(currentX,currentY);
				
				((Enterable) targetCrate).addCrate(crate);
				//this.allPlaceables[crateX][crateY] = ;
				completed++;
			}
			else if (nextOfCrate.equals("#")) {
				this.allPlaceables[currentX][currentY] = this.allPlaceables[currentX][currentY];
				this.allPlaceables[targetX][targetY] = this.allPlaceables[targetX][targetY];
			}			
		
		}
		

		for(int i = 0 ; i < 5; i++) {
			for(int j = 0 ; j< 6; j++) {
				System.out.print(this.allPlaceables[i][j].toString());
			}
			 System.out.println();
		}
		System.out.println("move " + "" +this.move);
		System.out.println("completed " + this.completed + " of 2" + "\n");
    }
	
	public  String getMovingResult() {
		List<String> list = new ArrayList<String>();
		String res ="";
		for(int i = 0 ; i < 5; i++) {
			for(int j = 0 ; j< 6; j++) {
					result = this.allPlaceables[i][j].toString();
					list.add(result);					
			}
		  }
		for (String s : list)
		{
		    res += s ;
		}
		
		return res;
		}

	public int getLevelCount() {
		return listOfGames;
	}
	public String toString() {
		if(listOfGames == 0) {
			result = "no levels";
		}else {
			result = "Level" + Integer.toString(listOfGames);			
		}
		return result;
	}
	public String getCurrentLevelName() {
		if(listOfGames == 0) {
			result = "no levels";
		}else {
			result = this.levels.get(listOfGames -1).name;
		}
		return result;
	}
	public List<String> getLevelNames() {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < this.levels.size() ; i++ ) {
			result = this.levels.get(i).name;
			list.add(result);
		}
		return list;
	
	
	}

	

}
