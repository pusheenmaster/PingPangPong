import java.awt.*;
import javax.swing.*;
import javax.swing.text.StyledDocument;

public class FenetreFin extends JFrame {
	
	 
	public FenetreFin(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
        
        JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		panelPrincipal.setBackground(Color.PINK);
        
        JPanel panelSecondaire = new JPanel();
		panelSecondaire.setLayout(new GridLayout());
		panelSecondaire.setBackground(Color.BLUE);
		
		JLabel image = new JLabel (new ImageIcon("Fin.png"));
        Dimension dim = new Dimension(580,180);
		image.setPreferredSize(dim);
		
		JTextArea texte = new JTextArea();
        texte.setText("hello");
        
        JTextArea chiffres = new JTextArea();
        chiffres.setText("3");
        
        panelSecondaire.add(texte);
		panelSecondaire.add(chiffres);
        panelPrincipal.add(panelSecondaire, BorderLayout.CENTER);
		panelPrincipal.add(image, BorderLayout.NORTH);
		
		this.setContentPane(panelPrincipal);
		this.setVisible(true);
    }
	
    public static void main( String[] args){
        FenetreFin f = new FenetreFin();
    }
}
