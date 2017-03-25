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
    
    public void setDirection(double dir){
		direction = dir;
	}
    
    public int getY(){
        return y;
    }
    
    /** Methode pour bouger l'objet. Delta s'exprime en ms **/
    public boolean bouger() {
		x +=  vitesse*Math.cos(direction);
		y +=  vitesse*Math.sin(direction);
		return true;
	}
    
    public boolean collision(Objet o){
        Object ob = new Object();			//création d'un objet pour créer les boites
		//Boite1
		Ellipse2D boite1 = (Ellipse2D)ob;	//transformation de l'objet en ellipse pour la boite1
		boite1.setFrame((double)x,(double)y,(double)hauteur,(double)largeur);	//attribution des caractéristiques de l'ellipse
		//Boite2
		Ellipse2D boite2 = (Ellipse2D)ob;	//idem pour la boite2
		boite2.setFrame((double)o.x,(double)o.y,(double)o.hauteur,(double)o.largeur);
        return boite1.intersects((double)o.x,(double)o.y,(double)o.hauteur,(double)o.largeur)&&boite2.intersects((double)x,(double)y,(double)hauteur,(double)largeur);
		//return true si l'ellipse qui entoure le premier objet intersecte le rectangle qui entoure le second
		//et qu'en même temps, l'ellipse qui entoure le second objet intersecte le rectangle qui entoure le premier
    }
    
    public void dessiner(Graphics g, JPanel jp){
		g.drawImage(image,x,y,jp);
    }
		
}

