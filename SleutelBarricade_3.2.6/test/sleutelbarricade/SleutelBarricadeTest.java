package sleutelbarricade;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class SleutelBarricadeTest {
    private SleutelBarricade sb = new SleutelBarricade();

    public SleutelBarricadeTest() {
    }
    
    @Test
    public void testSomeMethod() {
        int expected = 87;
        int result = sb.positionToPixel(1);
        assertEquals(expected, result);
    }
    
    @Test
    public void testSomeMethod2(){
        int expected = 0;
        int result = sb.pixelToPositionX(37);
        assertEquals(expected,result);
    }
    
}
