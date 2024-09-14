import javax.swing.*;
import java.awt.event.*;

/**
 * La classe ListenerValider est l'observateur du bouton valider de la classe MajGrilleListener.
 * @version 1.1
 * @author Benjamin Bribant, Nell Telechea
 * 
 */
public class ListenerValider implements ActionListener {
    /**
     * variable qui va recevoir la grille de jeu
     */
    private Grille g = new Grille();
    /**
     * variable qui va recevoir la nouvelle valeur désirée de la case
     */
    private JTextArea valeur;
    /**
     * coordonnée ligne de la valeur
     */
    private int i;
    /**
     * coordonnée colonne de la valeur
     */
    private int j;
    /**
     * variable qui va recevoir le bouton "valider"
     */
    private JButton valider;
    /**
     * ancienne fenêtre
     */
    private JFrame oldFenetre;
    /**
     * ancienne fenêtre
     */
    private JFrame input;


    /**
     * Constructeur de la classe ListenerValider.
     *
     * @param valider bouton valider
     * @param g       la grille
     * @param valeur  la valeur
     * @param i       coordonnée ligne de la valeur
     * @param j       coordonnée colonne de la valeur
     * @param fenetre ancienne fenetre
     * @param input   ancienne fenetre
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
            
            
            
            if(value <1 || value>9 ) {              // on teste si c entre 1 et 9
    
                this.g.afficheGrille();                 //on réaffiche la grille sans modifications 
            }

            else {
                this.g.majGrille(value, this.i, this.j,etat);         //on met la grille à jour   
                this.oldFenetre.setVisible(false);                  //on ferme les fenêtres dont on a plus besoin
                this.input.setVisible(false);
                this.g.afficheGrille();                                 //on affiche la grille
                
            }

        }

    }

}