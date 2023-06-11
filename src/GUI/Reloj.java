/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jlrt
 */
public class Reloj extends Thread {
    JLabel l;
    boolean mientras;
    public Reloj(JLabel l, boolean mientras) {
        this.l = l;
        this.mientras = mientras;
    }
    
    @Override
    public void run(){
        while(mientras){
            l.setIcon(new ImageIcon("src/Imagenes/reloj.gif"));
        }
    }
}
