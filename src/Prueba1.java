/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jcresmira
 */
public class Prueba1 {
    public static void main(String[] args) {
        Thread hilo = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("hilo: "+i);
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){}               
                }
            }
        });
        hilo.start();
    }
    
}
