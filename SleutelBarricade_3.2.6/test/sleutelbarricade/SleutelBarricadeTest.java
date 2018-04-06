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
    
    @Test
    public void positionToPixelIncorrect() {
        int expected = 37;
        int result = sb.positionToPixel(1);
        assertEquals(expected, result);
    }
    
    @Test
    public void pixelToPositionCorrect(){
        int expected = 0;
        int result = sb.pixelToPositionX(37);
        assertEquals(expected,result);
    }
    
    @Test
    public void pixelToPositionIncorrect(){
        int expected = 0;
        int result = sb.pixelToPositionX(87);
        assertEquals(expected,result);
    }
    
    @Test
    public void moveToFilledLocationCorrect(){
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
        boolean result = p.movePossible(lijst, playField, filledSpots, "RIGHT");
        assertEquals(expected, result);
    }
    
    @Test
    public void moveToFilledLocationIncorrect(){
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
