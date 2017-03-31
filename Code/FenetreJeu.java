
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.JPanel;
import java.util.LinkedList ;


public class FenetreJeu extends JFrame implements KeyListener, ActionListener {
        
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
    private int numero;
    
    // Affichage 
    private Image imageFond;
    private BufferedImage buff;
    
    public FenetreJeu(Joueur joueur){
		this.setLocationRelativeTo(null);
		this.setTitle("PANG !!!!");
		this.setSize(900, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
        partie = new Partie(joueur,this);
        numero = joueur.getPerso().getNum();
        System.out.println(numero);
      
        // Initialisation du buffer
        buff = new BufferedImage(900,700,BufferedImage.TYPE_INT_RGB);
        
        // Chargement de l'image d'arrière plan
        Toolkit t = Toolkit.getDefaultToolkit();
        imageFond = t.getImage("fond"+numero+".jpg");
        
        // Evenement clavier
        toucheGauche = false;
        toucheDroit = false;
        toucheSpace = false;
        addKeyListener(this);
        
        // TIMER
        monTimer = new Timer(TPS_TIMER_MS,this);
        temps = 0;
        monTimer.start();
        
        this.setVisible(true);
        
        System.out.println("joueur : "+joueur.getNom());
    }
     
    public void actionPerformed(ActionEvent e){
        // actualisation du jeu à chaque pas de temps
        temps += TPS_TIMER_MS;
        this.setTitle("Temps : "+temps/1000);
        if(toucheDroit){
            partie.getPersonnage().setDirection(0);
            partie.getPersonnage().bouger(this);
        }
        if(toucheGauche){
            partie.getPersonnage().setDirection(Math.PI);
            partie.getPersonnage().bouger(this);
        }
        if(toucheSpace){
            Missile nouvMissile = new Missile(partie.getPersonnage().getX(),900,700);
            partie.getListeMissiles().add(nouvMissile);
        }
        repaint();
    }
        
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_ESCAPE : this.dispose(); break;
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
        
        public void paint(Graphics g){
            // préparation de l'affichage en dessinant dans le buffer
            Graphics buffer = buff.getGraphics(); // récupération de l'objet Graphics associé au buffer
            buffer.drawImage(imageFond,0,0,this); // dessin dans cet objet Graphics
            for(int i = 0 ; i< partie.getListeMissiles().size() ; i++){
				    partie.getListeMissiles().get(i).bouger(this);
                    partie.getListeMissiles().get(i).dessiner(buffer, this);
            }
            partie.getPersonnage().dessiner(buffer, this);
            for(int i = 0 ; i< partie.getListeBalles().size() ; i++){
                    partie.getListeBalles().get(i).bouger(this);
                    partie.getListeBalles().get(i).dessiner(buffer, this);

            }
            g.drawImage(buff,0,0,this);
        }
}
