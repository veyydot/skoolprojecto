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
        Player player = new Player(31, 31);
        Key key = new Key(81, 31, 100);
        Key key2 = new Key(131, 31, 100);
        Wall wall1 = new Wall(31, 81);
        EndPoint end = new EndPoint(481, 481);
        Barricade barricade = new Barricade(31, 131, 100);
        key.initializeImages();
        key2.initializeImages();
        player.initializeImages();
        wall1.initializeImages();
        end.initializeImages();
        barricade.initializeImages();
        player.render(g);
        key.render(g);
        key2.render(g);
        wall1.render(g);
        end.render(g);
        barricade.render(g);
    }
}
