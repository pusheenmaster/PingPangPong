import javax.swing.*;
import java.awt.*;
import javax.imageio.*;

public class PanPerso extends JPanel {
	
	private Joueur joueur;
	private JTextField textField= new JTextField("Croe",15);


	
	public PanPerso (){
		
		joueur = new Joueur("Croe",new Personnage("perso1.png",900,700)); // joueur par défaut
		
		JPanel panButtons = new JPanel(new FlowLayout());
		JPanel panNom = new JPanel(new FlowLayout());

		// Si l'imagine n'existe pas, le JLabel est crée sans image
		JLabel label = new JLabel("nom :");
		panNom.add(label);
		panNom.add(textField);
		JLabel choixPerso = new JLabel("choisissez votre personnage :  ");
		panButtons.add(choixPerso);
		
		ImageIcon imgIcon1 = new ImageIcon("perso1.png");
		JButton b1 = new JButton(imgIcon1);
		b1.addActionListener(new EcouteurButtonPerso(this));
		panButtons.add(b1);
		
		ImageIcon imgIcon2 = new ImageIcon("perso2.png");
		JButton b2 = new JButton(imgIcon2);
		b2.addActionListener(new EcouteurButtonPerso(this));
		panButtons.add(b2);
		
		ImageIcon imgIcon3 = new ImageIcon("perso3.png");
		JButton b3 = new JButton(imgIcon3);
		b3.addActionListener(new EcouteurButtonPerso(this));
		panButtons.add(b3);
		
		ImageIcon imgIcon4 = new ImageIcon("perso4.png");
		JButton b4 = new JButton(imgIcon4);
		b4.addActionListener(new EcouteurButtonPerso(this));
		panButtons.add(b4);
		
		JButton boutonOK = new JButton("Lancer la partie !");
		boutonOK.addActionListener(new EcouteurBoutonLancerPartie(this));
		JPanel panOK = new JPanel(new FlowLayout());
		panOK.add(boutonOK);
		
		JLabel instructions = new JLabel (new ImageIcon("instructions.png"));
		JPanel panBas = new JPanel(new BorderLayout());
		panBas.add(instructions, BorderLayout.CENTER);
		panBas.add(panOK, BorderLayout.SOUTH);
		

		this.setLayout(new BorderLayout());
		this.add(panNom, BorderLayout.NORTH);
		this.add(panButtons, BorderLayout.CENTER);
		this.add(panBas, BorderLayout.SOUTH);
		
	}
	
	public JTextField getTextField(){
		return textField;
	}
	
	public Joueur getJoueur(){
		return joueur;
	}

}
