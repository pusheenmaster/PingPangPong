import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Fenetre extends JFrame {
  private JTabbedPane onglet;
   
  public Fenetre(LesScores scores){
	  
    this.setLocationRelativeTo(null);
    this.setTitle("PING PANG PONG !!!!");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(800, 530);
    this.setLocationRelativeTo(null);
      
    //Création panneaux
    
    //Création de notre conteneur d'onglets
    onglet = new JTabbedPane();
    onglet.add("Accueil",new PanAccueil());
    onglet.add("Nouvelle Partie", new PanPerso());
    onglet.add("Scores ", new PanScores(scores));
    onglet.add("Crédits", new PanCredits());
    
    //On passe ensuite les onglets au content pane
    this.getContentPane().add(onglet);
    this.setVisible(true);
  }
  
  
  public boolean finPartie(){
	  return true;
  }
  
  public static void main(String[] args){
	  LesScores scores = new LesScores();
		scores.ajouterScore("Paddy", 1000);
		scores.ajouterScore("croe", 2000);
		scores.ajouterScore("Bouh", 100);
    Fenetre fen = new Fenetre(scores);
  }   
}

