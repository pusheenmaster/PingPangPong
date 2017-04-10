import java.awt.event.*;
import java.util.*;
import java.awt.Color;


public class EcouteurBoutonOK implements ActionListener{ 
	
	private FenetreFin fenFin;
	
       /**Constructeur de EcouteurBoutonOK
       *@param
       **/
	public EcouteurBoutonOK(FenetreFin fen ){
		this.fenFin = fen;
	}
	
       /**La méthode ActionPerformed(e) ouvre un nouveau panel de jeu avec le nom choisi, le personnage et le fond
       *associé et affiche "nouveau jeu lancé" dans le terminal
       *@param e (ActionEvent)
       **/
	public void actionPerformed(ActionEvent e){
		fenFin.dispose();
		Fenetre fen = new Fenetre(fenFin.getFenJeu().getJoueur().getNom(), fenFin.getScoreFinal());
    }
    
}



