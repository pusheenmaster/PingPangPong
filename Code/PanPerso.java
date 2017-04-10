import javax.swing.*;
import java.awt.*;
import javax.imageio.*;

public class PanPerso extends JPanel {
	
	private Joueur joueur;
	private JTextField textField= new JTextField("Croe",15);
	private Fenetre fen;


	
	public PanPerso(Fenetre fen){
		
		joueur = new Joueur("Croe",new Personnage("perso1.png",900,700)); // joueur par défaut
		this.fen = fen;
		
		JPanel panButtons = new JPanel(new FlowLayout());
		JPanel panNom = new JPanel(new FlowLayout());
		JPanel panHaut = new JPanel(new GridLayout(2,1));
		JPanel panBas = new JPanel(new BorderLayout());
		JPanel panLabel = new JPanel(new FlowLayout());

		JLabel label = new JLabel("nom :");
		panNom.add(label);
		panNom.add(textField);
		
		JLabel choixPerso = new JLabel("choisissez votre personnage :  ");
		panLabel.add(choixPerso);
		
		panHaut.add(panNom);
		panHaut.add(panLabel);
		
		JButton b1 = new JButton(new ImageIcon("perso1.png"));
		b1.addActionListener(new EcouteurButtonPerso(this));
		panButtons.add(b1);
		
		JButton b2 = new JButton(new ImageIcon("perso2.png"));
		b2.addActionListener(new EcouteurButtonPerso(this));
		panButtons.add(b2);
		
		JButton b3 = new JButton(new ImageIcon("perso3.png"));
		b3.addActionListener(new EcouteurButtonPerso(this));
		panButtons.add(b3);
		
		JButton b4 = new JButton(new ImageIcon("perso4.png"));
		b4.addActionListener(new EcouteurButtonPerso(this));
		panButtons.add(b4);
		
		JButton boutonPartie = new JButton("Lancer la partie !");
		boutonPartie.addActionListener(new EcouteurBoutonLancerPartie(this));
		JPanel panLancerPartie = new JPanel(new FlowLayout());
		panLancerPartie.add(boutonPartie);
		
		JLabel instructions = new JLabel (new ImageIcon("instructions.png"));
		panBas.add(instructions, BorderLayout.CENTER);
		panBas.add(panLancerPartie, BorderLayout.SOUTH);
		

		this.setLayout(new BorderLayout());
		this.add(panHaut, BorderLayout.NORTH);
		this.add(panButtons, BorderLayout.CENTER);
		this.add(panBas, BorderLayout.SOUTH);
		
	}
	
	public JTextField getTextField(){
		return textField;
	}
	
	public Joueur getJoueur(){
		return joueur;
	}

	public Fenetre getFen(){
		return fen;
	}

}
