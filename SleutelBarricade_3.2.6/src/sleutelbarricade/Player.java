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
    private final Object[] options = {"Yes", "No"};
    private int inventory;
    private final String Player_IMG_PATH = "src/images/Player.jpeg";
    private BufferedImage Player = null;
    private boolean possible = false;
    private final SleutelBarricade sleutelBarricade;
       
    public Player(String objectName, int x, int y,SleutelBarricade sleutelBarricade){
        super(objectName, x, y);
        this.inventory = 0;
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
    
    public void move(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
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
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Player, x, y, null);
    }
          
    public boolean movePossible(ArrayList<GameObject> objectArray, GameObject[][] playField, boolean[][] board, String direction) {
    int xPos = (getX() - 37) / 50;
    int yPos = (getY() - 37) / 50;
    switch (direction) {
        case "UP":
            if (board[xPos][yPos - 1] == true) {
                switch (playField[xPos][yPos - 1].getObjectName()) {
                    case "Wall":
                        wallInteraction();
                        break;
                    case "Key":
                        pickUpKey(playField[xPos][yPos-1], objectArray);
                        break;
                    case "Barricade":
                        unlockBarricade(playField[xPos][yPos-1], objectArray);
                        break;
                }
            }else{
                possible = true;
            }
            break;
        case "DOWN":
            if (board[xPos][yPos + 1] == true) {
                switch (playField[xPos][yPos + 1].getObjectName()) {
                    case "Wall":
                        wallInteraction();
                        break;
                    case "Key":
                        pickUpKey(playField[xPos][yPos+1], objectArray);
                        break;  
                    case "Barricade":
                        unlockBarricade(playField[xPos][yPos+1], objectArray);
                        break;
                    case "EndPoint":
                        JOptionPane.showMessageDialog(null, "Endpoint reached!");
                        sleutelBarricade.randomizeField();
                        break;    
                    }
                }else{
                    possible = true;
                }
            break;
        case "LEFT":
            if (board[xPos - 1][yPos] == true) {
                switch (playField[xPos - 1][yPos].getObjectName()) {
                    case "Wall":
                        wallInteraction();
                        break;
                    case "Key":
                        pickUpKey(playField[xPos-1][yPos],objectArray);
                        break;
                    case "Barricade":
                        unlockBarricade(playField[xPos-1][yPos], objectArray);
                        break;
                    }
                }else{
                    possible = true;
                } 
            break;
        case "RIGHT":
            if (board[xPos + 1][yPos] == true) {
                switch (playField[xPos + 1][yPos].getObjectName()) {
                    case "Wall":
                        wallInteraction();
                        break;
                    case "Key":
                        pickUpKey(playField[xPos+1][yPos], objectArray);
                        break;
                    case "Barricade":
                        unlockBarricade(playField[xPos+1][yPos], objectArray);
                        break;
                    case "EndPoint":
                        JOptionPane.showMessageDialog(null, "Endpoint reached!");
                        sleutelBarricade.randomizeField();
                        break;
                    }
                }else{
                    possible = true;
                }
            break;
        }
    return possible;
    }
    
    public boolean wallInteraction() {
        System.out.println("Wall");
        possible = false;
        return possible;
    }
    
    public boolean unlockBarricade(GameObject objectPos, ArrayList<GameObject> objectArray){
        System.out.println(objectPos.getPassCode());
        int j = JOptionPane.showOptionDialog(null, "Would you like to open the barricade with code: " + objectPos.getPassCode(),
        "Barricade pop-up", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, options, "Yes");
        System.out.println(j);
        if (j == 0 && getInventory() == objectPos.getPassCode()) {
            objectArray.remove(objectArray.indexOf(objectPos));
            objectPos = null;
            possible = true;
        } else if (j == 0 && getInventory() != objectPos.getPassCode()) {
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
        System.out.println(n);
        if (n == 0) {
            objectArray.remove(objectArray.indexOf(objectPos));
            setInventory(objectPos.getPassCode());
            objectPos = null;
            System.out.println(getInventory());
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
    
    public int getInventory() {
        return inventory;
    }
    
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
