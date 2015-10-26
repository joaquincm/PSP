

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jcresmira
 */
public class TocTocHilos {

    static boolean salir = false;
 static int i = 0;
    public static void fin() {
        salir = true;
    }

    public static void main(String[] args) {

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("****Hilo 1*****");

                while (!salir) {
                    System.out.println(i++);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        
        
        hilo.start();
        

    }
}
