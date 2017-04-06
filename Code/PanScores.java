
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.JTable;

public class PanScores extends JPanel{
    
    // Images
    private LesScores scores;
    private String  title[];
    
    public PanScores(LesScores scores){
		
		this.setLayout(new BorderLayout());
        this.scores = scores;
        String  title[] = {"Nom", "Score"}; // ne s'affichent pas
		JTable tableau = new JTable(scores.getLesScores(),title);
		
		JLabel image = new JLabel (new ImageIcon("Score.png"));
		
		
		JPanel panTableau = new JPanel();
		
		this.add(image, BorderLayout.NORTH);
		
		panTableau.add(tableau); 
		panTableau.setBackground(Color.DARK_GRAY);
		this.add(panTableau, BorderLayout.CENTER);

		

		 
		this.setBackground(Color.DARK_GRAY);
    }
    
}
