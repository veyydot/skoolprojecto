/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class KeyInput extends KeyAdapter{
    
    SleutelBarricade sb = new SleutelBarricade();
    
    public KeyInput(){
        
    }
    
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        for(int i = 0; i<sb.getObjects().size(); i++){
            GameObject temporaryObjects = sb.getObjects().get(i);
            
            //??????????? Hier even checken
            if(temporaryObjects.getX() == 37 && temporaryObjects.getY() == 37){
                if(keyCode == KeyEvent.VK_UP) {
                    System.out.println("UP");
                }
                if(keyCode == KeyEvent.VK_DOWN) {
                    System.out.println("DOWN");
                }
                if(keyCode == KeyEvent.VK_LEFT) {
                    System.out.println("LEFT");
                }
                if(keyCode == KeyEvent.VK_RIGHT) {
                    System.out.println("RIGHT");
                }
            }
        }
    }
    
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

    public void keyTyped(KeyEvent arg0) {

    }
}
