import java.awt.Graphics;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.File;

public class Personnage extends Objet{
	
	private BufferedImage image;
    private int nbVies;
    
    public Personnage(String nomImage){
        super();
        try{
			image = ImageIO.read(new File(nomImage));
		} catch(Exception e) {
		}
        position = new Point(200, image.getHeight());
        hauteur = image.getHeight();
        largeur = image.getWidth();
        nbVies = 3;
    }
        
    
    public int getNbVies(){
        return nbVies;
    }
    
    public void setNbVies(int nb){
        nbVies = nb;
    }
    
    public boolean deplacement(boolean gauche){
		if(gauche){
			position.setLocation(   // attributs x et y
		}
        return true;
    }
    
    
    public void dessiner(Graphics g, JFrame jf){
		g.drawImage(image,(int)position.getX(),(int)position.getY(),jf);
    }
		
}

