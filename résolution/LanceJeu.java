import javax.swing.*;
import java.awt.*;


/**
* La classe LanceJeu permet d'initialiser le jeu en mode manuel.
*
* @version 1.1
* @author Benjamin Bribant, Nell Telechea
*/
public class LanceJeu extends JPanel {

    /**
    *Le bouton mode manuel.
    */
    private JButton existant;

    /**
    *La fenêtre de jeu.
    */
    private JFrame fenetre;

    /**
    *Le constructeur de LanceJeu.
    */
    public LanceJeu() {
        
        super();
		this.fenetre = new JFrame("SUDOKU");
        FlowLayout gestionnaire = new FlowLayout(FlowLayout.CENTER);
        this.fenetre.setLayout(gestionnaire);
    
    	this.fenetre.setSize(500, 500);
    	this.fenetre.setLocation(100, 100);
    	this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

        this.existant = new JButton("Charger une grille");
        this.fenetre.add(this.existant);
        
        ListenerButton listener = new ListenerButton(this.existant);
        this.existant.addActionListener(listener);
		this.fenetre.setVisible(true);
    }
}