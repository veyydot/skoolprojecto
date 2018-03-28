package sleutelbarricade;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class Key extends GameObject{
    
    private final String Key_IMG_PATH = "src/images/Key.jpeg";    
    private BufferedImage Key = null;
    
    public Key(int x, int y, int passCode) {
        super(x, y, passCode);
    }
    
    public void initializeImages(){
        try{
            Key = ImageIO.read(new File(Key_IMG_PATH));
                 
        }catch(IOException exc){
            exc.printStackTrace();
        }
    }

    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Key, x, y, null);
    }
}
