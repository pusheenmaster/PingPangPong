import java.awt.event.*;
import java.util.*;
import java.awt.Color;


public class EcouteurBoutonOKScores implements ActionListener{ 
	
	private WindowScores window;
	
	public EcouteurBoutonOKScores(WindowScores win){
		window = win;
	}
	
	
	public void actionPerformed(ActionEvent e){
		
		window.dispose();

    }
    
}



