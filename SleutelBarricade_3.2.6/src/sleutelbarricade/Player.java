/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class Player {
    
    private int x;
    private int y;
    private int inventory;
    
    public Player(int x, int y){
        this.x = x;
        this.y = y;
        this.inventory = 0;
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.drawRect(10, 10, 20, 20);
       
    }
    
    public void pickUpKey(int value){
        
    }
    
    public boolean unlockBarricade(int keyValue, int barricadeValue){
        return false;
    }
    
    public void display(){
        
    }
    
    public boolean movePossible(){
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

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
