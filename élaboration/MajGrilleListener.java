import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MajGrilleListener implements ActionListener {
    private JButton ajouter;
    private JButton supprimer;
    private JButton valider;
    private JTextArea nb;
    private JFrame fenetre;
    private GridLayout gestionnaire;
    private Grille g;
    private int x,y;
    private JFrame oldFenetre;
    private JFrame selector;
    

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
            // EntreeData entree = new EntreeData();
            
            this.fenetre = new JFrame();
            this.gestionnaire = new GridLayout(2,1);
            this.fenetre.setLayout(this.gestionnaire);
        
            this.fenetre.setSize(200, 100);
            this.fenetre.setLocation(900, 400);
            this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            this.nb = new JTextArea("0");
            this.valider = new JButton("Valider");
            
            this.fenetre.add(this.nb);
            this.fenetre.add(this.valider);
    
            this.fenetre.setVisible(true);
            this.selector.setVisible(false);

            ListenerValider validation = new ListenerValider(this.valider,this.g, this.nb, this.x, this.y, this.oldFenetre, this.fenetre);
            this.valider.addActionListener(validation);
            
        }

        if (evenement.getSource() == supprimer) {
            boolean etat =false;
            this.selector.setVisible(false);
            this.oldFenetre.setVisible(false);
            g.majGrille(0, x, y, etat);
            g.afficheGrille();
        }
    }
}