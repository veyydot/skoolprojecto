package sleutelbarricade;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class SleutelBarricade extends JComponent implements KeyListener, ActionListener{
     
//    private String difficulty;
//    private int amountOfWalls;
//    private int amountofBarricades;
//    private int amountofKeys;  
    private GameObject[][] initialField;
    
    private boolean gameState;    
    private ArrayList<GameObject> objectArray = new ArrayList<>();
    private GameObject[][] playField = new GameObject[10][10];
    boolean[][] gameObjects = new boolean[10][10];
    private Graphics g;    
    private Player player = new Player("Player", 37, 37, true);
    private EndPoint endPoint = new EndPoint("EndPoint", 487, 487, true);
    private final Timer t;

    public SleutelBarricade(){
        this.t = new Timer(5, this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
    }
    
    public boolean[][] getGameObjects(){
        return gameObjects;
    }
    
    public void randomizeField(Graphics g){
        objectArray.add(player);
        objectArray.add(endPoint);
        playField[0][0] = player;
        playField[9][9] = endPoint;
        gameObjects[0][0] = true;
        gameObjects[9][9] = true;
        
        int keys = 3;
        int walls = 15;
        int barricades = 15;
        
        //Add Keys
        for(int  i = 0 ; i< keys ; i++){
            int x = 0 ;
            int y = 0;
            int passCode = ThreadLocalRandom.current().nextInt(1,3)*100;
            while(gameObjects[x][y]){
                x = new Random().nextInt(gameObjects.length);
                y = new Random().nextInt(gameObjects[i].length);
            }
            gameObjects[x][y] = true;
            objectArray.add(new Key("Key", x*50+37, y*50+37, passCode, true));             
            playField[x][y] = objectArray.get(i+2);
        }
        
        //Add Walls
        for(int i = 0; i<walls; i++){
            int x = 0;
            int y = 0;
            while(gameObjects[x][y]){
                x = ThreadLocalRandom.current().nextInt(0,10);
                y = ThreadLocalRandom.current().nextInt(0,10);
            }
            gameObjects[x][y] = true;
            objectArray.add(new Wall("Wall", x*50+37, y*50+37, true));
            playField[x][y] = objectArray.get(i+keys+2);
        }
        
        //Add Barricades
        for(int i = 0; i<barricades; i++){
            int x = 0;
            int y = 0;
            int passCode = ThreadLocalRandom.current().nextInt(1,3)*100;
            while(gameObjects[x][y]){
                x = ThreadLocalRandom.current().nextInt(0,10);
                y = ThreadLocalRandom.current().nextInt(0,10);
            }
            gameObjects[x][y] = true;
            objectArray.add(new Barricade("Barricade", x*50+37, y*50+37,passCode, true));
            playField[x][y] = objectArray.get(i+keys+walls+2);
        }
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
        for(int i = 0; i<objectArray.size(); i++){
            objectArray.get(i).initializeImages();
            objectArray.get(i).render(g);
        }
    }
    
    public void actionPerformed(ActionEvent e){
        repaint();
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int x = (player.getX()-37)/50;
        int y = (player.getY()-37)/50;
        boolean possible;
        if(keyCode == KeyEvent.VK_UP) {
            System.out.println("UP");
            if(y>=1){                
                possible = player.movePossible(playField, gameObjects, "UP");
                if(possible){
                    player.move(e);
                    playField[x][y-1] = playField[x][y];
                    playField[x][y] = null;
                    y-=1;
                }else{
                    System.out.println("Impossible move!");
                }
            }   
        }
        
        if(keyCode == KeyEvent.VK_DOWN) {
            System.out.println("DOWN");
            if(y<=8){
                possible = player.movePossible(playField, gameObjects, "DOWN");
                if(possible){
                    player.move(e);
                    playField[x][y+1] = playField[x][y];
                    playField[x][y] = null;
                    y+=1;
                }else{
                    System.out.println("Impossible move!");
                }   
            }
        }

        if(keyCode == KeyEvent.VK_LEFT) {
            System.out.println("LEFT");
            if(x>=1){
                possible = player.movePossible(playField, gameObjects, "LEFT");
                if(possible){
                    player.move(e);
                    playField[x-1][y] = playField[x][y];
                    playField[x][y] = null;
                    x-=1;
                }else{
                    System.out.println("Impossible move!");
                }
            }   
        }
        
        if(keyCode == KeyEvent.VK_RIGHT) {
            System.out.println("RIGHT");
            if(x<=8){
                possible = player.movePossible(playField, gameObjects, "RIGHT");
                if(possible){
                    playField[x+1][y] = playField[x][y];
                    playField[x][y] = null;
                    x+=1;
                    player.move(e);
                }else{
                    System.out.println("Impossible move!");
                }
            }
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
    public void keyTyped(KeyEvent e) {

    }
}
