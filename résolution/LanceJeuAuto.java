import javax.swing.*;
import java.awt.*;


/**
 * The type Lance jeu auto.
 */
public class LanceJeuAuto extends JPanel {

   // private JButton vide;
    private JButton existant;
    private JFrame fenetre;
    // private Dimension dim = new Dimension(200, 200);

    /**
     * Instantiates a new Lance jeu auto.
     */
    public LanceJeuAuto() {
        
        super();
		this.fenetre = new JFrame("SUDOKU");
        FlowLayout gestionnaire = new FlowLayout(FlowLayout.CENTER);
        this.fenetre.setLayout(gestionnaire);
    
    	this.fenetre.setSize(500, 500);
    	this.fenetre.setLocation(100, 100);
    	this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

        //this.vide = new JButton("Charger grille vide");
        this.existant = new JButton("Charger une grille");
        //this.fenetre.add(this.vide);
        this.fenetre.add(this.existant);
        
        ListenerButtonAuto listener = new ListenerButtonAuto(this.existant);
        //this.fenetre.addWindowListener(listener);
       // this.vide.addActionListener(listener);
        this.existant.addActionListener(listener);
		this.fenetre.setVisible(true);
    }
}