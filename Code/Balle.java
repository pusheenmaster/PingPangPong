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
    
    /** Balle qui part de gauche a droite **/
	public Balle(int numero, JPanel jp){
        //super(200, 0 ,("balle_"+numero+".png"), 2*Math.PI/3, 2 ); // toutes les balles initialisée pareil
        super(600, 200 ,"balle.png", 2*Math.PI/3, 30 );
        this.numero = numero;
        hauteurMax = 100; // a changer en fonction numero
        monte = false;
        sens = 1;
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
	
	/*public void changeSens(){
		if(monte){
			monte = false;
			sens = 1;
		}
		else{
			monte = true;
			sens = -1;
		}
	}*/
    
    public boolean bouger(JPanel jp){
		/*if(x > vitesse*Math.cos(direction) && y > hauteurMax + vitesse*Math.sin(direction) && x < jp.getWidth() - vitesse*Math.cos(direction) - largeur  &&  y < jp.getHeight()- hauteur ){
			x +=  sens*vitesse*Math.cos(direction);
			y +=  sens*vitesse*Math.sin(direction);
		}else{
			while(x > 0 && x < jp.getWidth()-largeur && y > hauteurMax  &&  y < jp.getHeight()- hauteur ){ //tant qu'on ne touche pas un mur
				x +=  sens*1*Math.cos(direction);
				y +=  sens*1*Math.sin(direction);
			}
			changeDirection();
			changeSens();
			x +=  sens*vitesse*Math.cos(direction);
			y +=  sens*vitesse*Math.sin(direction);
		}*/
		
		super.bouger();
		
		if(x<0){
			x = 0;
			changeDirection();
			
		}
		if(x> jp.getWidth()-largeur){
			x = jp.getWidth()- largeur;
			changeDirection();
		}
		if(y < hauteurMax){
			y = hauteurMax;
			changeDirection();
			//changeSens();
			vitesse = -vitesse;
		}
		if(y > jp.getHeight() - hauteur){
			y = jp.getHeight() - hauteur;
			changeDirection();
			//changeSens();
			vitesse = -vitesse;
		}
		return true;
	}
	
}



