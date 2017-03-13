import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;


public class Partie {
    
    // Atributs
    private Image imageFond;
    private Timer timer;
    private Joueur joueur;
    private boolean gauche = false;
    private boolean droite = false;
    private BufferedImage [] boules;
    private boolean finPartie;
    
    // Constructeur
    
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
    public Joueur getJoueur(){
        return joueur;
    }
    public boolean getFinPartie(){
        return finPartie;
    }
    public void setJoueur(Joueur joueur){
        this.joueur = joueur;
    }
    
    
    // Methodes
    public boolean finPartie(){
        
    }
//----------------------------------------------------------------------
    public boolean tirerMissile(){
        
    }
}
