/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jcresmira
 */
public class InterruptHilo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Tarea : " + i);
               
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        InterruptHilo hilo = new InterruptHilo();
        hilo.start();
       
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println("Estoy esperando a que terminen las tareas...");
            } catch (InterruptedException e) {
            }
//        }
        }
        try {
            hilo.join();
        } catch (InterruptedException e) {
        }
        System.out.println("FINNNNNNNN! Tareas terminadas");

    }
}
