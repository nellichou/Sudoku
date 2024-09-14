import javax.swing.*;

/**
 * La classe MyPanel est une classe qui hérite de JPanel en lui rajoutant des coordonnées lors de sa création.
 * @version 1.1
 * @author Benjamin Bribant, Nell Telechea
 */
public class MyPanel extends JPanel {


    /**
     * coordonnée ligne du panneau
     */
    private int i; /**
     * coordonnée colonne du panneau
     */
    private int j;


    /**
     * Constructeur de la classe MyPanel.
     *
     * @param i coordonnée ligne du panneau
     * @param j coordonnée colonne du panneau
     */
    public MyPanel(int i,int j){
        this.i=i;
        this.j=j;
        JPanel panneau = new JPanel();

    }


    /**
     * renvoie la coordonnée ligne du panneau.
     *
     * @return i
     */
    public int getI(){
        return this.i;
    }

    /**
     * renvoie la coordonnée colonne du panneau
     *
     * @return j
     */
    public int getJ(){
        return this.j;
    }
}