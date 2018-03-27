/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author torri
 */
public class customJpanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
        g.drawRect(100, 100, 400, 400);
        for(int i = 100; i<= 400; i+=100){
        for(int j = 100; j<= 400; j+=100){
        g.clearRect(i,j,50,50);
    }
        
    }
    for(int i = 150; i<=450; i+=100){
        for(int j = 150; j<=450; j+=100)
        {
            g.clearRect(i, j, 50, 50);
        }
    }
    }
    
}
