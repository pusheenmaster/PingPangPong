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
    private int hauteurMax;
    private boolean monte;
    private int sens;
    private boolean rebond1;
    
    /** Balle qui part de gauche a droite **/
	public Balle(int numero, JFrame fen, int x0, int y0){
        super(x0,y0,("balle_"+numero+".png"), 2*Math.PI/3, numero*5); // toutes les balles initialisée pareil
        //super(600, 100 ,"balle.png", 2*Math.PI/3, 30 );
        this.numero = numero;
        hauteurMax = numero*100; // a changer en fonction numero
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
		if(direction == Math.PI/3){
			direction = 2*direction;
		}
		else{
			direction = Math.PI/3;
		}
	}
	
    public boolean bouger(JFrame fen ){
		
		super.bouger();
		
		if(!rebond1){
			super.bouger();
		}
		if(!rebond1 && (x<0 ||  x > fen.getWidth()-largeur   ||  y > fen.getHeight() - hauteur)  ){
			rebond1 = true;
		}
		
		if(rebond1 && x<0){
			x = 0;
			changeDirection();
			
		}
		if(rebond1 &&  x > fen.getWidth()-largeur){
			x = fen.getWidth()- largeur;
			changeDirection();
		}
		if(rebond1 &&  y < hauteurMax){
			y = hauteurMax;
			changeDirection();
			vitesse = -vitesse;
		}
		if(rebond1 && y > fen.getHeight() - hauteur){
			y = fen.getHeight() - hauteur;
			changeDirection();
			vitesse = -vitesse;
		}
		return true;
	}
	
}



