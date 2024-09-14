import javax.swing.*;
import java.awt.*;


/**
 * La classe Victoire permet d'afficher un message de félicitations quand le joueur a réussi a compléter la grille
 * @version 1.1
 * @author Benjamin Bribant, Nell Telechea
 */
public class Victoire extends JPanel {

    /**
    *Zone texte pour afficher le message
    */
    private JTextArea msg;

    /**
    *Fenêtre pour afficher le message
    */
    private JFrame fenetre;

    /**
    *Panneau pour afficher le message
    */
    private JPanel pan;

    /**
    *Constructeur de la classe Victoire
    */
    public Victoire() {
        
        super();
		this.fenetre = new JFrame("SUDOKU");
        this.pan= new JPanel();
        FlowLayout gestionnaire = new FlowLayout(FlowLayout.CENTER);
        this.fenetre.setLayout(gestionnaire);
    
    	this.fenetre.setSize(500, 100);
    	this.fenetre.setLocation(800, 10);
    	this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fenetre.add(this.pan);
        
        pan.setBackground(Color.WHITE);
        this.msg = new JTextArea("Bravo vous avez fini le sudoku :)");
        Font font = new Font("Verdana", Font.BOLD, 20);
        msg.setFont(font);
        
        this.pan.add(this.msg);
        

        
		this.fenetre.setVisible(true);
    }
}