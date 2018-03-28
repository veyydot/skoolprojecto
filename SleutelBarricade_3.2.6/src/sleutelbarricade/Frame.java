/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import java.awt.Dimension;
import javax.swing.JFrame;

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
       
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);        
    }  
}
