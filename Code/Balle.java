import java.awt.image.BufferedImage;
import javax.swing.*;

public class Balle extends ObjetMobile {
	
    /** La taille des balles */
    private int size;
    private BufferedImage image;
    private int hauteurMax;
    
    /** Balle qui part de gauche a droite **/
	public Balle(String file, int x, int y, int size){
        super((file += "balle_" + size + ".png"), x, y);
        this.size = size;
        x = 200;  
        y = 200;  
    }
    
    /** Si la balle doit aller dans l'autre direction **/
    public Balle(String file, int x, int y, int size, boolean autreDirection){
        super((file += "balle_" + size + ".png"), x, y);
        this.size = size;
        x = -200;  
        y = 200;  
    }
    
    public int getX(){
    	return (int) x;
    }
    public int getY(){
    	return (int) y;
    }
    public int getSize(){
    	return size;
    }
    
    public void bouger(JPanel p){
		while(x + (int)(vitesse*Math.cos(direction))>p.getWidth()-image.getWidth()){
			x=p.getWidth()-image.getWidth();
			this.direction+=Math.PI/2;
		}
		while(y + (int)(vitesse*Math.sin(direction))>hauteurMax-image.getHeight()){
			y=hauteurMax-image.getHeight();
			this.direction+=Math.PI/2;
		}
		super.bouger();
	}
}


