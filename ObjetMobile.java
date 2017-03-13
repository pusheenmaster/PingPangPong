import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class ObjetMobile extends Objet {
    
	/** La position sur x */
    protected double x;
    /** La position sur y */
    protected double y;
    /** La vitesse */
    protected double vitesse;
    /** La direction (angle par rapport à l'axe horizontal et le coin haut gauche) **/
    protected double direction;
    
    /** Constructeur */
    public ObjetMobile(String file, int x, int y) {
        super(file,x,y);
    }
    
    /** Methode pour bouger l'objet. Delta s'exprime en ms **/
    public void bouger() {
		x=+vitesse*Math.cos(direction);
		y=+vitesse*Math.sin(direction);
	}
}
