import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.LinkedList ;

public class Partie {
    
    // Atributs
    private Image imageFond;
    private FenetreJeu fj;
    private Personnage perso;
    private Joueur joueur;
    private LinkedList<Balle> listeBalles;
    private LinkedList<Missile> listeMissiles;
    
    private boolean gauche = false;
    private boolean droite = false;
    private BufferedImage [] boules;
    private boolean finPartie;
    
    // Constructeur
    public Partie(Joueur joueur, FenetreJeu fj){
        this.joueur=joueur;
        this.fj= fj;
        this.perso=joueur.getPerso();
        listeBalles = new LinkedList();
        listeBalles.add(new Balle(1,fj, 0,0));
        listeMissiles = new LinkedList();
    }
    
    // Accesseurs
    public boolean getGauche(){
        return gauche;
    }
    public boolean getDroite(){
        return droite;
    }
    public Image[] getBoules(){
        return boules;
    }
    public Personnage getPersonnage(){
        return perso;
    }
    public Joueur getJoueur(){
        return joueur;
    }
    public LinkedList<Balle> getListeBalles(){
		return listeBalles;
	}
	public LinkedList<Missile> getListeMissiles(){
		return listeMissiles;
	}
    public boolean getFinPartie(){
        return finPartie;
    }
    public void setJoueur(Joueur joueur){
        this.joueur = joueur;
    }
    public void setPerso(Personnage perso){
        this.perso = perso;
    }
    // Methodes
    public boolean finPartie(){
        return true;
    }
}
