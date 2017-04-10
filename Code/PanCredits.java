
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;

public class PanCredits extends JPanel{
    
    /**Constructeur de Pancredit, affiche l'image des crédits
    **/
    public PanCredits(){
		JLabel J = new JLabel (new ImageIcon("credits.png"));
		
		this.add(J);
	}
}
