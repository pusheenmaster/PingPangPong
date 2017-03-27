import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;

public class FenetreAccueil extends JFrame implements ActionListener{
    
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
    private JButton boutonSelection = new JButton();
    
    // * * * DEROULEMENT DU JEU * * *
    private Personnage persoChoisi = new Personnage("paddy.jpg",LARGEUR/2,HAUTEUR-50);
    private Joueur joueurChoisi =new Joueur("Moi", persoChoisi);
    private boolean jeuEnCours = false;
    private boolean debut = true;
    LesScores scores = new LesScores();
    
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

        // Création des éléments visibles sur la fenetre
        boutonJouer.setText("Lancer la Partie");
        boutonScores.setText("HighScores");
        boutonCredits.setText("Crédits");
        boutonAccueil.setText("Retour");
        boutonSelection.setText("Changer de Joueur");
        
        //Création du conteneur principal
        panelPrincipal.setBackground(Color.BLUE);
        panelPrincipal.setLayout(new BorderLayout());
        
        //Création des conteneurs secondaires
        panelAffichage = new PanAffichage(LARGEUR,HAUTEUR-50);
        
        panelCommandes.setPreferredSize(new Dimension(LARGEUR,50));
        panelCommandes.setBackground(Color.WHITE);
        GridLayout gl = new GridLayout(1, 5, 10, 10);
        panelCommandes.setLayout(gl);
        

        //Ajout des éléments graphiques aux conteneurs
        panelCommandes.add(boutonScores);
        panelCommandes.add(boutonJouer);
        panelCommandes.add(boutonCredits);
        panelCommandes.add(boutonAccueil);
        panelCommandes.add(boutonSelection);
        panelPrincipal.add(panelAffichage, BorderLayout.CENTER);
        panelPrincipal.add(panelCommandes, BorderLayout.SOUTH);
                
        //Lier les evênements aux objets
        boutonJouer.addActionListener(this);
        boutonScores.addActionListener(this);
        boutonCredits.addActionListener(this);
        boutonAccueil.addActionListener(this);
        boutonSelection.addActionListener(this);
        
        //Mise en place du conteneur principal dans la fenetre
        this.setContentPane(panelPrincipal);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == boutonJouer) {
            Partie nouvellePartie = new Partie(joueurChoisi,persoChoisi);
            panelAffichage = new PanJeu(LARGEUR,HAUTEUR-50,nouvellePartie);
            setTitle("PANG ! Temps : "+((PanJeu) panelAffichage).getTemps()/1000+" Vies : "+0);
            jeuEnCours = true;
            debut = false;
        }
        
        if (e.getSource() == boutonSelection) {
           //FenetreSelection = new FenetreSelection();
        }
        
        if (e.getSource() == boutonScores) {
            setTitle("PANG ! Tableau des Scores");
            panelAffichage = new PanScores(LARGEUR,HAUTEUR-50,scores);
            jeuEnCours = false;
            debut = false;
        }
        
        if (e.getSource() == boutonCredits) {
            setTitle("PANG ! Crédits");
            jeuEnCours = false;
            debut = false;
            panelAffichage = new PanCredits(LARGEUR,HAUTEUR-50,"cred.jpg");
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
