/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.OyunYonetimi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

/**
 *
 * @author Onur ŞAKRAKER
 */
public class ButtonDinleyici implements ActionListener {

    OyunYonetimi oy = new OyunYonetimi();
    JToggleButton onceki;

    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton tiklananDugme = (JToggleButton) e.getSource();
        String name = tiklananDugme.getName();
        tiklananDugme.setText(name);

        if (oy.kontrolEt(Integer.parseInt(name))) {
            tiklananDugme.setEnabled(false);

        } else {
            tiklananDugme.setSelected(false);
            tiklananDugme.setText(" ");
            onceki.setSelected(false);
            onceki.setEnabled(true);
            onceki.setText(" ");
        }
        this.onceki = (JToggleButton) e.getSource();

    }

}
