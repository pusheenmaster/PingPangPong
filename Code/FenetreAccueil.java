import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;

public class FenetreAccueil extends JFrame implements ActionListener{

    //Declaration des attributs de la fenêtre
    
    // * * * AFFICHAGE * * *
    // taille fenêtre
    private final int LARGEUR = 900;
    private final int HAUTEUR = 700;
    // Panels
    private JPanel panelPrincipal = new JPanel();
    private JPanel panelCommandes = new JPanel();
    private PanAffichage panelAffichage;
    // Boutons
    private JButton boutonJouer = new JButton();
    private JButton boutonScores = new JButton();
    private JButton boutonCredits = new JButton();
    private JButton boutonAccueil = new JButton();
    
    // * * * DEROULEMENT DU JEU * * *
    private boolean jeuEnCours = false;
    private boolean debut = true;
    
    /**
     * Constructeur de la classe UneFenetre
     */
    public FenetreAccueil(){

        // Nom de la fenetre
        super("PANG");

        // Dimensions de la fenetre, position et fermeture
        this.setSize(new Dimension(LARGEUR,HAUTEUR));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);

        // Création des éléments visibles sur la fenetre
        boutonJouer.setText("Lancer la Partie");
        boutonScores.setText("HighScores");
        boutonCredits.setText("Crédits");
        boutonAccueil.setText("Retour");
        
        //Création du conteneur principal
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(new BorderLayout());
        
        //Création des conteneurs secondaires
        panelAffichage = new PanAffichage(LARGEUR,HAUTEUR-50);
        
        panelCommandes.setPreferredSize(new Dimension(LARGEUR,50));
        panelCommandes.setBackground(Color.BLUE);
        GridLayout gl = new GridLayout(1, 4, 10, 10);
        panelCommandes.setLayout(gl);
        

        //Ajout des éléments graphiques aux conteneurs
        panelCommandes.add(boutonScores);
        panelCommandes.add(boutonJouer);
        panelCommandes.add(boutonCredits);
        panelCommandes.add(boutonAccueil);
        panelPrincipal.add(panelAffichage, BorderLayout.CENTER);
        panelPrincipal.add(panelCommandes, BorderLayout.SOUTH);
                
        //Lier les evênements aux objets
        boutonJouer.addActionListener(this);
        boutonScores.addActionListener(this);
        boutonCredits.addActionListener(this);
        boutonAccueil.addActionListener(this);
        
        //Mise en place du conteneur principal dans la fenetre
        this.setContentPane(panelPrincipal);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == boutonJouer) {
            Partie nouvellePartie = new Partie();
            setTitle("PANG ! Temps : "+nouvellePartie.get(temps)/1000+" Vies : "+0);
            jeuEnCours = true;
            debut = false;
            panelAffichage = new PanScores(LARGEUR,HAUTEUR-50);
        }
        
        if (e.getSource() == boutonScores) {
            setTitle("PANG ! Tableau des Scores");
            jeuEnCours = false;
            debut = false;
            panelAffichage = new PanScores(LARGEUR,HAUTEUR-50);
        }
        
        if (e.getSource() == boutonCredits) {
            setTitle("PANG ! Crédits");
            jeuEnCours = false;
            debut = false;
            panelAffichage = new PanCredits(LARGEUR,HAUTEUR-50,"cred.png");
        }  
        if (e.getSource() == boutonAccueil || debut) {
            setTitle("PANG !");
            jeuEnCours = false;
            panelAffichage = new PanAccueil(LARGEUR,HAUTEUR-50,"space.png");
        }
        repaint();
        }
    
    public void paint(Graphics g) {
        super.paint(g);
        panelAffichage.paintComponent(g);
    }
    
    public static void main(String[] args){
        FenetreAccueil f = new FenetreAccueil();
    }
}
