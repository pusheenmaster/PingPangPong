import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Missile extends ObjetMobile {
	
    private BufferedImage imagePointe;  
    private int taille;
    
    
    public Missile(int x) {    // x personnage
        super(x,0);
        taille = 200;
        largeur = 10;
        try {
             imagePointe= ImageIO.read(new File("pointe1.png"));
        } catch(Exception err) {
            System.out.println("pointe.jpg" +" introuvable !");            
            System.exit(0);
        } 
        hauteur = taille + imagePointe.getHeight();
    }
    
	
    public int getTaille(){
		return taille;
	}
	
    public void dessiner(Graphics g , JFrame jf){
        y = jf.getHeight() - taille - imagePointe.getHeight();
        g.drawImage(imagePointe, x, y, jf);
        g.fillRect((int)(x + imagePointe.getWidth()/2 - largeur/2), jf.getHeight() - taille , largeur, taille);
    }

    public void bouger(){
        if(y>0){
            taille += vitesse;
            //return true;
        }
        //return false;
    }
	
}
    
