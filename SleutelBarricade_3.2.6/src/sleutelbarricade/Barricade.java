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
public class Barricade extends GameObject{
    
    private final String Barricade_IMG_PATH = "src/images/Barricade.jpg";    
    private BufferedImage Barricade = null;
    
    public Barricade(String objectName, int x, int y, int passCode) {
        super(objectName, x, y, passCode);
    }
    
    @Override
    public void initializeImages(){
        try{
            Barricade = ImageIO.read(new File(Barricade_IMG_PATH));                 
        }catch(IOException exc){
            exc.printStackTrace();
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Barricade, x, y, null);
    }
}
