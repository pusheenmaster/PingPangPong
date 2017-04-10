import javax.swing.*;
import java.awt.event.*;
import javax.swing.JButton;
import java.util.EventObject;


public class EcouteurButtonPerso implements ActionListener {
    private PanPerso pan;

    /**Constructeur de EcouteurButtonPerso
    *@param pan (PanPerso)
    **/
    public EcouteurButtonPerso(PanPerso pan) {
        this.pan=pan;
    }

    /**La méthode actionPerformed(ae) définit le personnage et le fond qui s'affichera pour la partie
    *@param ae (ActionEvent)
    **/	
    public void actionPerformed(ActionEvent ae) {
		JButton b = (JButton) (ae.getSource());
		pan.getJoueur().setPerso(new Personnage(b.getIcon().toString(),900,700)); //choisir un personnage
    }
}
