package sleutelbarricade;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.input.KeyEvent;
import javax.imageio.ImageIO;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class Player extends GameObject{
    private int x, y;
    private int inventory;
    private final String Player_IMG_PATH = "src/images/Player.jpeg";    
    private BufferedImage Player = null;
    private Graphics g;
    
    public Player(String objectName, int x, int y, boolean isFull) {
        super(objectName, x, y, isFull);
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
    
    public void move(KeyEvent e){
        
    }
    
    public void moveDown(){
        x = -37;
        y = 0;
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(Player, x, y, null);
    }
    
    public void pickUpKey(int value){

    }
    
    public boolean unlockBarricade(int keyValue, int barricadeValue){
        return keyValue == barricadeValue;
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
