import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;

public class PanAccueil extends JPanel{
    
    /**Constructeur de PanAccueil, affiche l'image d'accueil
    **/
    public PanAccueil(){
		JLabel J = new JLabel (new ImageIcon("Accueil.png"));
		this.add(J);
    }
}

