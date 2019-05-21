package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Component;
import javax.swing.JOptionPane;
import view.OyunFrame;

/**
 *
 * @author Onur ŞAKRAKER
 */
public class OyunYonetimi {

    OyunFrame of;
    int deger = 0;
    int sayac = 0;
    static int dogru = 0;
    static int puan = 0;
    
    public boolean kontrolEt(int value) {
        if (deger == 0) {
            deger = value;
            return true;
        } else if (deger == value) {
            deger = 0;
            sayac++;
            puan +=50;
            oyunSonuc();
            return true;
        } else {
            deger = 0;
            puan -=20;
            return false;
        }
    }

    public void setAdet(int adet) {
        dogru = adet / 2;
    }

    public void oyunSonuc() {
        if (sayac == dogru) {
            puan *= dogru * 2;
            Component OyunFrame = null;
            of.puanDeger.setText(Integer.toString(puan));
            CountUpTimer.timer.stop();
            JOptionPane.showMessageDialog(OyunFrame, "Oyun bitti.", "Mesaj", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
}
