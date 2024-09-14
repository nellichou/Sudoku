import javax.swing.*;
import java.awt.event.*;
import java.io.File;

/**
 * The type Listener button auto.
 */
public class ListenerButtonAuto implements ActionListener/*,WindowListener*/ {
    
    private Grille g = new Grille();
    private Temps t = new Temps();
    //private JButton vide;
    private JButton existant;
    private boolean auto;
   // private JFrame fenetre;

    /**
     * Instantiates a new Listener button auto.
     *
     * @param existant the existant
     */
    public ListenerButtonAuto(/*JButton vide, */JButton existant/*,JFrame fenetre*/) {
       // this.vide = vide;
        this.existant = existant;
        //this.fenetre = fenetre;

    }

    public void actionPerformed(ActionEvent evenement) {
      /*  if (evenement.getSource() == vide) {
            
            this.g.initGrilleVide();
            this.g.afficheGrille();
        }*/

        if (evenement.getSource() == existant) {

            JFrame fenetre = new JFrame();
            fenetre.setSize(200, 200);
            fenetre.setLocation(100, 100);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setVisible(false);

            JFileChooser select = new JFileChooser(".");
            select.setMultiSelectionEnabled(false);
            int res = select.showDialog(fenetre, "Ouvrir une grille");
            if(res == JFileChooser.APPROVE_OPTION) {
                File fifi = select.getSelectedFile();
                String nomFichier = fifi.getName();
                this.g.initGrilleFichier(nomFichier);
                
                this.t.debut(System.nanoTime());
                if (this.g.solveSudoku( 0, 0)){
                    this.auto=true;
                    this.g.afficheGrille(auto);
                    this.t.fin(System.nanoTime());
                    this.t.affiche();
                }
                else{
			        System.out.println("No Solution exists");
	            }
            }
        }
    }
}
