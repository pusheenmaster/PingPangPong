import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.io.File;


public class Objet {
	
	protected int x; 
    protected int y;
    protected int hauteur;  // verif
    protected int largeur;  // vérifier utilisée
    protected int vitesseX;
    protected int vitesseY;
     /** La direction (angle par rapport à l'axe horizontal*/
    protected double direction;
    protected BufferedImage image;
    
    
    /**Constructeur de Ojet instancie la direction, la vitesse horizontale et verticale, l'apparence et la taille de l'objet
    *@param x (int), y (int), nom Image (String), direction (double), vitesseX (int), vitesseY (int)
    **/
    public Objet(int x, int y, String nomImage, double direction, int vitesseX, int vitesseY){
        this.x = x;
        this.y = y;
        try {
             image= ImageIO.read(new File(nomImage));
        } catch(Exception err) {
            System.out.println(nomImage +" introuvable !");            
            System.exit(0);
        } 
        this.direction = direction;
        this.vitesseX = vitesseX;
        this.vitesseY = vitesseY;
        this.largeur = image.getWidth();
        this.hauteur = image.getHeight();
    }
    
    /**la méthode getX retourne la position horizontale de l'objet
    *@retrun x (int)
    **/
    public int getX(){
        return x;
    }
    
    public void setDirection(double dir){
		direction = dir;
	}
    
    public int getY(){
        return y;
    }
    

    
    public int getHauteur(){
		return hauteur;
	}
	
	public int getLargeur(){
		return largeur;
	}
    
    /** Methode pour bouger l'objet. Delta s'exprime en ms **/
    public boolean bouger() {
		x +=  vitesseX*Math.cos(direction);
		y +=  vitesseY*Math.sin(direction);
		return true;
	}
    
    public boolean collision(Objet o){
		Rectangle boite1=new Rectangle(x,y,largeur,hauteur);
		Rectangle boite2=new Rectangle(o.x,o.y,o.largeur,o.hauteur);
		return boite1.intersects(boite2); 
    }
    
    public void dessiner(Graphics g, JFrame fen){
		g.drawImage(image,x,y,fen);
    }
		
}

