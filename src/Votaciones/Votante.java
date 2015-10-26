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
public class Votante extends Thread {

   
    public final int TIEMPOMAXIMO = 500;
    public int totalVotos = 0;

    public Votante(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int espera = (int) Math.floor(Math.random() * (TIEMPOMAXIMO - 1 + 1) + 1);
            Thread.sleep(espera);
            int numpartido = (int) Math.floor(Math.random() * (Principal.partidos.length - 1 + 1));
                    
            //ENTRAN DE UNO EN UNO
             synchronized(Principal.partidos){
                System.out.println("votacion al partido: " + numpartido);  
//                Principal.partidos[numpartido]++;
                int num_votos = Principal.partidos[numpartido];
           
                Principal.partidos[numpartido] = num_votos+1;
            }
        } catch (InterruptedException ex) {
            System.out.println("INTERRUPTUS");
        }
    }



    public static void totalVotosPartido() {
        int total = 0;
        for (int i = 0; i < Principal.partidos.length; i++) {
            System.out.println("Partido "+i+" : "+Principal.partidos[i]);
            
        }
        for (int i = 0; i < Principal.partidos.length; i++) {
             total += Principal.partidos[i];
        }
        System.out.println("Total de votos = "+total);
    }
}
