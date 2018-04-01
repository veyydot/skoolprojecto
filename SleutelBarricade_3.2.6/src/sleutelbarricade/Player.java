package sleutelbarricade;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class Player extends GameObject{
    private int x, y;
    private int imgW, imgH;
    private int[] imgP;
    private int inventory;
    private final String Player_IMG_PATH = "src/images/Player.jpeg";    
    private BufferedImage Player = null;
    private Graphics g;
    
    
    private SleutelBarricade sb;
    
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
        
        imgW = Player.getWidth();
        imgH = Player.getHeight();
        imgP = Player.getRGB(0, 0, imgW, imgH, null, 0, imgW);
    }
    
    public void move(KeyEvent e){
        int keyCode = e.getKeyCode();
        //if(movePossible() == true){
            System.out.println("good");
            switch(keyCode){
            case KeyEvent.VK_DOWN:
                x = x + 0;
                y = y + 50;
                break;
            case KeyEvent.VK_UP:
                x = x + 0;
                y = y - 50;
                break;
            case KeyEvent.VK_RIGHT:
                x = x + 50;
                y = y + 0;
                break;
            case KeyEvent.VK_LEFT:
                x = x - 50;
                y = y + 0;
                break;
            }             
    //}
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
    
    public boolean movePossible(GameObject[][] playField, boolean[][] board, ArrayList<GameObject> lijst, String direction){
        boolean possible = false;
        switch(direction){
            case "UP":
                if(board[getX()][getY()-1] == true){
                    if(playField[getX()][getY()-1].getObjectName().equals("Wall")){
                        possible = false;
                    }else if(playField[getX()][getY()-1].getObjectName().equals("Key")){
                        //hier interactie met key
                    }else if(playField[getX()][getY()-1].getObjectName().equals("Barricade")){
                        //hier komt interactie met barricade
                    }
                }else{
                    possible = true;
                }
                break;
            case "DOWN":
                if(board[getX()][getY()+1] == true){
                    if(playField[getX()][getY()+1].getObjectName().equals("Wall")){
                        possible = false;
                    }else if(playField[getX()][getY()+1].getObjectName().equals("Key")){
                        //hier interactie met key
                    }else if(playField[getX()][getY()+1].getObjectName().equals("Barricade")){
                        //hier komt interactie met barricade
                    }
                }else{
                    possible = true;
                }
                break;
            case "LEFT":
                if(board[getX()-1][getY()] == true){
                    if(playField[getX()-1][getY()].getObjectName().equals("Wall")){
                        possible = false;
                    }else if(playField[getX()-1][getY()].getObjectName().equals("Key")){
                        //hier interactie met key
                    }else if(playField[getX()-1][getY()].getObjectName().equals("Barricade")){
                        //hier komt interactie met barricade
                    }
                }else{
                    possible = true;
                }
                break;
            case "RIGHT":
                if(board[getX()][getY()-1] == true){
                    if(playField[getX()+1][getY()].getObjectName().equals("Wall")){
                        possible = false;
                    }else if(playField[getX()+1][getY()].getObjectName().equals("Key")){
                        //hier interactie met key
                    }else if(playField[getX()+1][getY()].getObjectName().equals("Barricade")){
                        //hier komt interactie met barricade
                    }
                }else{
                    possible = true;
                }
                break;
        }
        return possible;
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
