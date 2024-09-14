import javax.swing.*;
import java.awt.*;

/**
* La classe ChoixData ouvre une fenêtre qui permet de choisir si on veut modifier ou supprimer la valeur d'une case.
* @version 1.1
* @author Benjamin Bribant, Nell Telechea
*/

public class ChoixData {

    /**
    *Bouton supprimer
    */
    private JButton supprimer;

    /**
    *Bouton ajouter/modifier
    */
    private JButton ajouter;

    /**
    *Fenêtre
    */
    private JFrame fenetre;

    /**
    *Gestionnaire de mise en page de la fenêtre
    */
    private FlowLayout gestionnaire;

    /**
    *Observateur des boutons de la fenêtre
    */
    private MajGrilleListener listener;

    /**
    *Variable qui va récupérer la fenêtre précédente
    */
    private JFrame oldFenetre;


    /**
    * Constructeur de la classe ChoixData qui ouvre la fenêtre.
    *
    * @param g       La grille de jeu
    * @param i       Coordonnée ligne de la valeur
    * @param j       Coordonnée colonne de la valeur
    * @param fenetre La fenêtre précédente
    */
    public ChoixData(Grille g, int i, int j, JFrame fenetre) {
        
        this.oldFenetre = fenetre;
		this.fenetre = new JFrame();
        this.gestionnaire = new FlowLayout(FlowLayout.CENTER);
        this.fenetre.setLayout(gestionnaire);
    
    	this.fenetre.setSize(200, 200);
    	this.fenetre.setLocation(900, 400);
    	this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

        this.supprimer = new JButton("Supprimer le nombre");        //Création du bouton supprimer.
        this.ajouter = new JButton("Modifier le nombre");           //Création du bouton modifier.
        this.fenetre.add(this.ajouter);
        this.fenetre.add(this.supprimer);
        this.fenetre.setVisible(true);
        this.listener = new MajGrilleListener(this.ajouter, this.supprimer,g,i,j, this.oldFenetre, this.fenetre);       //Ajout de l'observateur des boutons et de la fenêtre.
        this.ajouter.addActionListener(listener);
        this.supprimer.addActionListener(listener);

    }

}