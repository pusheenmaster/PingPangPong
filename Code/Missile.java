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
    
    /**Constructeur de Missile, instancie sa taille, sa postisiont et qu'il n'a pas atteind le haut de la fenêtre
    *@param xPerso (int), largPan (int), heutPan (int)
    **/
    public Missile(int xPerso, int largPan, int hautPan ) {   
        super(xPerso, 0, "missile.png", -Math.PI/2, 0, 80);
        y = hautPan - hauteur;
        taille = hautPan - hauteur - y;
        enHaut = false;
        
    }
  
    /**la méthode getTaille() retourne la taille du missile
    *@return taille (int)
    **/
    public int getTaille(){
		return taille;
	}
	
    /**la méthode getEnHaut() dit si le missile a atteind le heut de la fenêtre
    *@return enHaut (boolean)
    **/
    public boolean getEnHaut(){
		return enHaut;
	}
	
    /**la méthode dessiner(g, fen) affiche le missile
    *@param g (Graphics), fen (JFrame)
    **/
    public void dessiner(Graphics g , JFrame fen){
        super.dessiner(g, fen);
        g.setColor(Color.BLACK);
        g.fillRect((int)(x + largeur/2), fen.getHeight() - taille , 5, taille);
    }

    /**la méthode bouger(fen) fait monter le missile
    *@param fen (JFrame)
    *@return boolean
    **/
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
    
