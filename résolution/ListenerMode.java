import javax.swing.*;
import java.awt.event.*;


/**
* La classe ListenerMode permet de choisir entre le mode automatique ou le mode manuel.
*
* @version 1.1
* @author Benjamin Bribant, Nell Telechea
*/
public class ListenerMode implements ActionListener {
    
    /**
    *Le bouton mode automatique.
    */
    private JButton auto;

    /**
    *Le bouton mode manuel.
    */
    private JButton existant;


    /**
    * Le constructeur de ListenerMode
    *
    * @param vide     Le bouton mode auto
    * @param existant Le bouton mode manuel
    */
    public ListenerMode(JButton vide, JButton existant) {
        this.auto = vide;
        this.existant = existant;
    }


    /**
    * Observateur qui lance le jeu en fonction du mode choisi. 
    */
    public void actionPerformed(ActionEvent evenement) {
        if (evenement.getSource() == auto) {                //Bouton mode auto cliqué
            new LanceJeuAuto();                             //On lance le mode automatique.
        }

        if (evenement.getSource() == existant) {            //Bouton mode manuel cliqué
            new LanceJeu();                                 //On lance le mode manuel.
        }
    }
}
