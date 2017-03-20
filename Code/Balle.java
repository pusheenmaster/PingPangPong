import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.lang.Math; 
import java.lang.Object;

public class Balle extends ObjetMobile {
	
    /** La taille des balles */
    private int size;
    private BufferedImage image;
    private int hauteurMax;
    
    /** Balle qui part de gauche a droite **/
	public Balle(int x, int y, int size){
        super(("balle_"+size+".png"), x, y);
        this.size = size;
        direction = (int)(new java.util.Radom()*2*Math.PI);
        this.x=x;
        this.y=y;
        vitesse=10;
        try {
             image= ImageIO.read(new File("balle_"+size+".png"));
        } catch(Exception err) {
            System.out.println("fichier introuvable !");            
            System.exit(0);
        }
    }
    
    /** Si la balle doit aller dans l'autre direction **/
    public Balle(int x, int y, int size, boolean autreDirection){
        super(("balle_" + size + ".png"), x, y);
        this.size = size; 
    }
    
    public int getX(){
    	return (int) x;
    }
    public int getY(){
    	return (int) y;
    }
    public int getSize(){
    	return size;
    }
    public void setX(int nX){
    	x=nX;
    }
    public void setY(int nY){
    	y=nY;
    }
    
    public void bouger(JPanel p){
		while(x + (int)(vitesse*Math.cos(direction))>p.getWidth()-image.getWidth()){
			x=p.getWidth()-image.getWidth();
			this.direction+=Math.PI/2;
		}
		while(x + (int)(vitesse*Math.cos(direction))<0){
			x=0;
			this.direction+=Math.PI/2;
		}
		while(y + (int)(vitesse*Math.sin(direction))>p.getHeight()-hauteurMax-image.getHeight()){
			y=hauteurMax-image.getHeight();
			this.direction+=Math.PI/2;
		}
		while(y + (int)(vitesse*Math.sin(direction))<0){
			y=0;
			this.direction+=Math.PI/2;
		}
		super.bouger();
	}
	
	public void dessiner(Graphics g, JPanel jp){  // JPanel changements pour test
		g.drawImage(image,(int)x,(int)y,jp);
	}
}



