import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Missile extends Objet {
	
    private int taille; //taille rectangle fleche
    private boolean enHaut;
    
    public Missile(int xPerso, int largPan, int hautPan ) {   
        super(xPerso, 0, "missile.png", -Math.PI/2, 0, 80);
        y = hautPan - hauteur;
        taille = hautPan - hauteur - y;
        enHaut = false;
        
    }
  
    public int getTaille(){
		return taille;
	}
	
	public boolean getEnHaut(){
		return enHaut;
	}
	
    public void dessiner(Graphics g , JFrame fen){
        super.dessiner(g, fen);
        g.setColor(Color.BLACK);
        g.fillRect((int)(x + largeur/2), fen.getHeight() - taille , 5, taille);
    }

    public boolean bouger(JFrame fen){
		if(y<=20){
			enHaut = true;
			return false;
		}else{
            taille += vitesseY;
            hauteur += taille;
            return super.bouger();
        }
    }
	
}
    
