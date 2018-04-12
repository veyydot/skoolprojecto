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
public class Player extends GameObject {
    
    private final SleutelBarricade sleutelBarricade;
    private final Object[] options = {"Yes", "No"};
    private final String Player_IMG_PATH = "src/images/Player.jpeg";
    private Key inventory;
    private boolean possible = false;
    private BufferedImage Player = null;
    private Graphics g;
       
    public Player(String objectName, int x, int y,SleutelBarricade sleutelBarricade){
        super(objectName, x, y);
        this.inventory = new Key("Key", 0, 0, 0);
        this.sleutelBarricade = sleutelBarricade;
    }
    
    @Override
    public void initializeImages() {
        try {
            Player = ImageIO.read(new File(Player_IMG_PATH));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Player, x, y, null);
    }
    
    public void move(GameObject[][] playField, KeyEvent e) {
        int keyCode = e.getKeyCode();
        int xPos = sleutelBarricade.pixelToPositionX(getX());
        int yPos = sleutelBarricade.pixelToPositionY(getY());
        
        switch (keyCode) {
            case KeyEvent.VK_DOWN:
                System.out.println(possible);
                if(yPos <= 8){
                    System.out.println("DOWN");
                    playField[xPos][yPos+1] = playField[xPos][yPos];
                    playField[xPos][yPos] = null;
                    yPos+=1;
                }
                x += 0;
                y += 50;
                break;
            case KeyEvent.VK_UP:
                System.out.println(possible);
                if(yPos >= 1){
                    System.out.println("UP");
                    playField[xPos][yPos-1] = playField[xPos][yPos];
                    playField[xPos][yPos] = null;
                    yPos-=1;
                }
                x += 0;
                y -= 50;
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println(possible);
                if(xPos <= 8){
                    System.out.println("RIGHT");
                    playField[xPos+1][yPos] = playField[xPos][yPos];
                    playField[xPos][yPos] = null;
                    xPos+=1;
                }
                x += 50;
                y += 0;
                break;
            case KeyEvent.VK_LEFT:
                System.out.println(possible);
                if(xPos >= 1){
                    System.out.println("LEFT");
                    playField[xPos-1][yPos] = playField[xPos][yPos];
                    playField[xPos][yPos] = null;
                    xPos-=1;
                }
                x -= 50;
                y += 0;
                break;
        }
    }
          
    public boolean movePossible(ArrayList<GameObject> objectArray, GameObject[][] playField, String direction) {
        int xPos = sleutelBarricade.pixelToPositionX(getX());
        int yPos = sleutelBarricade.pixelToPositionY(getY());
        switch (direction) {
            case "UP":
                if(yPos >= 1){
                    if(playField[xPos][yPos-1] == null){
                        possible = true;
                    }else{
                        possible = false;
                    }
                }
                break;
            case "DOWN":
                if(yPos <= 8){
                    if(playField[xPos][yPos+1] == null){
                        possible = true;
                    }else{
                        possible = false;
                    }
                }
                break;
            case "LEFT":
                if(xPos >= 1){
                    if(playField[xPos-1][yPos] == null){
                        possible = true;
                    }else{
                        possible = false;
                    }
                }
                break;
            case "RIGHT":
                if(xPos <= 8){
                    if(playField[xPos+1][yPos] == null){
                        possible = true;
                    }else{
                        possible = false;
                    }
                }
                
        }
        return possible;

//            case "UP":
//                if (playField[xPos][yPos - 1] == null) {
//                    switch (playField[xPos][yPos - 1].getObjectName()) {
//                        case "Wall":
//                            wallInteraction();
//                            break;
//                        case "Key":
//                            pickUpKey(playField[xPos][yPos-1], objectArray);
//                            break;
//                        case "Barricade":
//                            unlockBarricade(playField[xPos][yPos-1], objectArray);
//                            break;
//                    }
//                }else{
//                    possible = true;
//                }
//                break;
//            case "DOWN":
//                if (playField[xPos][yPos + 1] == null) {
//                    switch (playField[xPos][yPos + 1].getObjectName()) {
//                        case "Wall":
//                            wallInteraction();
//                            break;
//                        case "Key":
//                            pickUpKey(playField[xPos][yPos+1], objectArray);
//                            break;  
//                        case "Barricade":
//                            unlockBarricade(playField[xPos][yPos+1], objectArray);
//                            break;
//                        case "EndPoint":
//                            JOptionPane.showMessageDialog(null, "Endpoint reached! Play again? Click 'New Level!'");
//                            break;    
//                        }
//                    }else{
//                        possible = true;
//                    }
//                break;
//            case "LEFT":
//                if (playField[xPos - 1][yPos] == null) {
//                    switch (playField[xPos - 1][yPos].getObjectName()) {
//                        case "Wall":
//                            wallInteraction();
//                            break;
//                        case "Key":
//                            pickUpKey(playField[xPos-1][yPos],objectArray);
//                            break;
//                        case "Barricade":
//                            unlockBarricade(playField[xPos-1][yPos], objectArray);
//                            break;
//                        }
//                    }else{
//                        possible = true;
//                    } 
//                break;
//            case "RIGHT":
//                if (playField[xPos + 1][yPos] == null) {
//                    switch (playField[xPos + 1][yPos].getObjectName()) {
//                        case "Wall":
//                            wallInteraction();
//                            break;
//                        case "Key":
//                            pickUpKey(playField[xPos+1][yPos], objectArray);
//                            break;
//                        case "Barricade":
//                            unlockBarricade(playField[xPos+1][yPos], objectArray);
//                            break;
//                        case "EndPoint":
//                            JOptionPane.showMessageDialog(null, "Endpoint reached! Play again? Click 'New Level!'");
//                            break;
//                        }
//                    }else{
//                        possible = true;
//                    }
//                break;
//            }
    }
    
    public boolean wallInteraction() {
        possible = false;
        return possible;
    }
    
    public boolean unlockBarricade(GameObject objectPos, ArrayList<GameObject> objectArray){
        int j = JOptionPane.showOptionDialog(null, "Would you like to open the barricade with code: " + objectPos.getPassCode(),
        "Barricade pop-up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, options, "Yes");
        
        if (j == 0 && getInventory().getPassCode() == objectPos.getPassCode()) {
            objectArray.remove(objectArray.indexOf(objectPos));
            objectPos = null;
            possible = true;
        } else if (j == 0 && getInventory().getPassCode() != objectPos.getPassCode()) {
            JOptionPane.showMessageDialog(null, "Can't open barricade, you don't have the right key");
            possible = false;
        }else{
            possible = false;
        }
        return possible;
    }
    
    public boolean pickUpKey(GameObject objectPos, ArrayList<GameObject> objectArray){
        int n = JOptionPane.showOptionDialog(null, "Would you like to pick up the key with code: " + objectPos.getPassCode(),
        "Key pop-up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, options, "No");
        
        if (n == 0) {
            objectArray.remove(objectArray.indexOf(objectPos));
            setInventory((Key) objectPos);
            objectPos = null;
            possible = true;
        } else {
            possible = true;
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
    
    public Key getInventory() {
        return inventory;
    }
    
    public void setInventory(Key inventory) {
        this.inventory = inventory;
    }
}
