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
    
    SleutelBarricade sb;
    
    public KeyInput(){
        
    }
    
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        System.out.println(sb.getObjects().get(0).getObjectName());
        
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
    
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        if(keyCode == KeyEvent.VK_UP) {
            System.out.println("UP presseddown");
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
    
//    public void keyPressed(KeyEvent e){
//        int key = e.getKeyCode();
//        
//        for(int i=0; i<handler.objects.size(); i++){
//            GameObject temporaryObject = handler.objects.get(i);
//            
//            if(temporaryObject.getId() == ID.Player){
//                if(key == KeyEvent.VK_W) handler.setUp(true);
//                if(key == KeyEvent.VK_A) handler.setLeft(true);
//                if(key == KeyEvent.VK_S) handler.setDown(true);
//                if(key == KeyEvent.VK_D) handler.setRight(true);
//            }
//        }
//    }
}
