import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.JPanel;
import java.util.LinkedList ;
import java.awt.Graphics;


public class PanJeu extends PanAffichage implements KeyListener, ActionListener {
	
    // Attibuts
	private Partie partie;
    
    // Touches clavier
    private boolean toucheGauche;
    private boolean toucheDroit;
    private boolean toucheSpace;
	
    // * * * TIMER * * *
    private int temps;
    private final int TPS_TIMER_MS = 100;
    private Timer monTimer;
    
	public PanJeu(int LARGEUR, int HAUTEUR, Timer monTimer, Partie p){
        super(LARGEUR, HAUTEUR);
		partie = p;
        
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
    
    public void actionPerformed(ActionEvent e){
        // actualisation du jeu à chaque pas de temps
        temps += TPS_TIMER_MS;
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

		partie.getPersonnage().dessiner(g, this);
		
		for(int i = 0 ; i< partie.getListeMissiles().size() ; i++){
			partie.getListeMissiles().get(i).dessiner(g, this);
		}
		for(int i = 0 ; i< partie.getListeBalles().size() ; i++){
			partie.getListeBalles().get(i).dessiner(g, this);
		}
	}
}
