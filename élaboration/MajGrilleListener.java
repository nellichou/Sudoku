import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * La classe MajGrilleListener est l'observateur des boutons modifier et supprimer de la classe ChoixData .
 * @version 1.1
 * @author Benjamin Bribant, Nell Telechea
 */
public class MajGrilleListener implements ActionListener {
    /**
     * variable qui va recevoir le bouton valider
     */
    private JButton ajouter;
    /**
     * variable qui va recevoir le bouton modifier
     */
    private JButton supprimer;
    /**
     * bouton de validation de la valeur entrée
     */
    private JButton valider;
    /**
     * zone de texte de la valeur à ajouter
     */
    private JTextArea nb;
    /**
     * fenêtre
     */
    private JFrame fenetre;
    /**
     * gestionnaire de mise en page de la fenêtre
     */
    private GridLayout gestionnaire;
    /**
     * variable qui va recevoir la grille de jeu
     */
    private Grille g;
    /**
     * coordonnée ligne de la valeur
     */
    private int x;
    /**
     * coordonnée colonne de la valeur
     */
    private int y;
    /**
     * ancienne fenêtre
     */
    private JFrame oldFenetre;
    /**
     * ancienne fenêtre
     */
    private JFrame selector;


    /**
     * Constructeur de la classe MajGrilleListener.
     *
     * @param ajouter   bouton ajouter
     * @param supprimer bouton supprimer
     * @param g         grille de jeu
     * @param i         coordonnée ligne de la valeur
     * @param j         coordonnée colonne de la valeur
     * @param fenetre   ancienne fenetre
     * @param selector  fenêtre précédente
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
            
            this.nb = new JTextArea("0");           //création de la zone de texte
            this.valider = new JButton("Valider");  //création du boutond de validation
            
            this.fenetre.add(this.nb);
            this.fenetre.add(this.valider);
    
            this.fenetre.setVisible(true);
            this.selector.setVisible(false);

            ListenerValider validation = new ListenerValider(this.valider,this.g, this.nb, this.x, this.y, this.oldFenetre, this.fenetre);  //observateur des boutons
            this.valider.addActionListener(validation);
            
        }

        if (evenement.getSource() == supprimer) {
            boolean etat =false;
            this.selector.setVisible(false);        //on ferme les fenêtres dont on a plus besoin
            this.oldFenetre.setVisible(false);      
            g.majGrille(0, x, y, etat);             //on met à jout la grille
            g.afficheGrille();                          //on affiche la grille
        }
    }
}