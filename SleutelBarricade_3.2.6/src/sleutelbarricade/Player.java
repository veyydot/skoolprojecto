package sleutelbarricade;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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
    }
    
    public void move(KeyEvent e){
        int keyCode = e.getKeyCode();
        //if(movePossible() == true){
            switch(keyCode){
            case KeyEvent.VK_DOWN:
                x += 0;
                y += 50;
                break;
            case KeyEvent.VK_UP:
                x += 0;
                y -= 50;
                break;
            case KeyEvent.VK_RIGHT:
                x += 50;
                y += 0;
                break;
            case KeyEvent.VK_LEFT:
                x -= 50;
                y += 0;
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
    
    public boolean movePossible(GameObject[][] playField, boolean[][] board, String direction){
        boolean possible = false;
        int xPos = (getX()-37)/50;
        int yPos = (getY()-37)/50;
        switch(direction){
            case "UP":
                if(board[xPos][yPos-1] == true){
            switch (playField[xPos][yPos-1].getObjectName()) {
                case "Wall":
                    System.out.println("wall");
                    possible = false;
                    break;
                case "Key":
                    System.out.println(playField[xPos][yPos-1].getPassCode());
                    possible = true;
                    break;
                case "Barricade":
                    System.out.println(playField[xPos][yPos-1].getPassCode());
                    possible = false;
                    break;
            }
                }else{
                    possible = true;
                }
                break;
            case "DOWN":
                if(board[xPos][yPos+1] == true){
            switch (playField[xPos][yPos+1].getObjectName()) {
                case "Wall":
                    System.out.println("wall");
                    possible = false;
                    break;
                case "Key":
                    System.out.println(playField[xPos][yPos+1].getPassCode());
                    possible = true;
                    break;
                case "Barricade":
                    System.out.println(playField[xPos][yPos+1].getPassCode());
                    possible = false;
                    break;
            }
                }else{
                    possible = true;
                }
                break;
            case "LEFT":
                if(board[xPos-1][yPos] == true){
            switch (playField[xPos-1][yPos].getObjectName()) {
                case "Wall":
                    System.out.println("wall");
                    possible = false;
                    break;
                case "Key":
                    System.out.println(playField[xPos-1][yPos].getPassCode());
                    possible = true;
                    break;
                case "Barricade":
                    System.out.println(playField[xPos-1][yPos].getPassCode());
                    possible = false;
                    break;
            }
                }else{
                    possible = true;
                }
                break;
            case "RIGHT":
                if(board[xPos+1][yPos] == true){
            switch (playField[xPos][yPos].getObjectName()) {
                case "Wall":
                    System.out.println("wall");
                    possible = false;
                    break;
                case "Key":
                    System.out.println(playField[xPos+1][yPos].getPassCode());
                    possible = true;
                    break;
                case "Barricade":
                    System.out.println(playField[xPos+1][yPos].getPassCode());
                    possible = false;
                    break;
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
