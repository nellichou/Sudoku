import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * Observateur GestionSouris de la souris.
 * @version 1.1
 * @author Benjamin Bribant, Nell Telechea
 */
public class GestionSouris implements MouseListener {
/**
 * variable qui va récupérer la grille de jeu
 */
    private Grille g;
    /**
     * fenêtre précédente
     */
    private JFrame fenetre;

    /**
     * Constructeur de Gestion souris.
     *
     * @param z       la grille de jeu
     * @param fenetre fenêtre précédente
     */
    public GestionSouris (Grille z, JFrame fenetre) {
        this.g=z;
        this.fenetre=fenetre;
    }

    public void mouseClicked(MouseEvent evenement){

        MyPanel etiquette;
        etiquette=(MyPanel)evenement.getSource();
        new ChoixData(this.g,etiquette.getI(),etiquette.getJ(), this.fenetre);
        
    }        // on récupère les coordonnées de la case cliquée 
    
    public void mouseEntered(MouseEvent evenement){
        MyPanel etiquette;
        etiquette=(MyPanel)evenement.getSource();
        etiquette.setBackground(Color.GRAY);      
    }  // debut du survol de la case, on change le fond en gris
    
    public void mouseExited(MouseEvent evenement){
        MyPanel etiquette;
        etiquette=(MyPanel)evenement.getSource();
        etiquette.setBackground(Color.WHITE);
        
    }  // fin du survol de la case, on la remet en blanc
    
    public void mousePressed(MouseEvent evenement){}          
    public void mouseReleased(MouseEvent evenement){}
} 
