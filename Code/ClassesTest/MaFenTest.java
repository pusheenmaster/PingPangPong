import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;


public class MaFenTest extends JFrame{
	
	private PanDessin panDessin;
	public int heightPanDessin;
	public int widthPanDessin;
	
	private Joueur j1;
    private Missile m1;
    private Personnage p1;
	
	/*
	public int getHeight(){
		return heightPanDessin;
	}
	
	public int getWidth(){
		return widthPanDessin;
	}*/
	
	public void setPanDessin(PanDessin panDes){
		panDessin = panDes;
		heightPanDessin = panDessin.getHeight();
		widthPanDessin = panDessin.getWidth();
	}
	
	public PanDessin getPanDessin(){
		return panDessin;
	}
	
	public Missile getMissile(){
		return m1;
	}
	
	public Personnage getPersonnage(){
		return p1;
	}

	public MaFenTest(){
		
		super("Fenetre de dessin");
		
		// Initialisation des objets
        p1 = new Personnage("paddy.jpg");
        j1 = new Joueur("Moi", p1);
        m1 = new Missile(p1.getX());
        
        System.out.println(p1.getX());
        System.out.println(m1.getX());
        
	
		
		JButton btnG = new JButton("gauche");
		btnG.addActionListener(new EcG(this));
		JButton btnD = new JButton("droite");
		btnD.addActionListener(new EcD(this));
		
		panDessin = new PanDessin(this);
		heightPanDessin = panDessin.getHeight();
		widthPanDessin = panDessin.getWidth();
		
		panDessin.setBackground(Color.BLUE);
		
		JPanel monPanelCommande = new JPanel(new FlowLayout());
		monPanelCommande.add(btnG);
		monPanelCommande.add(btnD);
		
		JPanel cadrePrincipal = new JPanel(new BorderLayout());
		cadrePrincipal.add(monPanelCommande, BorderLayout.SOUTH);
		cadrePrincipal.add(panDessin, BorderLayout.CENTER);
		
		this.setContentPane(cadrePrincipal);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,700);
		setVisible(true);
				
	}

	
	
}

