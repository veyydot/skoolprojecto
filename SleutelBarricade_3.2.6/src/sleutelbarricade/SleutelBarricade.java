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
    
    private final int walls = 15;
    private final int barricades = 15;
    private final int keys = 5;  
    private ArrayList<GameObject> initialArray;
    private ArrayList<GameObject> objectArray = new ArrayList<>();
    private GameObject[][] playField = new GameObject[10][10];
    private boolean[][] gameObjects = new boolean[10][10];
    private Graphics g;    
    private Player player = new Player("Player", 37, 37, this);
    private EndPoint endPoint = new EndPoint("EndPoint", 487, 487);
    private Timer t;

    public SleutelBarricade(){
        this.t = new Timer(5, this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
    }    
    
    //Convert Array Position to Pixels, !!Unit Testen
    public int positionToPixel(int pos){
        int position = pos * 50+37;
        return position;
    }
    
    //Convert X Pixels to Array Position
    public int pixelToPositionX(int pixels){
        int xPosition = (pixels - 37) / 50;
        return xPosition;
    }
    
    //Convert Y Pixels to Array Position
    public int pixelToPositionY(int pixels){
        int yPosition = (pixels - 37)/50;
        return yPosition;
    }
    
    //Randomize All Objects To The ArrayList
    public void randomizeField(){
        objectArray.clear();
        for(int i = 0; i<playField.length; i++){
            for(int j = 0; j<playField[i].length; j++){
                playField[i][j] = null;
                gameObjects[i][j] = false;
            }
        }
        player.setInventory(0);
        objectArray.add(player);
        objectArray.add(endPoint);
        player.setX(positionToPixel(0));
        player.setY(positionToPixel(0));
        playField[0][0] = player;
        playField[9][9] = endPoint;
        gameObjects[0][0] = true;
        gameObjects[9][9] = true;
        
        //Add Keys to ArrayList
        for(int  i = 0 ; i< keys ; i++){
            int x = 0 ;
            int y = 0;
            int passCode = ThreadLocalRandom.current().nextInt(1,4)*100;
            while(gameObjects[x][y]){
                x = new Random().nextInt(gameObjects.length);
                y = new Random().nextInt(gameObjects[x].length);
            }
            gameObjects[x][y] = true;
            objectArray.add(new Key("Key", positionToPixel(x), positionToPixel(y), passCode));             
            playField[x][y] = objectArray.get(i+2);
        }
        
        //Add Barricades to ArrayList
        for(int i = 0; i<barricades; i++){
            int x = 0;
            int y = 0;
            int passCode = ThreadLocalRandom.current().nextInt(1,4)*100;
            while(gameObjects[x][y]){
                x = new Random().nextInt(gameObjects.length);
                y = new Random().nextInt(gameObjects[x].length);
            }
            gameObjects[x][y] = true;
            objectArray.add(new Barricade("Barricade", positionToPixel(x), positionToPixel(y),passCode));
            playField[x][y] = objectArray.get(i+keys+2);
        }
        
        //Add Walls to ArrayList
        for(int i = 0; i<walls; i++){
            int x = 0;
            int y = 0;
            while(gameObjects[x][y]){
                x = new Random().nextInt(gameObjects.length);
                y = new Random().nextInt(gameObjects[x].length);
            }
            gameObjects[x][y] = true;
            objectArray.add(new Wall("Wall", positionToPixel(x), positionToPixel(y)));
            playField[x][y] = objectArray.get(i+keys+barricades+2);
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
        //Add All Objects to GameField + passCode if possible
        for(int i = 1; i<objectArray.size(); i++){
            objectArray.get(i).initializeImages();
            objectArray.get(i).render(g);
            
            g.setColor(Color.black);
            if(objectArray.get(i).getObjectName().equals("Key") || objectArray.get(i).getObjectName().equals("Barricade")){
                if(objectArray.get(i).getObjectName().equals("Key")){
                    g.drawString(Integer.toString(objectArray.get(i).getPassCode()), objectArray.get(i).getX(), objectArray.get(i).getY()+40);
                }else{
                    g.drawString(Integer.toString(objectArray.get(i).getPassCode()), objectArray.get(i).getX()+7, objectArray.get(i).getY()+40);
                }
            }
        }
        objectArray.get(0).initializeImages();
        objectArray.get(0).render(g);
    }
    
    //KeyListener
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int x = pixelToPositionX(player.getX());
        int y = pixelToPositionY(player.getY());
        
        boolean possible;
        String notPossibleMessage = "Player didn't move!";
        if(keyCode == KeyEvent.VK_UP) {
            if(y>=1){                
                possible = player.movePossible(objectArray, playField, gameObjects, "UP");
                if(possible){
                    player.move(e);
                    playField[x][y-1] = playField[x][y];
                    playField[x][y] = null;
                    gameObjects[x][y-1] = true;
                    gameObjects[x][y] = false;
                    y-=1;
                }else{
                    System.out.println(notPossibleMessage);
                }
            }   
        }
        
        if(keyCode == KeyEvent.VK_DOWN) {
            if(y<=8){
                possible = player.movePossible(objectArray, playField, gameObjects, "DOWN");
                if(possible){
                    player.move(e);
                    playField[x][y+1] = playField[x][y];
                    playField[x][y] = null;
                    gameObjects[x][y+1] = true;
                    gameObjects[x][y] = false;
                    y+=1;
                }else{
                    System.out.println(notPossibleMessage);
                }   
            }
        }

        if(keyCode == KeyEvent.VK_LEFT) {
            if(x>=1){
                possible = player.movePossible(objectArray, playField, gameObjects, "LEFT");
                if(possible){
                    player.move(e);
                    playField[x-1][y] = playField[x][y];
                    playField[x][y] = null;
                    gameObjects[x-1][y] = true;
                    gameObjects[x][y] = false;
                    x-=1;
                }else{
                    System.out.println(notPossibleMessage);
                }
            }   
        }
        
        if(keyCode == KeyEvent.VK_RIGHT) {
            if(x<=8){
                possible = player.movePossible(objectArray, playField, gameObjects, "RIGHT");
                if(possible){
                    playField[x+1][y] = playField[x][y];
                    playField[x][y] = null;
                    gameObjects[x+1][y] = true;
                    gameObjects[x][y] = false;
                    x+=1;
                    player.move(e);
                }else{
                    System.out.println(notPossibleMessage);
                }
            }
        }
    }
    
    public void actionPerformed(ActionEvent e){
        repaint();
    }  
    
    public void keyReleased(KeyEvent e) {
        
    }
    
    public void keyTyped(KeyEvent e) {
        
    }
    
    public int getPlayerInventory(){
        return player.getInventory();
    }
}
