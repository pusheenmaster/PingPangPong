import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class ObjetMobile extends Objet {
    
	/** La position sur x */
    protected double x;
    /** La position sur y */
    protected double y;
    /** La vitesse suivant x en pixels/ms */
    protected double dx;
    /** La vitesse suivant y en pixels/ms */
    protected double dy;
    /** La direction (angle) **/
    protected double direction;
    
    /** Constructeur */
    public ObjetMobile(String file, int x, int y) {
        super(file,x,y);
    }
    
    /** Methode pour bouger l'objet. Delta s'exprime en ms **/
    public void move( long delta) {
        x += (delta * dx) / 1000;
        y += (delta * dy) / 1000;
    }
}

