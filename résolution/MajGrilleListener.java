import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
* La classe MajGrilleListener est l'observateur des boutons modifier et supprimer de la classe ChoixData.
* @version 1.1
* @author Benjamin Bribant, Nell Telechea
*/
public class MajGrilleListener implements ActionListener {

    /**
    *Variable qui va recevoir le bouton valider
    */
    private JButton ajouter;

    /**
    *Variable qui va recevoir le bouton modifier
    */
    private JButton supprimer;

    /**
    *Bouton de validation de la valeur entrée
    */
    private JButton valider;

    /**
    *Zone de texte de la valeur à ajouter
    */
    private JTextArea nb;

    /**
    *Fenêtre
    */
    private JFrame fenetre;

    /**
    *Gestionnaire de mise en page de la fenêtre
    */
    private GridLayout gestionnaire;

    /**
    *Variable qui va recevoir la grille de jeu
    */
    private Grille g;

    /**
    *Coordonnée ligne de la valeur
    */
    private int x;

    /**
    *Coordonnée colonne de la valeur
    */
    private int y;

    /**
    *Ancienne fenêtre
    */
    private JFrame oldFenetre;

    /**
    *Ancienne fenêtre
    */
    private JFrame selector;


    /**
     * Constructeur de la classe MajGrilleListener.
     *
     * @param ajouter   Bouton ajouter
     * @param supprimer Bouton supprimer
     * @param g         Grille de jeu
     * @param i         Coordonnée ligne de la valeur
     * @param j         Coordonnée colonne de la valeur
     * @param fenetre   Ancienne fenêtre
     * @param selector  Fenêtre précédente
     */
    public MajGrilleListener(JButton ajouter, JButton supprimer,Grille g, int i, int j, JFrame fenetre, JFrame selector) {
        this.ajouter = ajouter;
        this.supprimer = supprimer;
        this.g=g;
        this.x=i;
        this.y=j;
        this.oldFenetre = fenetre;
        this.selector = selector;
    }

    public void actionPerformed(ActionEvent evenement) {

        if (evenement.getSource() == ajouter) {
            
            this.fenetre = new JFrame();
            this.gestionnaire = new GridLayout(2,1);
            this.fenetre.setLayout(this.gestionnaire);
        
            this.fenetre.setSize(200, 100);
            this.fenetre.setLocation(900, 400);
            this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            this.nb = new JTextArea("0");                   //Création de la zone de texte.
            this.valider = new JButton("Valider");          //Création du bouton de validation.
            
            this.fenetre.add(this.nb);
            this.fenetre.add(this.valider);
    
            this.fenetre.setVisible(true);
            this.selector.setVisible(false);

            ListenerValider validation = new ListenerValider(this.valider,this.g, this.nb, this.x, this.y, this.oldFenetre, this.fenetre);      //Observateur des boutons.
            this.valider.addActionListener(validation);
            
        }

        if (evenement.getSource() == supprimer) {
            boolean etat =false;
            boolean auto= false;
            this.selector.setVisible(false);        //On ferme les fenêtres dont on a plus besoin.
            this.oldFenetre.setVisible(false);      
            g.majGrille(0, x, y, etat);           //On met à jour la grille.
            g.afficheGrille(auto);                    //On affiche la grille.
        }
    }
}