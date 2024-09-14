import javax.swing.*;
import java.awt.event.*;
import java.io.File;

/**
 * The type Listener button.
 */
public class ListenerButton implements ActionListener/*,WindowListener*/ {
    
    private Grille g = new Grille();
    //private JButton vide;
    private JButton existant;
   // private JFrame fenetre;

    /**
     * Instantiates a new Listener button.
     *
     * @param existant the existant
     */
    public ListenerButton(/*JButton vide, */JButton existant/*,JFrame fenetre*/) {
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
            this.g.afficheGrille(false);

            }
        }
    }


   /* public void windowActivated(WindowEvent evenement){}
          // premier plan
    public void windowClosed(WindowEvent evenement){}
             // après fermeture
    public void windowClosing(WindowEvent evenement){
        if (evenement.getSource() == fenetre){
            // JFrame fenetre = new JFrame("Enregistrement de la grille");
            // fenetre.setSize(200, 200);
            // fenetre.setLocation(100, 100);
            // fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // fenetre.setVisible(false);

            // JFileChooser select = new JFileChooser(".");
            // select.setMultiSelectionEnabled(false);
            // int res = select.showDialog(fenetre, "sauvegarder");
            
            // if(res == JFileChooser.SAVE_DIALOG) {
            //     String nomFichier = select.getSelectedFile().getName();
            //     this.g.saveGrille(nomFichier);
            // }

            // parent component of the dialog
            JFrame fenetre = new JFrame();
            
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setDialogTitle("Nom du fichier à sauvegarder");   
            
            int res = fileChooser.showSaveDialog(fenetre);
            
            if (res == JFileChooser.APPROVE_OPTION) {
                File nomFichier = fileChooser.getSelectedFile();
                // System.out.println("Save as file: " + nomFichier.getAbsolutePath());
                this.g.saveGrille(nomFichier.getAbsolutePath());

            }
        }
    }
            // avant fermeture
    public void windowDeactivated(WindowEvent evenement){}
        // arrière-plan
    public void windowDeiconified(WindowEvent evenement){}
        // restauration
    public void windowIconified(WindowEvent evenement){}
          // minimisation
    public void windowOpened(WindowEvent evenement){}
             // après ouverture
             */

}
