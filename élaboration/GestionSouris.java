import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GestionSouris implements MouseListener {

    private Grille g;
    private JFrame fenetre;
    public GestionSouris (Grille z, JFrame fenetre) {
        this.g=z;
        this.fenetre=fenetre;
    }

    public void mouseClicked(MouseEvent evenement){

        MyPanel etiquette;
        etiquette=(MyPanel)evenement.getSource();
        new ChoixData(this.g,etiquette.getI(),etiquette.getJ(), this.fenetre);
        System.out.println(etiquette.getI() + " "+ etiquette.getJ());
    }        // un bouton cliqué
    
    public void mouseEntered(MouseEvent evenement){
        MyPanel etiquette;
        etiquette=(MyPanel)evenement.getSource();
        etiquette.setBackground(Color.GRAY);      
    }  // debut du survol
    
    public void mouseExited(MouseEvent evenement){
        MyPanel etiquette;
        etiquette=(MyPanel)evenement.getSource();
        etiquette.setBackground(Color.WHITE);
        
    }  // fin du survol
    
    public void mousePressed(MouseEvent evenement){}          // un bouton appuyé
    public void mouseReleased(MouseEvent evenement){}
} 
