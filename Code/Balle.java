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
    
    /** Balle qui part de gauche a droite **/
	public Balle(int numero, JPanel jp){
        super(200, 0 ,("balle_"+numero+".png"), 2*Math.PI/3, 2 ); // toutes les balles initialisée pareil
        this.numero = numero;
        hauteurMax = 4*jp.getHeight()/5; // a changer en fonction numero
        monte = false;
    }
    
    public int getNumero(){
    	return numero;
    }
    
    
    public void bouger(JPanel jp){
		while(x + (int)(vitesse*Math.cos(direction))>jp.getWidth()-largeur){
			x=jp.getWidth()-largeur;
			this.direction+=Math.PI/2;
		}
		while(x + (int)(vitesse*Math.cos(direction))<0){
			x=0;
			this.direction+=Math.PI/2;
		}
		while(y + (int)(vitesse*Math.sin(direction))>jp.getHeight()-hauteurMax-hauteur){
			y=hauteurMax-image.getHeight();
			this.direction+=Math.PI/2;
		}
		while(y + (int)(vitesse*Math.sin(direction))<0){
			y=0;
			this.direction+=Math.PI/2;
		}
		super.bouger();
	}
	
}



