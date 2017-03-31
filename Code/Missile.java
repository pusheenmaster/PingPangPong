import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Missile extends Objet { // mettre fenetre jeu taille inchangeable
	
    private int taille; //taille rectangle fleche
    
    public Missile(int xPerso, int largPan, int hautPan ) {   
        super(xPerso, 0, "missile.png", -Math.PI/2, 25);
        y = hautPan - hauteur;
        taille = hautPan - hauteur - y;
        
    }
  
    public int getTaille(){
		return taille;
	}
	
    public void dessiner(Graphics g , JFrame fen){
        super.dessiner(g, fen);
        g.setColor(Color.BLACK);
        g.fillRect((int)(x + largeur/2), fen.getHeight() - taille , 5, taille);
    }

    public boolean bouger(JFrame fen){
		if(y<=0){
			return false;
		}else{
            taille += vitesse;
            hauteur += taille;
            return super.bouger();
        }
    }
	
}
    
