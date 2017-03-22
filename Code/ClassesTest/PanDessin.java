import javax.swing.JPanel;
import java.util.LinkedList ;
import java.awt.Graphics;


public class PanDessin extends JPanel {
	
	private MaFenTest fen;
	
	public PanDessin(MaFenTest fen){
		this.fen = fen;
	}
	
	protected void paintComponent(Graphics g){
	
		super.paintComponent(g);

		fen.getMissile().dessiner(g, this);
		fen.getPersonnage().dessiner(g, this);
		fen.getBalle().dessiner(g, this);
		

	}
	
	
}

