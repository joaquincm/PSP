/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jcresmira
 */
public class InterrupcionHilo extends Thread {

    static String[] interrupciones = {"Primera", "Segunda", "Tercera"};

    @Override
    public void run() {
        int i = 0;
        int cont_toc_toc = 0;
        System.out.println("Comienzo...");
        while (cont_toc_toc <=  interrupciones.length) {
            System.out.println(i++ + "");
            if (Thread.interrupted()) {

                if (cont_toc_toc < interrupciones.length) {
                    System.out.println(interrupciones[cont_toc_toc] + " interrupción. Ni caso,estoy trabajando");
                } else {
                    System.out.println("Qué pesados!. Tendré que parar de trabajar e ir ver quién es.");
                }
                cont_toc_toc++;
            }
        }
    }

    public static void main(String[] args) {
        InterrupcionHilo hilo = new InterrupcionHilo();
        hilo.start();
        int cont_toc_toc = 0;
        while (cont_toc_toc <= interrupciones.length) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
            if (!hilo.isInterrupted()) {
                System.out.println("TOC TOC");
                hilo.interrupt();
                cont_toc_toc++;
            }
        }
    }
}
