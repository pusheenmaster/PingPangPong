import java.awt.Point;
import java.awt.Graphics;

public class Objet {
	
	protected int x; 
    protected int y;
    protected int hauteur;
    protected int largeur;
    
    
    // choisir les construteurs
    // image pour missile ou pas ?
    public Objet(int x, int y, int hauteur, int largeur){
        this.x = x;
        this.y = y;
        this.hauteur = hauteur;
        this.largeur = largeur;
    }
    
    public Objet(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Objet(String nbFichier, int x, int y){
        this.x = x;
        this.y = y;
    }
        
    public Objet(){
    }   
    
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    
    public boolean collision(Objet o){
        return true;
    }
    
    public void dessiner(Graphics g){
    }
		
}

