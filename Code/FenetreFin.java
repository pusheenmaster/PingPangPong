import java.awt.*;
import javax.swing.*;
import javax.swing.text.StyledDocument;

public class FenetreFin extends JFrame {
	
    private FenetreJeu fenJ;
    private int scoreFinal;
    private int c;
	 
	public FenetreFin(FenetreJeu fenJ){
        
        this.fenJ = fenJ;
        calculScore();
        Color couleur = new Color(193,193,255);
        
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
        
        JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		panelPrincipal.setBackground(couleur);
        
        JPanel panelSecondaire = new JPanel();
		panelSecondaire.setLayout(new GridLayout());
		
        if(fenJ.getDerniereCollision() == 1){
            JLabel image = new JLabel (new ImageIcon("Win.gif"));
            Dimension dim = new Dimension(200,200);
            image.setPreferredSize(dim);
            panelPrincipal.add(image, BorderLayout.NORTH);
        }else{
            JLabel image = new JLabel (new ImageIcon("GameOver.jpg"));
            Dimension dim = new Dimension(200,200);
            image.setPreferredSize(dim);
            panelPrincipal.add(image, BorderLayout.NORTH);
        }
		
        
		JTextArea texte = new JTextArea();
        texte.setText("  Balles touchées : \n"
        +"    Rose : \n"
        +"    Bleu : \n"
        +"    Violet : \n"
        +"    Cyan : \n"
        +"    Vert : \n"
        +"\n  Vies restantes : \n"
        +"\n  Bonus Temps: \n"
        +"\n  SCORE FINAL : "
        );
        texte.setBackground(couleur);
        
        JTextArea chiffres = new JTextArea();
        chiffres.setText("\n"
        +"10 x "+fenJ.getNbRose()+"\n"
        +"20 x "+fenJ.getNbBleu()+"\n"
        +"30 x "+fenJ.getNbViolet()+"\n"
        +"40 x "+fenJ.getNbCyan()+"\n"
        +"50 x "+fenJ.getNbVert()+"\n"
        +"\n"+50*fenJ.getDerniereCollision()+" x "+fenJ.getNbVies()+"\n"
        +"\n"+3*(180-fenJ.getTemps())*fenJ.getDerniereCollision()+"\n"
        +"\n"+scoreFinal);
        chiffres.setBackground(couleur);
        
        panelSecondaire.add(texte);
		panelSecondaire.add(chiffres);
        panelPrincipal.add(panelSecondaire, BorderLayout.CENTER);
		
		this.setContentPane(panelPrincipal);
		this.setVisible(true);
    }
	
   public void calculScore(){
       System.out.println(fenJ.getTemps());
       System.out.println(3*(180-fenJ.getTemps()));
        scoreFinal = fenJ.getNbRose()*10+fenJ.getNbBleu()*20
        +fenJ.getNbViolet()*30+fenJ.getNbCyan()*40+fenJ.getNbVert()*50
        +fenJ.getNbVies()*50*fenJ.getDerniereCollision()+3*(180-fenJ.getTemps())*fenJ.getDerniereCollision();
    }
}
