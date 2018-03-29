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
    protected boolean isFull = false;
    
    public GameObject(int x, int y, boolean isFull){
        setX(x);
        setY(y);
        isFull = true;
    }
    
    public GameObject(int x, int y, int passCode, boolean isFull){
        setX(x);
        setY(y);
        setPassCode(passCode);
        isFull = true;
    }
    
    public abstract void initializeImages();
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
