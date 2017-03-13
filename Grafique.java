import java.awt.Graphics2D;
import java.awt.Image;

public class Grafique {
    
    private Image image;
    
    public Grafique( Image image) {
        this.image = image;
    }
    
    public int getWidth() {
        return image.getWidth(null);
    }
    
    public int getHeight() {
        return image.getHeight(null);
    }
    
    public void draw( int x, int y, Graphics2D g) {
        g.drawImage(image, x, y, null);
    }
}
