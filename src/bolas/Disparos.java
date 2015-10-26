package bolas;


import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Disparos implements ActionListener {

    private static final String cArchivo = "Archivo";
    private static final String cDisparoLento = "Disparo Lento";
    private static final String cDisparoNormal = "Disparo Normal";
    private static final String cDisparoRapido = "Disparo R�pido";
    private static final String cSalir = "Salir";
    public static final Tablero tablero = new Tablero();
    JFrame frame = new JFrame("Disparos");
    JMenu mArchivo;
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JButton bDisparoLento = new JButton(cDisparoLento);
    JButton bDisparoNormal = new JButton(cDisparoNormal);
    JButton bDisparoRapido = new JButton(cDisparoRapido);
    JLabel lblbolas = new JLabel("Bolas: \n0");
    public static void main(String[] args) {
        new Disparos().run();
    }

    private void añadeMenu(JFrame frame) {
        mArchivo = new JMenu(cArchivo);
        JMenuItem iDisparoLento = new JMenuItem(cDisparoLento);
        JMenuItem iDisparoNormal = new JMenuItem(cDisparoNormal);
        JMenuItem iDisparoRapido = new JMenuItem(cDisparoRapido);
       

        iDisparoLento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        iDisparoNormal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        iDisparoRapido.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        iDisparoLento.addActionListener(this);
        iDisparoNormal.addActionListener(this);
        iDisparoRapido.addActionListener(this);

        JMenuItem iSalir = new JMenuItem(cSalir);
        iSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        iSalir.addActionListener(this);

        mArchivo.add(iDisparoLento);
        mArchivo.add(iDisparoNormal);
        mArchivo.add(iDisparoRapido);
        mArchivo.addSeparator();
        mArchivo.add(iSalir);
        JMenuBar menu = new JMenuBar();
        menu.add(mArchivo);
        frame.setJMenuBar(menu);
    }

    public void run() {
        añadeMenu(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        bDisparoLento.addActionListener(this);
        bDisparoNormal.addActionListener(this);
        bDisparoRapido.addActionListener(this);
        buttonPanel.add(bDisparoLento);
        buttonPanel.add(bDisparoNormal);
        buttonPanel.add(bDisparoRapido);
        tablero.setPreferredSize(new Dimension(700, 300));
        tablero.setBackground(Color.WHITE);
        frame.getContentPane().add(tablero, BorderLayout.CENTER);
        frame.getContentPane().add(lblbolas,BorderLayout.WEST);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(cSalir)) {
            // Fin del juego
            System.exit(0);
        }
        if (command.equals(cDisparoRapido)) {
            tablero.añadirBolaRapida();
            lblbolas.setText("Bola: \n"+tablero.contar());
            tablero.repaint();
        }
        if (command.equals(cDisparoNormal)) {
            tablero.añadirBolaNormal();
            lblbolas.setText("Bola: \n"+tablero.contar());
            tablero.repaint();
        }
        if (command.equals(cDisparoLento)) {
            tablero.añadirBolaLenta();
            lblbolas.setText("Bola: \n"+tablero.contar());
            tablero.repaint();
        }

    }
}
