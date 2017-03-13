import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Missile extends ObjetMobile {
	
    private BufferedImage imagePointe;  
    private int taille;
    
    
    public Missile(int x) {    // x personnage
        super(x, 0);
        taille = 0;
        largeur = 10;
        hauteur = taille + imagePointe.getHeight();
    }
	
    public int getTaille(){
		return taille;
	}
	
    public void dessiner(Graphics g, JFrame jf){
        y = jf.getHeight() - taille - imagePointe.getHeight();
        g.drawImage(imagePointe, (int)x, (int)y, jf);
        g.fillRect((int)(x + imagePointe.getWidth()/2 - largeur/2), jf.getHeight() - taille , largeur, taille);
    }

    public boolean bouger(){
        if(y>0){
            taille += vitesse;
            return true;
        }
        return false;
    }
	
}
    
