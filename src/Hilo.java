/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jcresmira
 */
public class Hilo extends Thread {

    public Hilo(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + " > " + i);            
            try {
                Thread.sleep(500);

            } catch (InterruptedException ex) {
            }
        }
    }

    public static void main(String[] args) {
        Hilo h1 = new Hilo("Hilo 1");
        Hilo h2 = new Hilo("Hilo 2");
        Hilo h3 = new Hilo("Hilo 3");
        Hilo h4 = new Hilo("Hilo 4");
        
        h1.start();
        h2.start();
        h3.start();
        h4.start();
//        h1.run();
//        h2.run();
        
    }
}
