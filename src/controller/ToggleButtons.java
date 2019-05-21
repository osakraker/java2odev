/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ButtonDinleyici;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import view.OyunFrame;

/**
 *
 * @author Onur ŞAKRAKER
 */
public class ToggleButtons extends JToggleButton {

    static public JToggleButton buttons[];
    OyunFrame ae;
    
    public ToggleButtons(int kutusayisi, JPanel panel, String duzen) {

        OyunYonetimi oy = new OyunYonetimi();
        ButtonDinleyici od = new ButtonDinleyici();

        if (kutusayisi % 2 == 1) {
            kutusayisi++;
        }

        if (kutusayisi <= 0 ) {
          JOptionPane.showMessageDialog(ae, "Lütfen 0 dan buyuk ve hafızanızda tutabileceğiniz kadar sayı giriniz :) ", "Uyarı", JOptionPane.ERROR_MESSAGE);
          return;
        }
        
        try {
            OyunFrame.sureDeger.setText("00:00:00");
            CountUpTimer.timer.stop();
        } catch (NullPointerException npe) {
        }
       
        OyunYonetimi.puan = 0;
        OyunFrame.puanDeger.setText("0");
        oy.setAdet(kutusayisi);
        
        buttons = new JToggleButton[kutusayisi];

        panel.removeAll();
        panel.repaint();

        ArrayList<Integer> degerler = sayiUret(kutusayisi);
        
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JToggleButton();
            buttons[i].addActionListener(od);
            panel.add(buttons[i]);
            buttons[i].setText(Integer.toString(degerler.get(i)));
            buttons[i].setName(Integer.toString(degerler.get(i)));
           
            buttons[i].setEnabled(false);
        }

        if (duzen == "FlowLayout") {
            panel.setLayout(new FlowLayout());;
        } else {
            panel.setLayout(new GridLayout(3, 1));
        }
        
    }

    public ArrayList<Integer> sayiUret(int kutusayisi) {

        ArrayList<Integer> rastgeleSayilar = new ArrayList<>();

        Random rastgele = new Random();

        for (int i = 0; i < kutusayisi; i++) {
            int n = 1 + rastgele.nextInt(kutusayisi / 2);
            if (indexKontrol(rastgeleSayilar, n) < 2) {
                rastgeleSayilar.add(n);
            } else {
                i--;
            }
        }

        return rastgeleSayilar;
    }

    public int indexKontrol(ArrayList<Integer> list, int deger) {
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == deger) {
                count++;
            }
        }

        return count;
    }
    public void kutuGizle(int adet, JToggleButton[] buttons) {
        for (int i = 0; i < adet; ++i) {
            buttons[i].setText(" ");
            buttons[i].setEnabled(true);
        }
    }
}
