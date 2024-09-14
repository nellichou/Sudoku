import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class ListenerValider implements ActionListener {
    
    private Grille g = new Grille();
    private JTextArea valeur;
    private int i,j;
    private JButton valider;
    private JFrame oldFenetre, input;


    public ListenerValider(JButton valider, Grille g, JTextArea valeur, int i, int j, JFrame fenetre, JFrame input) {
        this.valider = valider;
        this.g = g;
        this.valeur = valeur;
        this.i = i;
        this.j = j;
        this.oldFenetre = fenetre;
        this.input = input;
    }

    public void actionPerformed(ActionEvent evenement) {
        if (evenement.getSource() == valider) {
            boolean etat=true;
            int value = Integer.valueOf(this.valeur.getText());
            
            
            
            if(value <1 || value>9 ) {              // on teste si c entre 1 et 9
    
                this.g.afficheGrille();                 
            }

            else {
                this.g.majGrille(value, this.i, this.j,etat);            
                this.oldFenetre.setVisible(false);
                this.input.setVisible(false);
                this.g.afficheGrille(); 
                
            }
    
            
    
            
        }

    }

}