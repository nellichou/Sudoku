import javax.swing.*;
import java.awt.event.*;
import java.io.File;

/**
 * La classe ListenerButton est l'observateur des boutons et de la fenêtre de ChoixData.
 * @version 1.1
 * @author Benjamin Bribant, Nell Telechea
 */
public class ListenerButton implements ActionListener,WindowListener {
    /**
     * variable qui va recevoir la grille de jeu
     */
    private Grille g = new Grille();
    /**
     * variable qui va recevoir le bouton "grille vide"
     */
    private JButton vide;
    /**
     * variable qui va recevoir le bouton "grille existante"
     */
    private JButton existant;
    /**
     * variable qui va recevoir la fenêtre précédente
     */
    private JFrame fenetre;

    /**
     * Constructeur de la classe ListenerButton.
     *
     * @param vide     the vide
     * @param existant the existant
     * @param fenetre  the fenetre
     */
    public ListenerButton(JButton vide, JButton existant,JFrame fenetre) {
        this.vide = vide;
        this.existant = existant;
        this.fenetre = fenetre;

    }

    public void actionPerformed(ActionEvent evenement) {
        if (evenement.getSource() == vide) {
            
            this.g.initGrilleVide();            //initialise une grille vide
            this.g.afficheGrille();             //puis l'affiche
        }

        if (evenement.getSource() == existant) {

            JFrame fenetre = new JFrame();
            fenetre.setLocation(100, 100);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setVisible(false);

            JFileChooser select = new JFileChooser(".");
            select.setMultiSelectionEnabled(false);
            int res = select.showDialog(fenetre, "Ouvrir une grille");          //on ouvre une fenêtre qui permet de choisir un fichier
            if(res == JFileChooser.APPROVE_OPTION) {
            File fifi = select.getSelectedFile();
            String nomFichier = fifi.getName();
            this.g.initGrilleFichier(nomFichier);       //on initialise la grille avec 
            this.g.afficheGrille();                     //puis on l'affiche

            }
        }
    }


    public void windowActivated(WindowEvent evenement){}
         
    public void windowClosed(WindowEvent evenement){}
             
    public void windowClosing(WindowEvent evenement){           //quand on ferme la fenêtre, on ouvre une fenêtre qui permet de choisir une fichier
        if (evenement.getSource() == fenetre){

            JFrame fenetre = new JFrame();
            
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setDialogTitle("Nom du fichier à sauvegarder");   
            
            int res = fileChooser.showSaveDialog(fenetre);
            
            if (res == JFileChooser.APPROVE_OPTION) {
                File nomFichier = fileChooser.getSelectedFile();
                this.g.saveGrille(nomFichier.getAbsolutePath());        //sauvegarde de la grille

            }
        }
    }
            // avant fermeture
    public void windowDeactivated(WindowEvent evenement){}
        
    public void windowDeiconified(WindowEvent evenement){}
        
    public void windowIconified(WindowEvent evenement){}
          
    public void windowOpened(WindowEvent evenement){}
            

}
