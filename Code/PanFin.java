import java.awt.*;
import javax.swing.*;

public class PanFin extends JPanel {
	
	 
	public PanFin(){
		this.setLayout(new BorderLayout());
		this.setBackground(Color.DARK_GRAY);
		JLabel image = new JLabel (new ImageIcon("Fin.png"));
		this.add(image, BorderLayout.NORTH);
		
		
    }
	
}

