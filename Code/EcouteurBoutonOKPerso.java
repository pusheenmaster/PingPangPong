import java.awt.event.*;
import java.util.*;
import java.awt.Color;


public class EcouteurBoutonOKPerso implements ActionListener{ 
	
	private PanPerso pan;
	
	public EcouteurBoutonOKPerso(PanPerso pan){
		this.pan = pan;
	}
	
	public void actionPerformed(ActionEvent e){
		pan.getJoueur().setNom(pan.getTextField().getText());
		FenetreJeu fenJeu= new FenetreJeu(pan.getJoueur());
		System.out.println("nouveau jeu lancé");
    }
    
}



