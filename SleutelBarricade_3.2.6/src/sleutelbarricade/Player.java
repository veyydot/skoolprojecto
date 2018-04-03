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
    private boolean possible = false;
    
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
        Object[] options = {"Yes", "No"};
        int xPos = (getX()-37)/50;
        int yPos = (getY()-37)/50;
        switch(direction){
            case "UP":
                if(board[xPos][yPos-1] == true){
            switch (playField[xPos][yPos-1].getObjectName()) {
                case "Wall":
                    wallInteraction();
                    break;
                case "Key":
//                    System.out.println(playField[xPos][yPos-1].getPassCode());
                    int n = JOptionPane.showOptionDialog(null, "Would you like to pick up the key with code: " + playField[xPos][yPos-1].getPassCode(),
                            "Key pop-up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, "No"); 
                    System.out.println(n);
                    if(n == 0){
                        setInventory(playField[xPos][yPos-1].getPassCode());
                        System.out.println(getInventory());
                        playField[xPos][yPos-1] = null;
                        possible = true;
                    }else{
                        possible = false;
                    }
                    break;
                case "Barricade":
                    System.out.println(playField[xPos][yPos-1].getPassCode());
                    int j = JOptionPane.showOptionDialog(null, "Would you like to open the barricade with code: " + playField[xPos][yPos-1].getPassCode(),
                            "Barricade pop-up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, "No"); 
                    System.out.println(j);
                    if(j == 0 && inventory == playField[xPos][yPos-1].getPassCode()){
                        playField[xPos][yPos-1] = null;
                        possible = true;
                    }else{
                        possible = false;
                    }
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
                    wallInteraction();
                    break;
                case "Key":
//                    System.out.println(playField[xPos][yPos+1].getPassCode());
                    int n = JOptionPane.showOptionDialog(null, "Would you like to pick up the key with code: " + playField[xPos][yPos+1].getPassCode(),
                            "Key pop-up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, "No"); 
                    System.out.println(n);
                    if(n == 0){
                        setInventory(playField[xPos][yPos+1].getPassCode());
                        System.out.println(getInventory());
                        playField[xPos][yPos+1] = null;
                        possible = true;
                    }else{
                        possible = false;
                    }                    
                    break;
                case "Barricade":
                    System.out.println(playField[xPos][yPos+1].getPassCode());
                    int k = JOptionPane.showOptionDialog(null, "Would you like to open the barricade with code: " + playField[xPos][yPos+1].getPassCode(),
                            "Barricade pop-up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, "No"); 
                    System.out.println(k);
                    if(k == 0 && inventory == playField[xPos][yPos+1].getPassCode()){
                        playField[xPos][yPos+1] = null;
                        possible = true;
                    }else{
                        possible = false;
                    }
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
                    wallInteraction();
                    break;
                case "Key":
//                    System.out.println(playField[xPos-1][yPos].getPassCode());
                    int n = JOptionPane.showOptionDialog(null, "Would you like to pick up the key with code: " + playField[xPos-1][yPos].getPassCode(),
                            "Key pop-up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, "No"); 
                    System.out.println(n);
                    if(n == 0){
                        setInventory(playField[xPos-1][yPos].getPassCode());
                        System.out.println(getInventory());
                        playField[xPos-1][yPos] = null;
                        possible = true;
                    }else{
                        possible = false;
                    }
                    break;
                case "Barricade":
                    System.out.println(playField[xPos-1][yPos].getPassCode());
                    int j = JOptionPane.showOptionDialog(null, "Would you like to open the barricade with code: " + playField[xPos-1][yPos].getPassCode(),
                            "Barricade pop-up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, "No"); 
                    System.out.println(j);
                    if(j == 0 && inventory == playField[xPos-1][yPos].getPassCode()){
                        playField[xPos][yPos+1] = null;
                        possible = true;
                    }else{
                        possible = false;
                    }                   
                    break;
            }
                }else{
                    possible = true;
                }
                break;
            case "RIGHT":
                if(board[xPos+1][yPos] == true){
            switch (playField[xPos+1][yPos].getObjectName()) {
                case "Wall":
                    wallInteraction();
                    break;
                case "Key":
                    System.out.println(playField[xPos+1][yPos].getPassCode());
                    int n = JOptionPane.showOptionDialog(null, "Would you like to pick up the key with code: " + playField[xPos+1][yPos].getPassCode(),
                            "Key pop-up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, "No"); 
                    System.out.println(n);
                    if(n == 0){
                        setInventory(playField[xPos+1][yPos].getPassCode());
                        playField[xPos+1][yPos] = null;
                        possible = true;
                    }else{
                        possible = false;
                    }
                    break;
                case "Barricade":
                    System.out.println(playField[xPos+1][yPos].getPassCode());
                    int j = JOptionPane.showOptionDialog(null, "Would you like to open the barricade with code: " + playField[xPos+1][yPos].getPassCode(),
                            "Barricade pop-up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, "No"); 
                    System.out.println(j);
                    if(j == 0 && getInventory() == playField[xPos+1][yPos].getPassCode()){
                        playField[xPos+1][yPos] = null;
                        possible = true;
                    }else{
                        possible = false;
                    }                    
                    break;
            }
                }else{
                    possible = true;
                }
                break;
        }
        return possible;
    }   
    
    public boolean wallInteraction(){
        System.out.println("Wall");
        possible = false;
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
