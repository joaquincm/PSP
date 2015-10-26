/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Votaciones;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcresmira
 */
public class Principal {

    public static int[] partidos = new int[5];
    private final static int NUMEROVOTANTES = 10000;
    static Votante[] vt = new Votante[NUMEROVOTANTES];

    public static void main(String[] args) {
        Votante v = null;

        for (int i = 0; i < NUMEROVOTANTES; i++) {
            v = new Votante("Votante " + i);
            v.start();
            vt[i] = v;
        }
        
        //ACABAN TODOS
        for (int i = 0; i < vt.length; i++) {
            try {
                vt[i].join();
            } catch (InterruptedException ex) {
             
            }
        }

        Votante.totalVotosPartido();



    }
}
