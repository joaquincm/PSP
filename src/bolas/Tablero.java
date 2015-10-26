package bolas;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Tablero extends JPanel {

    ArrayList<Bola> lista = new ArrayList<Bola>();
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                lista.get(i).pintar(g);
            }
            

        }

    }

    public void añadirBolaRapida() {
        int x, y;
        y = (int) (Math.random() * (50 - (getHeight() - 50)) + (getHeight() - 50));
        Bola b1 = new Bola(25, Bola.Velocidad.RAPIDA, 0, y, Color.RED);

        lista.add(b1);


    }

    public void añadirBolaNormal() {
        int x, y;
        y = (int) (Math.random() * (50 - (getHeight() - 50)) + (getHeight() - 50));
        Bola b1 = new Bola(35, Bola.Velocidad.NORMAL, 0, y, Color.blue);

        lista.add(b1);

    }

    public void añadirBolaLenta() {
        int x, y;
        y = (int) (Math.random() * (50 - (getHeight() - 50)) + (getHeight() - 50));
        Bola b1 = new Bola(50, Bola.Velocidad.LENTA, 0, y, Color.GREEN);

        lista.add(b1);

    }

    public int contar() {
        return lista.size();
    }
}
