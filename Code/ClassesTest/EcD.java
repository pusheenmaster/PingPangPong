import javax.swing.*;
import java.awt.event.*;


public class EcD implements ActionListener {
    private MaFenTest fen;

    public EcD(MaFenTest f) {
        fen=f;
    }

    public void actionPerformed(ActionEvent ae) {
		
		/**Perso*/
	   /*fen.getPersonnage().setDirection(0);
       fen.getPersonnage().bouger(fen.getPanDessin());*/
       
       /**Missile*/
       
       System.out.println(fen.getBalle().bouger(fen.getPanDessin()));
       System.out.println(fen.getBalle().getX() + "     " +  fen.getBalle().getY()  + "     " +  fen.getBalle().getDirection()  + "     " +  fen.getBalle().getMonte()  + "     " +  fen.getBalle().getSens());
       
       
       fen.getPanDessin().repaint();
    }
}
