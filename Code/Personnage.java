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
		 try {
             image = ImageIO.read(new File(nomImage));
        } catch(Exception err) {
            System.out.println("image" +" introuvable !");            
            System.exit(0);
        } 
		x = 200;
		y = 0;
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
			x += 5;
		}else{
			x -= 5;
		}
        return true;
    }
    
    
    public void dessiner(Graphics g, JPanel jp){  // JPanel changements pour test
		y = jp.getHeight() - image.getHeight();
		g.drawImage(image,x,y,jp);
    }
		
}

