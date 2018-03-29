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
//    private String difficulty;
//    private int amountOfWalls;
//    private int amountofBarricades;
//    private int amountofKeys;    
    private ArrayList<GameObject> objectArray;
    private GameObject[][] playField = new GameObject[10][10];
//    private GameObject[][] initialField;
    private Graphics g;
    
    private Player player = new Player(37,37, true);
    private EndPoint end = new EndPoint(487, 487, true);
    private final Timer t;

    public SleutelBarricade(){
        this.t = new Timer(50, this);
        t.start();
        addKeyListener(this);
    }
    
    public void addToList(){
        objectArray = new ArrayList<>();
        for(int i = 0; i<5; i++){
            int x = ThreadLocalRandom.current().nextInt(0,9)*50+37;
            int y = ThreadLocalRandom.current().nextInt(0,9)*50+37;
            int passCode = ThreadLocalRandom.current().nextInt(1,3)*100;
            objectArray.add(new Key(x,y, passCode, true));
        }
        objectArray.add(new Wall(ThreadLocalRandom.current().nextInt(0,9)*50+37, ThreadLocalRandom.current().nextInt(0,9)*50+37, true));
        Iterator itr = objectArray.iterator();
        while(itr.hasNext()){
            GameObject gameObject = (GameObject)itr.next();
            System.out.println("X as is :" + (1+(gameObject.x-31)/50) + " Y as is : "+ (1+(gameObject.y-31)/50) + " passcode is : " + gameObject.passCode);
        }
    }
    public void loadGame(Graphics g){
        addToList();
        for(int i = 0; i<objectArray.size(); i++){
            objectArray.get(i).initializeImages();
            objectArray.get(i).render(g);  
        }
        player.initializeImages();
        end.initializeImages();
        player.render(g);
        end.render(g);
    }
    
    //Paint playField
    public void paintComponent(Graphics g){
        for(int rows = 0; rows<playField.length; rows++){
            int rowPosition = rows*50;
            for(int columns = 0; columns<playField[rows].length; columns++){
                int columnPosition = columns*50;
                g.setColor(Color.BLACK);
                g.drawRect(30+columnPosition, 30+rowPosition, 50, 50);
                g.setColor(Color.decode("#F7F7F7"));
                g.fillRect(31+columnPosition, 31+rowPosition, 48, 48);
            }
        }
        loadGame(g);
    }
    
    public void actionPerformed(ActionEvent e){
//        we moeten nog uitzoeken hoe we 1 object laten moven en niet alles
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
