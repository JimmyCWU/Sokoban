package sokoban_tests;
import sokoban.Direction;


import sokoban.Game;
import sokoban.Level;
import sokoban.Placeable;
import sokoban.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestMoving {
	static Game game;
	
	@BeforeAll
    public static void setUp() {
	    game = new Game(); 
		game.addLevel("Test1", 5, 6,
                "######" +
                "#+x+.#" +
                "#..w.#" +
                "#....#" +
                "######" );
			}
    @Test
    void testA() {
    	//testing the worker go down
    	game.move(Direction.DOWN);
    	String actualLevelCount = game.getMovingResult();
    	String expectedStartingString = "######" + 
    			"#+x+.#" + 
    			"#....#" + 
    			"#..w.#" + 
    			"######";
		assertEquals(expectedStartingString, actualLevelCount);		   
	}
    @Test
    void testB() {
    	//testing the worker go left
    	game.move(Direction.LEFT);
    	String actualLevelCount = game.getMovingResult();
    	String expectedStartingString = "######" + 
    			"#+x+.#" + 
    			"#....#" + 
    			"#.w..#" + 
    			"######";
		assertEquals(expectedStartingString, actualLevelCount);		   
	}
    @Test
    void testC() {
    	//testing the worker go up
    	game.move(Direction.UP);
    	String actualLevelCount = game.getMovingResult();
    	String expectedStartingString = "######" + 
    			"#+x+.#" + 
    			"#.w..#" + 
    			"#....#" + 
    			"######";
		assertEquals(expectedStartingString, actualLevelCount);		   
	}
    @Test
    void testD() {
    	game.move(Direction.RIGHT);
    	String actualLevelCount = game.getMovingResult();
    	String expectedStartingString = "######" + 
    			"#+x+.#" + 
    			"#..w.#" + 
    			"#....#" + 
    			"######";
		assertEquals(expectedStartingString, actualLevelCount);		   
	}
    @Test
    void testE() {
    	//MOVE RIGHT, NEXT TO WALL
    	game.move(Direction.RIGHT);
    	String actualLevelCount = game.getMovingResult();
    	String expectedStartingString = "######" + 
    			"#+x+.#" + 
    			"#...w#" + 
    			"#....#" + 
    			"######";
		assertEquals(expectedStartingString, actualLevelCount);		   
	}
    @Test
    void testF() {
    	//ATTEMPT RIGHT INTO WALL
    	game.move(Direction.RIGHT);
    	String actualLevelCount = game.getMovingResult();
    	String expectedStartingString = "######" + 
    			"#+x+.#" + 
    			"#...w#" + 
    			"#....#" + 
    			"######";
		assertEquals(expectedStartingString, actualLevelCount);		   
	} 
    @Test
    void testG() {
    	/*when the worker is trying to get into box, 
    	then moving step will add one*/
    	int actualLevelCount = game.move;
    	int expectedStartingString = 6;
    			
		assertEquals(expectedStartingString, actualLevelCount);		   
	}
    @Test
    void testH() {
    	game.move(Direction.UP);
    	game.move(Direction.LEFT);
    	String actualLevelCount = game.getMovingResult();
    	String expectedStartingString = "######" + 
    			"#+xW.#" + 
    			"#....#" + 
    			"#....#" + 
    			"######";
		assertEquals(expectedStartingString, actualLevelCount);		   
	}

    @Test
    void testI() {
    	int actualLevelCount = game.completed;
    	int expectedStartingString = 0;
    			
		assertEquals(expectedStartingString, actualLevelCount);		   
	}

    @Test
    void testJ() {
		game.move(Direction.RIGHT);
    	String actualLevelCount = game.getMovingResult();
    	String expectedStartingString = "######" + 
    			"#+x+w#" + 
    			"#....#" + 
    			"#....#" + 
    			"######";		
		assertEquals(expectedStartingString, actualLevelCount);		   
	}
    
    @Test
    void testK() {	
    	game.move(Direction.LEFT);
		game.move(Direction.LEFT);
    	String actualLevelCount = game.getMovingResult();
    	String expectedStartingString = "######" + 
    			"#Xw+.#" + 
    			"#....#" + 
    			"#....#" + 
    			"######";		
		assertEquals(expectedStartingString, actualLevelCount);		   
	}
    @Test
    void testL() {	
		game.move(Direction.LEFT);
    	String actualLevelCount = game.getMovingResult();
    	String expectedStartingString = "######" + 
    			"#Xw+.#" + 
    			"#....#" + 
    			"#....#" + 
    			"######";		
		assertEquals(expectedStartingString, actualLevelCount);		   
	}
    @Test
    void testM() {

    	int actualLevelCount = game.completed;
    	int expectedStartingString = 1;
    			
		assertEquals(expectedStartingString, actualLevelCount);		   
	}
}
