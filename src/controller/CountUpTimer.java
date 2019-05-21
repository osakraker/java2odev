/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author mAysu
 */
public class CountUpTimer implements Runnable {

    Date start = new Date();
    //static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat sdf;
    static JLabel sureDeger;
    public static Timer timer;

    public CountUpTimer(JLabel sureDeger) {
        this.sureDeger = sureDeger;

        //Date now = new Date();
        //sureDeger.setText(sdf.format(new Date(now.getTime() - start.getTime())));
    }

    @Override
    public void run() {

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                sdf = new SimpleDateFormat("HH:mm:ss");
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                sureDeger.setText(sdf.format(new Date(now.getTime() - start.getTime())));
            }

        });
        timer.start();

    }
}
