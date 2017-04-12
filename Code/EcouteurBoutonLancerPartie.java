import java.awt.event.*;
import java.util.*;
import java.awt.Color;


public class EcouteurBoutonLancerPartie implements ActionListener{ 
	
	private PanPerso pan;
	
       /**Constructeur de EcouteurBoutonLancerPartie
       *@param pan (PanPerso)
       **/
	public EcouteurBoutonLancerPartie(PanPerso pan){
		this.pan = pan;
	}
	
       /**La méthode ActionPerformed(e) ouvre un nouveau panel de jeu avec le nom choisi, le personnage et le fond
       *associé. Elle ferme la fenetre principal, ouvre une fenetre de jeu et affiche "nouveau jeu lancé" dans le terminal
       *@param e (ActionEvent)
       **/
	public void actionPerformed(ActionEvent e){
		pan.getJoueur().setNom(pan.getTextField().getText());
		FenetreJeu fenJeu= new FenetreJeu(pan.getJoueur(), pan.getFen());
		pan.getFen().setVisible(false);
		System.out.println("nouveau jeu lancé");
    }
    
}



