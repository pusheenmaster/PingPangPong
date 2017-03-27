
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.JPanel;
import java.util.LinkedList ;


public class PanJeu extends PanAffichage implements KeyListener, ActionListener {
        
    // Attibuts
    private Partie partie;
    private int LARGEUR;
    private int HAUTEUR;
    
    // Touches clavier
    private boolean toucheGauche;
    private boolean toucheDroit;
    private boolean toucheSpace;
        
    // * * * TIMER * * *
    private int temps;
    private final int TPS_TIMER_MS = 100;
    private Timer monTimer;
    
    // Affichage 
    private Image imageFond;
    private BufferedImage fond;
    
    public PanJeu(int LARGEUR, int HAUTEUR, Partie p){
        super(LARGEUR, HAUTEUR);
        this.LARGEUR = LARGEUR;
        this.HAUTEUR = HAUTEUR;
        partie = p;
        this.setBackground(Color.GREEN);
        
        // Initialisation du buffer
        fond = new BufferedImage(LARGEUR,HAUTEUR,BufferedImage.TYPE_INT_RGB);
        
        // Chargement de l'image d'arrière plan
        Toolkit t = Toolkit.getDefaultToolkit();
        imageFond = t.getImage("fond.jpg");  
        
        // Evenement clavier
        toucheGauche = false;
        toucheDroit = false;
        toucheSpace = false;
        addKeyListener(this);
        
        // TIMER
        monTimer = new Timer(TPS_TIMER_MS,this);
        temps = 0;
        monTimer.start();
    }
    
    public int getTemps(){
        return temps;
    }
        
    public void actionPerformed(ActionEvent e){
        // actualisation du jeu à chaque pas de temps
        temps += TPS_TIMER_MS;
        if(toucheDroit){
            partie.getPersonnage().setDirection(0);
            partie.getPersonnage().bouger(this);
        }
        if(toucheGauche){
            partie.getPersonnage().setDirection(Math.PI);
            partie.getPersonnage().bouger(this);
        }
        if(toucheSpace){
            Missile nouvMissile = new Missile(partie.getPersonnage().getX(),LARGEUR,HAUTEUR);
            partie.getListeMissiles().add(nouvMissile);
        }
        repaint();
    }
        
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_ESCAPE : System.exit(0); break;
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
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            // préparation de l'affichage en dessinant dans le buffer
            Graphics buffer = fond.getGraphics(); // récupération de l'objet Graphics associé au buffer
            buffer.drawImage(imageFond,0,0,this); // dessin dans cet objet Graphics
            // affichage du contenu du buffer
            g.drawImage(fond,0,0,this);
            partie.getPersonnage().dessiner(g, this);
            for(int i = 0 ; i< partie.getListeMissiles().size() ; i++){
                    partie.getListeMissiles().get(i).dessiner(g, this);
            }
            for(int i = 0 ; i< partie.getListeBalles().size() ; i++){
                    partie.getListeBalles().get(i).bouger(this);
                    partie.getListeBalles().get(i).dessiner(g, this);
            }
        }
}
