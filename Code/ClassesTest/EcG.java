import javax.swing.*;
import java.awt.event.*;

/**
 * Cette classe nous servira de test pour les composants graphiques
 */
public class EcG implements ActionListener {
    private MaFenTest fen;

    public EcG(MaFenTest f) {
        fen=f;
    }

    public void actionPerformed(ActionEvent ae) {
       fen.getPersonnage().setDirection(Math.PI);
       fen.getPersonnage().bouger(fen.getPanDessin());
       fen.getPanDessin().repaint();
    }
}
