import java.awt.Graphics;
import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.File;

public class Personnage extends Objet{
	
	private int num;
    private int nbVies;
    
    public Personnage(String nomImage, int largPan, int hautPan){
        super(largPan/2 , 0, nomImage, Math.PI, 50, 0);
        if(nomImage == "perso4.png"){
			num=4;
		} else if(nomImage == "perso2.png"){
			num=2;
		} else if(nomImage == "perso3.png"){
			num=3;
		} else {
			num=1;
		}
		y = hautPan - hauteur;
        nbVies = 5;
    }
   
      
	public int getNum(){
        return num;
    }
    public int getNbVies(){
        return nbVies;
    }
    
    public void perdreUneVie(){
        nbVies--;
    }
    
    public boolean bouger(JFrame fen){  // always returns true
		super.bouger();
		if(x > fen.getWidth() - largeur){
			x = fen.getWidth() - largeur;
		}else if(x<0){
			x = 0;
		}
        return true;
    }
		
}

