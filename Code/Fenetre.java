import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Fenetre extends JFrame {
  private JTabbedPane onglet;
  
  /**Constructeur de Fenetre
  *@param scores (LesScores)
  **/
  public Fenetre(LesScores scores){
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
  
  /**méthode main, à executer
  **/	
  public static void main(String[] args){
	  LesScores scores = new LesScores();
          Fenetre fen = new Fenetre(scores);
  }   
}

