package bolas;


import bolas.Disparos;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bola extends Thread {

    private int radio;
    private int posicionx;
    private int posiciony;
    private Color color;
    private int ms;

    public int getMs() {
        return ms;
    }

    public enum Velocidad {

        LENTA(100), NORMAL(50), RAPIDA(10);
        private int ms;

        private Velocidad(int ms) {
            this.ms = ms;
        }

        public int getMs() {
            return ms;
        }
    }

    public Bola(int radio, Velocidad velocidad, int posicionx, int posiciony, Color color) {
        this.radio = radio;
        this.posicionx = posicionx;
        this.posiciony = posiciony;
        this.color = color;
        this.ms=ms;
        start();
    }

    public void pintar(Graphics g) {
        g.setColor(color);
        g.fillOval(posicionx, posiciony, radio, radio);
    }

    public void moverBola() {
        posicionx += 1;
//        posiciony +=1;
    }

    @Override
    public void run() {
        while (Bola.currentThread().isAlive()) {
            try {
                Thread.sleep(ms);
                moverBola();
                Disparos.tablero.repaint();
        
            } catch (InterruptedException ex) {
            }
        }

    }

    public int getPosicionx() {
        return posicionx;
    }

    public int getPosiciony() {
        return posiciony;
    }
}
