import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;

public class LancePartie extends JPanel {

    private JButton vide;
    private JButton existant;
    private JFrame fenetre;
    // private Dimension dim = new Dimension(200, 200);

    public LancePartie() {
        
        super();
		this.fenetre = new JFrame("SUDOKU");
        FlowLayout gestionnaire = new FlowLayout(FlowLayout.CENTER);
        this.fenetre.setLayout(gestionnaire);
    
    	this.fenetre.setSize(500, 500);
    	this.fenetre.setLocation(100, 100);
    	this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        this.vide = new JButton("Charger grille vide");
        this.existant = new JButton("Charger grille existante");
        this.fenetre.add(this.vide);
        this.fenetre.add(this.existant);
        
        ListenerButton listener = new ListenerButton(this.vide, this.existant,this.fenetre);
        this.fenetre.addWindowListener(listener);
        this.vide.addActionListener(listener);
        this.existant.addActionListener(listener);
		this.fenetre.setVisible(true);
    }
}