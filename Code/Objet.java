import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.File;

public class Objet {
	
	protected int x; 
    protected int y;
    protected int hauteur;
    protected int largeur;
    protected int vitesse;
     /** La direction (angle par rapport à l'axe horizontal et le coin haut gauche)*/
    protected int direction;
    protected BufferedImage image;
    
    
    // choisir les construteurs
    public Objet(int x, int y, int hauteur, int largeur){
        this.x = x;
        this.y = y;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }
    
    public Objet(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Objet(String nbFichier, int x, int y){
        this.x = x;
        this.y = y;
    }
        
    public Objet(){
    }   
    
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    /** Methode pour bouger l'objet. Delta s'exprime en ms **/
    public void bouger() {
		x +=(int) vitesse*Math.cos(direction);
		y +=(int) vitesse*Math.sin(direction);
	}
    
    public boolean collision(Objet o){
        return true;
    }
    
    public void dessiner(Graphics g, JPanel jp){
		g.drawImage(image,x,y,jp);
    }
		
}

