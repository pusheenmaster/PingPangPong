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
    protected int hauteur;  // verif
    protected int largeur;  // vérifier utilisée
    protected int vitesse;
     /** La direction (angle par rapport à l'axe horizontal*/
    protected double direction;
    protected BufferedImage image;
    
    
    public Objet(int x, int y, String nomImage, double direction, int vitesse){
        this.x = x;
        this.y = y;
        try {
             image= ImageIO.read(new File(nomImage));
        } catch(Exception err) {
            System.out.println(nomImage +" introuvable !");            
            System.exit(0);
        } 
        this.direction = direction;
        this.vitesse = vitesse;
        this.largeur = image.getWidth();
        this.hauteur = image.getHeight();
    }
    
    
    
    public int getX(){
        return x;
    }
    /*
    public int getY(){
        return y;
    }*/
    
    /** Methode pour bouger l'objet. Delta s'exprime en ms **/
    public boolean bouger() {
		x +=  vitesse*Math.cos(direction);
		y +=  vitesse*Math.sin(direction);
		return true;
	}
    
    public boolean collision(Objet o){
        return true;
    }
    
    public void dessiner(Graphics g, JPanel jp){
		g.drawImage(image,x,y,jp);
    }
		
}

