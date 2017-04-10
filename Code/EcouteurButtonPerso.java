import javax.swing.*;
import java.awt.event.*;
import javax.swing.JButton;
import java.util.EventObject;


public class EcouteurButtonPerso implements ActionListener {
    private PanPerso pan;

    public EcouteurButtonPerso(PanPerso pan) {
        this.pan=pan;
    }

    public void actionPerformed(ActionEvent ae) {
		JButton b = (JButton) (ae.getSource());
		pan.getJoueur().setPerso(new Personnage(b.getIcon().toString(),900,700)); //choisir un personnage
    }
}
