
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.JPanel;
import java.util.LinkedList ;


public class FenetreJeu extends JFrame implements KeyListener, ActionListener {
        
    // Attibuts Principaux   
    private Fenetre fenPrincipale;
    private Personnage perso;
    private Joueur joueur;
    private LinkedList<Balle> listeBalles;
    private Missile missile;
    
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
    public boolean affFin = false;
    
    // Attibuts pour comptage des scores   
    private int derniereCollision; // 1 si balle touchée, 0 sinon
    private int nbRose;
    private int nbBleu;
    private int nbViolet;
    private int nbCyan;
    private int nbVert;
    
    public FenetreJeu(Joueur joueur, Fenetre fenPrincipale){
		
		this.fenPrincipale = fenPrincipale;
        
        nbRose = 0;
        nbBleu = 0;
        nbViolet = 0;
        nbCyan = 0;
        nbVert = 0;
		
		this.setTitle("PANG !!!!");
		this.setSize(1100, 700);
		this.setResizable(false);
        this.setLocationRelativeTo(null);
		
        this.joueur=joueur;
        this.perso=joueur.getPerso();
        listeBalles = new LinkedList<Balle>();
        listeBalles.add(new Balle(1,this, 0,0));
        missile = null;
        numero = perso.getNum();
        System.out.println(numero);
      
        // Initialisation du buffer
        buff = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
        
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
        this.setTitle("Temps : "+temps/1000 + "      Vies : " + perso.getNbVies() );
        
        
        //missile en haut fenetre
        if(missile != null && missile.getEnHaut()){
			missile = null;
		}
		//collision balle/perso
		for (int i=0 ; i<listeBalles.size() ; i++) {
            if (perso.collision(listeBalles.get(i))) {
                perso.perdreUneVie();
                listeBalles.remove(i);
                derniereCollision = 0;
            }
            // collision balle/missile
			if(missile != null &&  listeBalles.get(i).collision(missile)){
				if(listeBalles.get(i).getNumero() < 5){
					Balle b1 = (new Balle(listeBalles.get(i).getNumero()+1,this, listeBalles.get(i).getX() ,listeBalles.get(i).getY()));
					Balle b2 = (new Balle(listeBalles.get(i).getNumero()+1,this, listeBalles.get(i).getX() ,listeBalles.get(i).getY()));
					b2.changeDirection();
					listeBalles.add(b1);
					listeBalles.add(b2);
				}
                derniereCollision = 1;
                majCompteurs(listeBalles.get(i).getNumero());
				listeBalles.remove(i);
				missile =null;
			}
				
        }
		
        if(toucheDroit){
            perso.setDirection(0);
            perso.bouger(this);
        }
        if(toucheGauche){
            perso.setDirection(Math.PI);
            perso.bouger(this);
        }
        if(toucheSpace){
            missile = new Missile(perso.getX(),getWidth(),getHeight());
        }
        
        if(jeuFini() && !affFin){
            FenetreFin fenF = new FenetreFin(this,fenPrincipale);
			this.dispose();
            affFin=true;
            perso.reinitialiserVies();
		}
        repaint();
    }
    
    
        
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_ESCAPE : this.fenPrincipale.setVisible(true); this.dispose(); break;
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
        
            if(missile != null){
				missile.bouger(this);
				missile.dessiner(buffer, this);
			}
				
            perso.dessiner(buffer, this);
            for(int i = 0 ; i< listeBalles.size() ; i++){
                    listeBalles.get(i).bouger(this);
                    listeBalles.get(i).dessiner(buffer, this);

            }
            g.drawImage(buff,0,0,this);
        }
        
        public boolean jeuFini(){
            return listeBalles.size()==0  ||  perso.getNbVies()<=0;
        }
    
        
        // Getters
        public int getDerniereCollision(){
            return derniereCollision;
        }
        public int getNbVies(){
            return perso.getNbVies();
        }
        public int getNbRose(){
            return nbRose;
        }
        public int getNbBleu(){
            return nbBleu;
        }
        public int getNbViolet(){
            return nbViolet;
        }
        public int getNbVert(){
            return nbVert;
        }
        public int getNbCyan(){
            return nbCyan;
        }
        public int getTemps(){
            return temps/1000;
        }
        public Joueur getJoueur(){
			return joueur;
		}
        
        // Mis à jour des compteurs de balles touchées
        public void majCompteurs(int i){
            if(i==1){
                nbRose++;
            }
            if(i==2){
                nbBleu++;
            }
            if(i==3){
                nbViolet++;
            }
            if(i==4){
                nbCyan++;
            }
            if(i==5){
                nbVert++;
            }
        }
}
