
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;

public class PanCredits extends PanAffichage{
    
    // Images
    private Image imageFond;
    private BufferedImage fond;
    
    public PanCredits(int LARGEUR, int HAUTEUR, String img){
        
        super(LARGEUR, HAUTEUR);
    
        // Initialisation du buffer
        fond = new BufferedImage(LARGEUR,HAUTEUR,BufferedImage.TYPE_INT_RGB);
        
        // Chargement de l'image d'arrière plan
        Toolkit t = Toolkit.getDefaultToolkit();
        imageFond = t.getImage(img);  
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        // préparation de l'affichage en dessinant dans le buffer
        Graphics buffer = fond.getGraphics(); // récupération de l'objet Graphics associé au buffer
        buffer.drawImage(imageFond,0,0,this); // dessin dans cet objet Graphics
        // affichage du contenu du buffer
        g.drawImage(fond,0,0,this);
    }
}
