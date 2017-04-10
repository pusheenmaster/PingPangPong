import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.lang.Math; 
import java.lang.Object;

public class Balle extends Objet {
	
    private int numero;
    private int hauteurMax; // plus les balles sont petites, moins elles montent haut
    private boolean monte;
    private int sens;
    private boolean rebond1;
    
    /** Balle qui part de gauche a droite **/
	public Balle(int numero, JFrame fen, int x0, int y0){
        super(x0,y0,("balle_"+numero+".png"), Math.PI/5, 15, 30); // toutes les balles initialisée pareil
        this.numero = numero;
        hauteurMax = (int)(Math.sqrt(numero)*200); // a changer en fonction numero
        monte = false;
        sens = 1;
        rebond1 = false;
    }
    
    public int getNumero(){
    	return numero;
    }
    
    public int getHauteurMax(){
		return hauteurMax;
	}
	
    public double getDirection(){
		return direction;
	}
	
    public boolean getMonte(){
		return monte;
	}
	
    public int getSens(){
		return sens;
	}
    
    public void changeDirection(){
		if(direction == Math.PI/5){
			direction = 4*direction;
		}
		else{
			direction = Math.PI/5;
		}
	}
	
    public void setVitesse(){
		if(y >= hauteurMax){
			vitesseY = vitesseX * ((y-hauteurMax)/80 +1);
		}
		else{
			vitesseY = vitesseX;
		}
	}
	
    public boolean bouger(JFrame fen ){
		
		super.bouger();
		setVitesse();
		
		if(!rebond1){
			super.bouger();
		}
		if(!rebond1 && (x<0 ||  x > fen.getWidth()-largeur   ||  y > fen.getHeight() - hauteur)  ){ //quand la balle atteind le bord ou sa hauteur maximale
			rebond1 = true;
		}
		
		if(rebond1 && x<0){ //quand la balle atteind le bord gauche
			x = 0;
			changeDirection();
			
		}
		if(rebond1 &&  x > fen.getWidth()-largeur){ //quand la balle atteind le bord droit
			x = fen.getWidth()- largeur;
			changeDirection();
		}
		if(rebond1 &&  y < hauteurMax){ //quand la balle touche le sol
			y = hauteurMax;
			changeDirection();
			vitesseX = -vitesseX;
			vitesseY = -vitesseY;
		}
		if(rebond1 && y > fen.getHeight() - hauteur){ //quand la balle atteind sa hauteur maximale
			y = fen.getHeight() - hauteur;
			changeDirection();
			vitesseY = -vitesseY;
			vitesseX = -vitesseX;
		}
		return true;
	}
	
}



