import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChoixData {

    private JButton supprimer;
    private JButton ajouter;
    private JFrame fenetre;
    private FlowLayout gestionnaire;
    private MajGrilleListener listener;
    private JFrame oldFenetre;


    public ChoixData(Grille g, int i, int j, JFrame fenetre) {
        
        // g.afficheGrilleTxt();
        this.oldFenetre = fenetre;
		this.fenetre = new JFrame();
        this.gestionnaire = new FlowLayout(FlowLayout.CENTER);
        this.fenetre.setLayout(gestionnaire);
    
    	this.fenetre.setSize(200, 200);
    	this.fenetre.setLocation(900, 400);
    	this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

        this.supprimer = new JButton("Supprimer le nombre");
        this.ajouter = new JButton("Modifier le nombre");
        this.fenetre.add(this.ajouter);
        this.fenetre.add(this.supprimer);
        this.fenetre.setVisible(true);
        this.listener = new MajGrilleListener(this.ajouter, this.supprimer,g,i,j, this.oldFenetre, this.fenetre);
        this.ajouter.addActionListener(listener);
        this.supprimer.addActionListener(listener);

    }

}