import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Missile extends Objet {
	
    private int taille;
    
    public Missile(int x) {    // x personnage
        super(x,0);
        taille = 200;
        largeur = 10;
        try {
             image= ImageIO.read(new File("pointe1.png"));
        } catch(Exception err) {
            System.out.println("pointe.jpg" +" introuvable !");            
            System.exit(0);
        } 
        hauteur = taille + image.getHeight();
        
    }
    
	
    public int getTaille(){
		return taille;
	}
	
    public void dessiner(Graphics g , JPanel jp){
        y = jp.getHeight() - taille - image.getHeight();
        super.dessiner(g, jp);
        //g.drawImage(image, x, y, jp);
        g.fillRect((int)(x + image.getWidth()/2 - largeur/2), jp.getHeight() - taille , largeur, taille);
    }

    public void bouger(){
		
        if(y>0){
            taille += vitesse;
            //return true;
        }
        //return false;
    }
	
}
    
