import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;

public class FenetreAccueil extends JFrame implements ActionListener, KeyListener {

    //Declaration des attributs de la fenêtre
    
    // TOUCHES CLAVIER
    private boolean toucheGauche;
    private boolean toucheDroit;
    private boolean toucheSpace;
    
    // AFFICHAGE
    private final int LARGEUR = 1000;
    private final int HAUTEUR = 800;
    private JPanel principal = new JPanel();
    private JButton boutonJouer = new JButton();
    private JButton boutonScores = new JButton();
    private JButton boutonCredits = new JButton();
    private Image imageFond;
    private BufferedImage fond;
    
    // TIMER
	private final int TPS_TIMER_MS = 100;
    private Timer monTimer;
    
    // DEROULEMENT DU JEU 
    private int temps;
    private boolean jeuEnCours = false;
    private boolean credits = false;
    private boolean scores = false;
    
    /**
     * Constructeur de la classe UneFenetre
     */
    public FenetreAccueil(){

        //on definit le nom de la fenetre
        super("PANG");

        //Dimensions de la fenetre graphique, position et fermeture
        this.setSize(new Dimension(LARGEUR,HAUTEUR));
		this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setAlwaysOnTop(true);

        //Création des éléments visibles sur la fenetre
		boutonJouer.setText("Lancer la Partie");
        boutonScores.setText("HighScores");
        boutonCredits.setText("Crédits");
        
        // Initialisation du buffer
		fond = new BufferedImage(LARGEUR,HAUTEUR-100,BufferedImage.TYPE_INT_RGB);
        
        // Chargement de l'image d'arrière plan
        Toolkit t = Toolkit.getDefaultToolkit();
		imageFond = t.getImage("space.png");  
        
        //Création du conteneur principal
        principal.setBackground(Color.GREEN);
        principal.setLayout(new BorderLayout());
        
        //Création des conteneurs secondaires 
        JPanel titreAccueil = new JPanel();
        titreAccueil.setPreferredSize(new Dimension(LARGEUR,HAUTEUR-100));
        titreAccueil.setBackground(Color.RED);
        
        JPanel commandes = new JPanel();
        commandes.setPreferredSize(new Dimension(LARGEUR,100));
        commandes.setBackground(Color.BLUE);
        GridLayout gl = new GridLayout(1, 3, 10, 10);
        commandes.setLayout(gl);
        

        //Ajout des éléments graphiques aux conteneurs
        commandes.add(boutonScores);
        commandes.add(boutonJouer);
        commandes.add(boutonCredits);
        principal.add(titreAccueil, BorderLayout.CENTER);
        principal.add(commandes, BorderLayout.SOUTH);
		
		//Lier les evênements aux objets
        boutonJouer.addActionListener(this);
        boutonScores.addActionListener(this);
        boutonCredits.addActionListener(this);
        
        //Mise en place du conteneur principal dans la fenetre
        this.setContentPane(principal);
 
        // TIMER
        monTimer = new Timer(TPS_TIMER_MS,this);
        temps = 0;
        
        // Evenement clavier
        toucheGauche = false;
        toucheDroit = false;
        toucheSpace = false;
        addKeyListener(this);
    
        //Rendre la fenêtre visible
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
            scores = false;
            credits = false;
        }
        
        if (e.getSource() == boutonScores) {
            setTitle("PANG ! Tableau des Scores");
            scores = true;
            credits = false;
            jeuEnCours = false;
        }
        
        if (e.getSource() == boutonCredits) {
            setTitle("PANG ! Crédits");
            scores = false;
            credits = true;
            jeuEnCours = false;
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
        if(credits){
            JPanel panelCredits = new JPanel();
            panelCredits.setPreferredSize(new Dimension(LARGEUR,HAUTEUR-100));
            panelCredits.setBackground(Color.BLACK);
            principal.add(panelCredits, BorderLayout.CENTER);
            this.setContentPane(principal);
        }
        else if(jeuEnCours){
            JPanel panelJeu = new JPanel();
            panelJeu.setPreferredSize(new Dimension(LARGEUR,HAUTEUR-100));
            panelJeu.setBackground(Color.WHITE);
            principal.add(panelJeu, BorderLayout.CENTER);
            this.setContentPane(principal);
        }
        else if(scores){
            JPanel panelScores = new JPanel();
            panelScores.setPreferredSize(new Dimension(LARGEUR,HAUTEUR-100));
            panelScores.setBackground(Color.PINK);
            principal.add(panelScores, BorderLayout.CENTER);
            this.setContentPane(principal);
        } 
        else{
            // préparation de l'affichage en dessinant dans le buffer
            Graphics buffer = fond.getGraphics(); // récupération de l'objet Graphics associé au buffer
            buffer.drawImage(imageFond,0,0,this); // dessin dans cet objet Graphics
            // affichage du contenu du buffer
            g.drawImage(fond,0,0,this);
        }
	}
    
    public static void main(String[] args){
        FenetreAccueil f = new FenetreAccueil();
    }

}
