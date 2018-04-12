package sleutelbarricade;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class SleutelBarricadeTest {
    private SleutelBarricade sb = new SleutelBarricade();
    private ArrayList<GameObject> lijst = new ArrayList<>();
    public SleutelBarricadeTest() {
    }
    
    @Test
    public void positionToPixelCorrect() {
        int expected = 87;
        int result = sb.positionToPixel(1);
        assertEquals(expected, result);
    }
    
//    @Test
//    public void positionToPixelIncorrect() {
//        int expected = 37;
//        int result = sb.positionToPixel(1);
//        assertEquals(expected, result);
//    }
    
    @Test
    public void pixelToPositionCorrect(){
        int expected = 0;
        int result = sb.pixelToPositionX(37);
        assertEquals(expected,result);
    }
    
//    @Test
//    public void pixelToPositionIncorrect(){
//        int expected = 0;
//        int result = sb.pixelToPositionX(87);
//        assertEquals(expected,result);
//    }
    
    @Test
    public void moveUpToFilledLocationCorrect(){
        GameObject[][] playField = new GameObject[10][10];
        boolean[][] filledSpots = new boolean[10][10];
        Player p = new Player("Player", 37, 87, sb);
        playField[1][1] = p;
        filledSpots[1][1] = true;
        
        Wall w = new Wall("Wall", 37, 37);
        playField[1][0] = w;
        filledSpots[1][0] = true;
        
        lijst.add(p);
        lijst.add(w);
        
        boolean expected = false;
        boolean result = p.movePossible(lijst, playField, filledSpots, "UP");
        assertEquals(expected, result);
    }
    
    @Test
    public void moveUpToFilledLocationIncorrect(){
        GameObject[][] playField = new GameObject[10][10];
        boolean[][] filledSpots = new boolean[10][10];
        Player p = new Player("Player", 37, 37, sb);
        playField[1][1] = p;
        filledSpots[1][1] = true;
        
        Wall w = new Wall("Wall", 37, 87);
        playField[1][0] = w;
        filledSpots[1][0] = true;
        
        lijst.add(p);
        lijst.add(w);
        
        boolean expected = true;
        boolean result = p.movePossible(lijst, playField, filledSpots, "RIGHT");
        assertEquals(expected, result);
    }
    
    @Test
    public void moveDownToFilledLocationCorrect(){
        GameObject[][] playField = new GameObject[10][10];
        boolean[][] filledSpots = new boolean[10][10];
        Player p = new Player("Player", 37, 37, sb);
        playField[0][0] = p;
        filledSpots[0][0] = true;
        
        Wall w = new Wall("Wall", 37, 87);
        playField[0][1] = w;
        filledSpots[0][1] = true;
        
        lijst.add(p);
        lijst.add(w);
        
        boolean expected = false;
        boolean result = p.movePossible(lijst, playField, filledSpots, "RIGHT");
        assertEquals(expected, result);
    }
    
    @Test
    public void moveDownToFilledLocationIncorrect(){
        GameObject[][] playField = new GameObject[10][10];
        boolean[][] filledSpots = new boolean[10][10];
        Player p = new Player("Player", 37, 37, sb);
        playField[0][0] = p;
        filledSpots[0][0] = true;
        
        Wall w = new Wall("Wall", 37, 87);
        playField[0][1] = w;
        filledSpots[0][1] = true;
        
        lijst.add(p);
        lijst.add(w);
        
        boolean expected = true;
        boolean result = p.movePossible(lijst, playField, filledSpots, "DOWN");
        assertEquals(expected, result);
    }
    
    @Test
    public void moveLeftToFilledLocationCorrect(){
        GameObject[][] playField = new GameObject[10][10];
        boolean[][] filledSpots = new boolean[10][10];
        Player p = new Player("Player", 137, 37, sb);
        playField[1][0] = p;
        filledSpots[1][0] = true;
        
        Wall w = new Wall("Wall", 87, 37);
        playField[0][0] = w;
        filledSpots[0][0] = true;
        
        lijst.add(p);
        lijst.add(w);
        
        boolean expected = false;
        boolean result = p.movePossible(lijst, playField, filledSpots, "LEFT");
        assertEquals(expected, result);
    }
    
    @Test
    public void moveLeftToFilledLocationIncorrect(){
        GameObject[][] playField = new GameObject[10][10];
        boolean[][] filledSpots = new boolean[10][10];
        Player p = new Player("Player", 137, 37, sb);
        playField[3][0] = p;
        filledSpots[3][0] = true;
        
        Wall w = new Wall("Wall", 87, 37);
        playField[2][0] = w;
        filledSpots[2][0] = true;
        
        lijst.add(p);
        lijst.add(w);
        
        boolean expected = true;
        boolean result = p.movePossible(lijst, playField, filledSpots, "LEFT");
        assertEquals(expected, result);
    }
    
    @Test
    public void moveRightToFilledLocationCorrect(){
        GameObject[][] playField = new GameObject[10][10];
        boolean[][] filledSpots = new boolean[10][10];
        Player p = new Player("Player", 37, 37, sb);
        playField[0][0] = p;
        filledSpots[0][0] = true;
        
        Wall w = new Wall("Wall", 87, 37);
        playField[1][0] = w;
        filledSpots[1][0] = true;
        
        lijst.add(p);
        lijst.add(w);
        
        boolean expected = false;
        boolean result = p.movePossible(lijst, playField, filledSpots, "RIGHT");
        assertEquals(expected, result);
    }
    
    @Test
    public void moveRightToFilledLocationIncorrect(){
        GameObject[][] playField = new GameObject[10][10];
        boolean[][] filledSpots = new boolean[10][10];
        Player p = new Player("Player", 37, 37, sb);
        playField[0][0] = p;
        filledSpots[0][0] = true;
        
        Wall w = new Wall("Wall", 87, 37);
        playField[1][0] = w;
        filledSpots[1][0] = true;
        
        lijst.add(p);
        lijst.add(w);
        
        boolean expected = true;
        boolean result = p.movePossible(lijst, playField, filledSpots, "RIGHT");
        assertEquals(expected, result);
    }
    
    @Test
    public void moveToEmptyLocationCorrect(){
        GameObject[][] playField = new GameObject[10][10];
        boolean[][] filledSpots = new boolean[10][10];
        Player p = new Player("Player", 37, 37, sb);
        playField[0][0] = p;
        filledSpots[0][0] = true;
        
        Wall w = new Wall("Wall", 37, 87);
        playField[1][0] = w;
        filledSpots[1][0] = true;
        
        lijst.add(p);
        lijst.add(w);
        
        boolean expected = true;
        boolean result = p.movePossible(lijst, playField, filledSpots, "DOWN");
        assertEquals(expected, result);
    }
    
    @Test
    public void moveToEmptyLocationIncorrect(){
        GameObject[][] playField = new GameObject[10][10];
        boolean[][] filledSpots = new boolean[10][10];
        Player p = new Player("Player", 37, 37, sb);
        playField[0][0] = p;
        filledSpots[0][0] = true;
        
        Wall w = new Wall("Wall", 37, 87);
        playField[1][0] = w;
        filledSpots[1][0] = true;
        
        lijst.add(p);
        lijst.add(w);
        
        boolean expected = false;
        boolean result = p.movePossible(lijst, playField, filledSpots, "DOWN");
        assertEquals(expected, result);
    }
}
