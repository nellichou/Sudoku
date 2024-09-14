import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * La classe Grille est utilisée pour manipuler la grille de jeu.
 * 
 * @version 1.1
 * @author Benjamin Bribant, Nell Telechea
 */
public class Grille {

	/**
	 * Grille de jeu.
	 */
	private int[][] grille = new int[9][9];

    /**
     *Constructeur de la classe Grille.
     */
    public Grille() {

	}


    /**
    * Initialise une grille avec un fichier.
    *
    * @param nomFichier Le nom du fichier
    */
    public void initGrilleFichier(String nomFichier) {
		
		try { FileInputStream fichier = new FileInputStream(nomFichier);
			try (DataInputStream fifi = new DataInputStream(fichier)) {
				int y, i;
				int hauteur = 9;
				int nbchiffres = 0;
	 
				int val, val2;
				int j=0;
	
				for (y = 0; y < hauteur; y++) {
					val = fifi.readInt();			//On lit chaque ligne du fichier.
					val2 = val;
					nbchiffres = 0;
	
	
					while(val2 > 0){
						nbchiffres++;
						val2 = val2/10;				//On compte le nombre de chiffres par ligne.
					}
	
	
					/**
					*Nombre de 0 au début d'une ligne, ce sont ceux qui ne sont pas dans le fichier.
					*/
					int k = 9 - nbchiffres;
	
					for(int l = j; l < k; l++){
						grille[j][l] = 0;			//On met les 0 manquants dans les cases.
					}
	
					double m=(val-val%(Math.pow(10, nbchiffres-1)))/(Math.pow(10, nbchiffres-1));			//On calcule le premier chiffre de la ligne après les 0.
					this.grille[j][k] = (int)m;
					k = k+1; 
	
					for(i = nbchiffres; i > 1; i--){
						double c=(val%(Math.pow(10, i-1))-val%(Math.pow(10, i-2)))/(Math.pow(10, i-2));	//Calcul des chiffres restants.
						this.grille[j][k] = (int)c;
						k++;
					}
						
					j++;               
				}
	
				fifi.close();
				
			} catch (IOException e) {
				System.err.println("Erreur dans le chargement des data");
			}
		
		} catch (FileNotFoundException e) {
			System.err.println("Erreur d'ouverture du fichier");   
		}
		
	}


    /**
    * Affichage graphique de la grille.
    *
    * @param auto Si faux, on est en mode manuel, si vrai, on est en mode auto.
    */
    public void afficheGrille(boolean auto) {
		JFrame fenetre = new JFrame("SUDOKU");
		JPanel pan = new JPanel();
		fenetre.setSize(800, 800);
		fenetre.setLocation(500, 200);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridLayout gestionnaire = new GridLayout(9, 9, 3, 3);
		pan.setLayout(gestionnaire);
		pan.setBackground(Color.BLACK);
		fenetre.add(pan);

		if(auto==false){	
			GestionSouris souris = new GestionSouris(this, fenetre);		//On ajoute un observateur à la souris.
		
			int i,j;
			for(i = 0; i < 9; i++){
				for(j=0; j<9;j++) {   
					MyPanel panneau = new MyPanel(i,j);

					pan.add(panneau);
					panneau.setBackground(Color.WHITE);
					panneau.addMouseListener(souris);


					if(this.grille[i][j]==0){
						JTextArea txt = new JTextArea(1, 1);	//Si la case est égale à 0, on ajoute un JTextArea vide.
						panneau.add(txt);
					}else {
						int val = this.grille[i][j];
						String valeur = Integer.toString(val);
						panneau.add(new JTextArea(valeur,1, 1));	//Sinon, on ajoute la valeur dans le JTextArea.
					}
				}
			}
		
		}else{				//Le mode automatique.
			int i,j;
			for(i = 0; i < 9; i++){
				for(j=0; j<9;j++) {   
					MyPanel panneau = new MyPanel(i,j);

					pan.add(panneau);
					panneau.setBackground(Color.WHITE);

					if(this.grille[i][j]==0){
						JTextArea txt = new JTextArea(1, 1);
						panneau.add(txt);
					}else {
						int val = this.grille[i][j];
						String valeur = Integer.toString(val);
						panneau.add(new JTextArea(valeur,1, 1));
					}
				}
			}
		}	

		fenetre.setVisible(true);
	}

    /**
     * Mise à jour de la grille
     *
     * @param val  La valeur à entrer
     * @param i    Coordonnéeligne de la valeur
     * @param j    Coordonnée colonne de la valeur
     * @param etat Représente le choix du joueur : ajouter la valeur ou la supprimer
     */
    public void majGrille(int val, int i, int j, boolean etat) {
		int x,y;
		boolean test = true;
		boolean fin = true;
		
		if(etat){
			for(x=0; x<9;x++){    
				if(this.grille[x][j]==val  ){         //Vérification de la colonne.
																			//Ne fait rien.
					test=false;

				}
			}

			for(y=0; y<9;y++){    
				if(this.grille[i][y]==val  ){          //Vérification de la ligne.
																			//Ne fait rien.
					test=false;  			
				}
			}
		
		int indiceHautGauche = i - i % 3;
		int indiceColonneGauche = j - j % 3;

		for (x = indiceHautGauche; x < indiceHautGauche + 3; x++) {
			for (y = indiceColonneGauche; y < indiceColonneGauche + 3; y++) {
				if (this.grille[x][y] == val) {										//Vérification du carré.
					test=false;
					System.out.println("valeur déjà présente dans le carré !") ;
				}
			}
		}

		if(test==true){
			this.grille[i][j] = val;		//Si tous les tests sont passés, on ajoute la valeur.
			
		}

	}
	else {
		this.grille[i][j] = val;			//Si c'est une suppression, alors on met directement le 0 sans passer par les tests.
	}

	for(i=0; i<9; i++){
		for(j=0; j<9; j++) {
			if(this.grille[i][j]==0){
				fin = false;
			}
		}
	}

	if(fin==true){
		new Victoire();
	}

	
}


    /**
     * Dimension de la matrice
     */
    static int N = 9;

    /**
     * Méthode de résolution
     *
     * @param ligne La ligne
     * @param colonne La colonne
     * @return Booléen
     */

	public boolean solveSudoku(int ligne, int colonne) {

		if (ligne == N - 1 && colonne == N){
			return true;
		}

		if (colonne == N) {
			ligne++;
			colonne = 0;
		}

		if (this.grille[ligne][colonne] != 0){
			return solveSudoku(ligne, colonne + 1);
		}

		for (int num = 1; num < 10; num++) {

			if (verif(ligne, colonne, num)) {

				this.grille[ligne][colonne] = num;

				if (solveSudoku(ligne, colonne + 1)){
					return true;
				}	
			}
			this.grille[ligne][colonne] = 0;
		}
		return false;
	}


    /**
     *Méthode de vérification
     *
     * @param ligne La ligne
     * @param colonne La colonne
     * @param num La valeur
     * @return Le booléen
     */

	public boolean verif(int ligne, int colonne ,int num) {

		for (int x = 0; x <= 8; x++) {
			if (this.grille[ligne][x] == num)
				return false;
		}

		for (int x = 0; x <= 8; x++) {
			if (this.grille[x][colonne] == num)
				return false;
		}

		int debutLigne = ligne - ligne % 3, debutCol = colonne - colonne % 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++){
				if (this.grille[i + debutLigne][j + debutCol] == num){
					return false;
				}
			}
		}

		return true;
		
	}


}
