import javax.swing.*;
import java.awt.event.*;


/**
* La classe ListenerValider est l'observateur du bouton valider de la classe MajGrilleListener.
*
* @version 1.1
* @author Benjamin Bribant, Nell Telechea
*/
public class ListenerValider implements ActionListener {
    
    /**
    *Variable qui va recevoir la grille de jeu
    */
    private Grille g = new Grille();

    /**
    *Variable qui va recevoir la nouvelle valeur désirée de la case
    */
    private JTextArea valeur;

    /**
    *Coordonnée ligne de la valeur
    */
    private int i;

    /**
    *Coordonnée colonne de la valeur
    */
    private int j;

    /**
    *Variable qui va recevoir le bouton "valider"
    */
    private JButton valider;

    /**
    *Ancienne fenêtre
    */
    private JFrame oldFenetre;

    /**
    *Ancienne fenêtre
    */
    private JFrame input;


    /**
     * Constructeur de la classe ListenerValider
     *
     * @param valider Bouton valider
     * @param g       La grille
     * @param valeur  La valeur
     * @param i       Coordonnée ligne de la valeur
     * @param j       Coordonnée colonne de la valeur
     * @param fenetre Ancienne fenêtre
     * @param input   Ancienne fenêtre
     */
    public ListenerValider(JButton valider, Grille g, JTextArea valeur, int i, int j, JFrame fenetre, JFrame input) {
        this.valider = valider;
        this.g = g;
        this.valeur = valeur;
        this.i = i;
        this.j = j;
        this.oldFenetre = fenetre;
        this.input = input;
    }

    public void actionPerformed(ActionEvent evenement) {
        if (evenement.getSource() == valider) {
            boolean etat=true;
            int value = Integer.valueOf(this.valeur.getText());
            
            
            
            if(value <1 || value>9 ) {              //On teste si la valeur est entre 1 et 9.
    
                this.g.afficheGrille(false);   //On réaffiche la grille sans modifications.
            }

            else {
                this.g.majGrille(value, this.i, this.j,etat);        //On met la grille à jour.    
                this.oldFenetre.setVisible(false);                 //On ferme les fenêtres dont on a plus besoin.
                this.input.setVisible(false);
                this.g.afficheGrille(false);                    //On affiche la grille.
                
            }          
        }

    }

}