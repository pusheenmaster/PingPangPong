import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;

public class FenetreAccueil extends JFrame implements ActionListener, KeyListener {

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
    
    // * * * TIMER * * *
        private final int TPS_TIMER_MS = 100;
    private Timer monTimer;
    
    // * * * DEROULEMENT DU JEU * * *
    private int temps;
    private boolean jeuEnCours = false;

    // Touches clavier
    private boolean toucheGauche;
    private boolean toucheDroit;
    private boolean toucheSpace;
    
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
 
        // TIMER
        monTimer = new Timer(TPS_TIMER_MS,this);
        temps = 0;
        
        // Evenement clavier
        toucheGauche = false;
        toucheDroit = false;
        toucheSpace = false;
        addKeyListener(this);
        
        //Mise en place du conteneur principal dans la fenetre
        this.setContentPane(panelPrincipal);
        this.setVisible(true);
        monTimer.start();
    }
    
    public void actionPerformed(ActionEvent e){
        if(jeuEnCours){
            temps += TPS_TIMER_MS;
            setTitle("PANG ! Temps : "+temps/1000+" Vies : "+0);
            if (toucheDroit){
            }
            if (toucheGauche){
            }
            if (toucheSpace) {
            }
        }
        if (e.getSource() == boutonJouer) {
            temps += TPS_TIMER_MS;
            setTitle("PANG ! Temps : "+temps/1000+" Vies : "+0);
            jeuEnCours = true;
            panelAffichage = new PanScores(LARGEUR,HAUTEUR-50);
        }
        
        if (e.getSource() == boutonScores) {
            setTitle("PANG ! Tableau des Scores");
            jeuEnCours = false;
            panelAffichage = new PanScores(LARGEUR,HAUTEUR-50);
        }
        
        if (e.getSource() == boutonCredits) {
            setTitle("PANG ! Crédits");
            jeuEnCours = false;
            panelAffichage = new PanCredits(LARGEUR,HAUTEUR-50,"cred.png");
        }  
        if (e.getSource() == boutonAccueil) {
            setTitle("PANG !");
            jeuEnCours = false;
            panelAffichage = new PanAccueil(LARGEUR,HAUTEUR-50,"space.png");
        }
        repaint();
        }
    
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_ESCAPE : System.exit(0); break;
            case KeyEvent.VK_ENTER :
                if (monTimer.isRunning())
                    monTimer.stop();
                else
                    monTimer.start();
            break;
            case KeyEvent.VK_SPACE : toucheSpace=true; break;        
            case KeyEvent.VK_LEFT : toucheGauche=true; break;        
            case KeyEvent.VK_RIGHT : toucheDroit=true; break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_SPACE : toucheSpace=false; break;        
            case KeyEvent.VK_LEFT : toucheGauche=false; break;        
            case KeyEvent.VK_RIGHT : toucheDroit=false; break;    
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        panelAffichage.paintComponent(g);
    }
    
    public static void main(String[] args){
        FenetreAccueil f = new FenetreAccueil();
    }

}
