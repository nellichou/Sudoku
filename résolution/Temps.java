import javax.swing.*;
import java.awt.*;

/**
 * La classe Temps permet d'afficher le temps qu'a prit la résolution automatique de la grille
 * @version 1.1
 * @author Benjamin Bribant, Nell Telechea
 */
public class Temps {

    /**
    *La date de début
    */
    private long debut;

    /**
    *La date de fin
    */
    private long fin;

    /**
    *Le temps pris
    */
    public long temps;

    /**
    *Zone de texte pour afficher le message
    */
    private JTextArea msg;

    /**
    *La fenêtre pour afficher le message
    */
    private JFrame fenetre;

    /**
    *Panneau pour afficher le message
    */
    private JPanel pan;

    /**
    * Méthode pour initialiser le temps du début de la partie
    *
    * @param tps Le temps au début
    */
    public void debut(long tps){
        this.debut=tps;
    }

    /**
    * Méthode pour initialiser le temps de la fin de la partie
    *
    * @param fin Le temps à la fin
    */
    public void fin(long fin){
        this.fin=fin;
    }

    /**
    *Méthode pour calculer le temps de résolution
    */
    private long temps(){
        temps=this.fin-this.debut;
        return temps;
    }

    /**
    *Méthode pour afficher le temps.
    */
    public void affiche(){
        
     
		this.fenetre = new JFrame("SUDOKU");
        this.pan= new JPanel();
        FlowLayout gestionnaire = new FlowLayout(FlowLayout.CENTER);
        this.fenetre.setLayout(gestionnaire);
    
    	this.fenetre.setSize(600, 100);
    	this.fenetre.setLocation(800, 10);
    	this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.fenetre.add(this.pan);
        
        pan.setBackground(Color.WHITE);
        this.msg = new JTextArea("Le sudoku a été résolu en " + temps()/1e6 + " milisecondes :)");
        Font font = new Font("Verdana", Font.BOLD, 20);
        msg.setFont(font);
        
        this.pan.add(this.msg);
         
		this.fenetre.setVisible(true);  
    } 
}