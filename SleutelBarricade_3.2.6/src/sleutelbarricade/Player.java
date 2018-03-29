package sleutelbarricade;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class Player extends GameObject{
    private int x;
    private int y;
    private int inventory;
    private final String Player_IMG_PATH = "src/images/Player.jpeg";    
    private BufferedImage Player = null;
    private Graphics g;
    
    public Player(int x, int y) {
        super(x, y);
        this.inventory = 0;

    }  

    @Override
    public void initializeImages(){
        try{
            Player = ImageIO.read(new File(Player_IMG_PATH));
                 
        }catch(IOException exc){
            exc.printStackTrace();
        }
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(Player, x, y, null);
    }
    
    public void pickUpKey(int value){

    }
    
    public boolean unlockBarricade(int keyValue, int barricadeValue){
        if(keyValue == barricadeValue){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean movePossible(){
        return false;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    
    
}
