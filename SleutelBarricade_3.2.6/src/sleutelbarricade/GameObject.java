/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public abstract class GameObject {
    private int x;
    private int y;
    private int passCode;
    
    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public GameObject(int x, int y, int passCode){
        this.x = x;
        this.y = y;
        this.passCode = passCode;
    }
    
    public void display(){};

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

    public int getPassCode() {
        return passCode;
    }

    public void setPassCode(int passCode) {
        this.passCode = passCode;
    } 
    
}
