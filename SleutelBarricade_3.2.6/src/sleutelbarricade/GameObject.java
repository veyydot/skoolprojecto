package sleutelbarricade;

import java.awt.Graphics;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int passCode;
    
    public GameObject(int x, int y){
        setX(x);
        setY(y);
    }
    
    public GameObject(int x, int y, int passCode){
        setX(x);
        setY(y);
        setPassCode(passCode);
    }
    
    public abstract void display();
    
    public abstract void render(Graphics g);

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
