import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;

/**
 * La classe LancePartie va ouvrir une fenêtre qui donne le choix entre une grille initialisée vide ou remplie à partir d'un fichier.
 * @version 1.1
 * @author Benjamin Bribant, Nell Telechea
 */
public class LancePartie extends JPanel {
/**
 * bouton pour choisir une grille vide
 */
    private JButton vide;
    /**
     * bouton pour choisir une grille pré-remplie
     */
    private JButton existant;
    /**
     * fenêtre de choix
     */
    private JFrame fenetre;
  

    /**
     * Constructeur de la classe LancePartie qui va ouvrir la fenêtre avec les boutons.
     */
    public LancePartie() {
        
        super();
		this.fenetre = new JFrame("SUDOKU");
        FlowLayout gestionnaire = new FlowLayout(FlowLayout.CENTER);
        this.fenetre.setLayout(gestionnaire);
    
    	this.fenetre.setSize(500, 500);
    	this.fenetre.setLocation(100, 100);
    	this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        this.vide = new JButton("Charger grille vide");     //création du bouton grille vide
        this.existant = new JButton("Charger grille existante");    //création du bouton grille pré-remplie
        this.fenetre.add(this.vide);
        this.fenetre.add(this.existant);
        
        ListenerButton listener = new ListenerButton(this.vide, this.existant,this.fenetre);    //observateur des boutons et de la fenêtre
        this.fenetre.addWindowListener(listener);
        this.vide.addActionListener(listener);
        this.existant.addActionListener(listener);
		this.fenetre.setVisible(true);
    }
}