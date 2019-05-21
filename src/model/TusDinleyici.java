/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author mAysu
 */
public class TusDinleyici implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            System.out.println("Hello");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
}
