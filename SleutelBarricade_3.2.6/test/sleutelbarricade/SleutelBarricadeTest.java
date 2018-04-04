/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private Player player;
    private boolean[][] gameObjects;
    
    public SleutelBarricadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        player = new Player("Player", 37, 37);
        gameObjects = new boolean[10][10];
        
        int x = (player.getX()-37)/50;
        int y = (player.getY()-37)/50;
    }
    
}
