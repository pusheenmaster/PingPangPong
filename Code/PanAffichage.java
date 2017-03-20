import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;

public class PanAffichage extends JPanel{
    
    // Attributs
    
    public PanAffichage(int LARGEUR, int HAUTEUR){
        this.setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
    }
    
    public void paintComponent(Graphics g){
        
    }
}
