package sleutelbarricade;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class Frame extends JFrame {
    
    public Frame(String title, int width, int height){           
        this.setTitle(title);
        
        //Set the sizes of the frame        
        this.setPreferredSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        
        //Add playField 2D array of Objects
        SleutelBarricade sleutelBarricade = new SleutelBarricade();
        sleutelBarricade.setPreferredSize(new Dimension(width, height));
        this.add(sleutelBarricade);
       
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);          
    }
    
    public static void main(String[] args) {
        Frame gameFrame = new Frame("SleutelBarricade", 570, 700);
    }
}
