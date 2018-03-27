/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class SleutelBarricade{
    
    private boolean gameState;
    private String difficulty;
    private int amountOfWalls;
    private int amountofBarricades;
    private int amountofKeys;    
    private ArrayList<Wall> walls = new ArrayList<>();
    private ArrayList<Barricade> barricade = new ArrayList<>();
    private ArrayList<Key> keys = new ArrayList<>();
    private GameObject[][] playField;
    private GameObject[][] initialField;
        
    public static void main(String[] args) {
        Frame gameFrame = new Frame("SleutelBarricade", 750, 750);       
        
    }
    
    public void loadGame(Graphics g){
        Player player = new Player(0, 0);
        int x = player.getX();
        int y = player.getY();
        player.render(g);
        
        
        playField = new GameObject[10][10];
        
        playField[9][9] = new EndPoint(9, 9);
    }
}
