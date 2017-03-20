import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Missile extends Objet { // mettre fenetre jeu taille inchangeable
	
    private int taille; //taille rectangle fleche
    
    public Missile(int xPerso, JPanel jp ) {   
        super(xPerso, 0, "pointe1.png", Math.PI/2, 10);
        y = jp.getHeight() - hauteur;
        taille = jp.getHeight() - hauteur - y;
        
    }
    
	
    public int getTaille(){
		return taille;
	}
	
    public void dessiner(Graphics g , JPanel jp){
        super.dessiner(g, jp);
        g.fillRect((int)(x + largeur/4), jp.getHeight() - taille , largeur/2, taille);
    }

    public boolean bouger(JPanel jp){
		if(y<=0){
			return false;
		}else{
            taille += vitesse;
            hauteur = taille + hauteur;
            return super.bouger();
        }
    }
	
}
    
