package sleutelbarricade;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Tom Spek, Colin Werkhoven, Vedat Yilmaz
 */
public class Frame extends JFrame {
    private Graphics g;
    private final String invIcon_IMG_PATH = "src/images/Key.jpeg";
    public Frame(String title, int width, int height){           
        this.setTitle(title);
        
        //Set the sizes of the frame        
        this.setPreferredSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));
        this.setMaximumSize(new Dimension(width, height));
        
        
        //Add control buttons and other graphics to the field
        ImageIcon invIcon = new ImageIcon(invIcon_IMG_PATH);
        JLabel inventory = new JLabel(invIcon);
        inventory.setText("0");
        inventory.setBounds(600,31,200,100);
        inventory.setBorder(new TitledBorder("Inventory"));
        this.add(inventory);
        JButton randomize = new JButton("Randomize level");
        randomize.setBounds(600,181,200,40);
        randomize.setEnabled(true);
        this.add(randomize);
        //Add playField 2D array of Objects
        SleutelBarricade sleutelBarricade = new SleutelBarricade();
        sleutelBarricade.setPreferredSize(new Dimension(width, height));
        sleutelBarricade.randomizeField(g);
        this.add(sleutelBarricade);
       
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);          
    }
    
    public static void main(String[] args) {
        Frame gameFrame = new Frame("SleutelBarricade", 900, 700);        
    }
}
