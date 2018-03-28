/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class SleutelBarricade extends JComponent{
    
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
        Frame gameFrame = new Frame("SleutelBarricade", 570, 700); 
    }
    
    public void loadGame(){
        //
    }
    
    //Paint playField
    public void paintComponent(Graphics g){
        playField = new GameObject[10][10];
        
        for(int rows = 0; rows<playField.length; rows++){
            int rowPosition = rows*50;
            for(int columns = 0; columns<playField[rows].length; columns++){
                int columnPosition = columns*50;
                g.setColor(Color.BLACK);
                g.drawRect(30+columnPosition, 30+rowPosition, 50, 50);
            }
        }
    }
}
