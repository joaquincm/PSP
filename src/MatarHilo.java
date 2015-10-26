/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jcresmira
 */
public class MatarHilo {

    static boolean salir = false;
    static int i = 1;

    public static void fin() {
        salir = true;
    }

    public static void main(String[] args) {

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {

                while (!salir) {
                    System.out.println(i++);
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        hilo.start();
        System.out.println("Esperando 4 segundos..");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }
        System.out.println("Hilo cerrado");
        fin();
    }
}
