
	
import javax.swing.JPanel;
import java.util.LinkedList ;
import java.awt.Graphics;


public class PanJeu extends JPanel {
	
	private Partie partie;
	
	public PanJeu(Partie p){
		partie = p;
	}
	
	protected void paintComponent(Graphics g){
	
		super.paintComponent(g);

		partie.getPersonnage().dessiner(g, this);
		
		for(int i = 0 ; i< partie.getListeMissiles().size() ; i++){
			partie.getListeMissiles().get(i).dessiner(g, this);
		}
		for(int i = 0 ; i< partie.getListeBalles().size() ; i++){
			partie.getListeBalles().get(i).dessiner(g, this);
		}

	}
	
	
}



