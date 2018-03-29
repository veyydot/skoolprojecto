package sleutelbarricade;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class SleutelBarricade extends JComponent implements KeyListener, ActionListener{
    
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
    private Graphics g;
    
    private Player player;
    private Key key;
    private Key key2;
    private Wall wall1;
    private EndPoint end;
    private Barricade barricade1;
    private Timer t = new Timer(50, this);
    
    public SleutelBarricade(){
        t.start();
        addKeyListener(this);
    }
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
        player = new Player(31, 31);
        key = new Key(ThreadLocalRandom.current().nextInt(0,9)*50+31, ThreadLocalRandom.current().nextInt(0,9)*50+31 , 100);
        key2 = new Key(ThreadLocalRandom.current().nextInt(0,9)*50+31, ThreadLocalRandom.current().nextInt(0,9)*50+31, 100);
        wall1 = new Wall(ThreadLocalRandom.current().nextInt(0,9)*50+31, ThreadLocalRandom.current().nextInt(0,9)*50+31);
        end = new EndPoint(481, 481);
        barricade1 = new Barricade(ThreadLocalRandom.current().nextInt(0,9)*50+31, ThreadLocalRandom.current().nextInt(0,9)*50+31, 100);
        key.initializeImages();
        key2.initializeImages();
        player.initializeImages();
        wall1.initializeImages();
        end.initializeImages();
        barricade1.initializeImages();
        player.render(g);
        key.render(g);
        key2.render(g);
        wall1.render(g);
        end.render(g);
        barricade1.render(g);
        
        ArrayList<GameObject> objectarray = new ArrayList<GameObject>();
         objectarray.add(key);
         objectarray.add(key2);
         Iterator itr = objectarray.iterator();
         while(itr.hasNext()){
             GameObject gameObject = (GameObject)itr.next();
         System.out.println("X as is :" + gameObject.x + " Y as is : "+ gameObject.y + "passcode is : " + gameObject.passCode);
    }
    }
    public void actionPerformed(ActionEvent e){
//        repaint();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_UP) {
        }
        if(keyCode == KeyEvent.VK_DOWN) {
        }
        if(keyCode == KeyEvent.VK_LEFT) {
        }
        if(keyCode == KeyEvent.VK_RIGHT) {
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_UP) {
        }
        if(keyCode == KeyEvent.VK_DOWN) {
        }
        if(keyCode == KeyEvent.VK_LEFT) {
        }
        if(keyCode == KeyEvent.VK_RIGHT) {
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }
}
