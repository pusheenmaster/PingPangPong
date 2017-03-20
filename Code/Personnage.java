import java.awt.Graphics;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.File;

public class Personnage extends Objet{
	
    private int nbVies;
    
    public Personnage(JPanel jp, String nomImage){
        super(jp.getWidth()/2 , 0, nomImage, 0, 5);
		y = jp.getHeight() - hauteur;
        nbVies = 3;
    }
   
        
    
    public int getNbVies(){
        return nbVies;
    }
    
    public void setNbVies(int nb){
        nbVies = nb;
    }
    
    public boolean bouger(JPanel jp){  // always returns true
		super.bouger();
		if(x > jp.getWidth() - largeur){
			x = jp.getWidth() - largeur;
		}else if(x<0){
			x = 0;
		}
        return true;
    }
		
}

