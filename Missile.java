public class Missile extends ObjetMobile {
	
    private BufferedImage imagePointe
    //private int x     // x personnage
    private int taille;
    private int largeurFleche;
    //private int y;
    
    public Missile() {
        super();
	x = perso.get
	taille = 0;
    }
	
	public int getTaille(){
		return taille;
	}
	
public void dessiner(Graphics g, JFrame jf){
    y = jf.getHeight() - taille - imagePointe.getHeight();
    g.drawImage(imagePointe, x, y, jf);
    g.fillRect(x + imagePointe.getWidth()/2 - largeurFleche/2, jf.getHeight() - taille , largeurfleche, taille);



public boolean bouger(){
    if(y>0){
        taille += vitesse;
        return true;
    }
    return false;
}
	
}
    
