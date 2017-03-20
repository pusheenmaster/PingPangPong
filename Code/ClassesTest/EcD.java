import javax.swing.*;
import java.awt.event.*;

/**
 * Cette classe nous servira de test pour les composants graphiques
 */
public class EcD implements ActionListener {
    private MaFenTest fen;

    public EcD(MaFenTest f) {
        fen=f;
    }

    public void actionPerformed(ActionEvent ae) {
       fen.getPersonnage().deplacement(false);
       fen.getPanDessin().repaint();
    }
}
