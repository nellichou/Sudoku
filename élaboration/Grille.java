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
     * Constructeur de la classe Grille.
     */
    public Grille() {

	}

    /**
     * Initialise une grille vide.
     */
    public void initGrilleVide() {
		for ( int n=0; n<9; n++ ) {
			for( int z=0; z<9; z++) {
				this.grille[n][z] = 0;    //remplit la grille de 0
			}
		}
	}

    /**
     * Initialise une grille à partir d'un fichier.
     *
     * @param nomFichier nom du fichier
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
					val = fifi.readInt(); 			//on lit chaque ligne du fichier
					val2 = val;
					nbchiffres = 0;
	
	
					while(val2 > 0){
						nbchiffres++;
						val2 = val2/10;				//on compte le nombre de chiffres par ligne
					}
	

					/**
					 * nombre de 0 au début d'une ligne, ce sont ceux qui ne sont pas dans le fichier
					 */
					int k = 9 - nbchiffres;			
	
					for(int l = j; l < k; l++){
						grille[j][l] = 0;			//on met les 0 manquants dans les cases
					}
	
					double m=(val-val%(Math.pow(10, nbchiffres-1)))/(Math.pow(10, nbchiffres-1)); 	//on calcule le premier chiffre de la ligne après les 0
					this.grille[j][k] = (int)m;
					k = k+1; 
	
					for(i = nbchiffres; i > 1; i--){
						double c=(val%(Math.pow(10, i-1))-val%(Math.pow(10, i-2)))/(Math.pow(10, i-2)); //calcul des chiffres restants
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
     */
    public void afficheGrille() {
		JFrame fenetre = new JFrame("SUDOKU");
		JPanel pan = new JPanel();
		fenetre.setSize(800, 800);
		fenetre.setLocation(100, 100);
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridLayout gestionnaire = new GridLayout(9, 9, 3, 3);
		pan.setLayout(gestionnaire);
		pan.setBackground(Color.BLACK);
		fenetre.add(pan);

		GestionSouris souris = new GestionSouris(this, fenetre); //on ajoute un observateur à la souris

		int i,j;
		for(i = 0; i < 9; i++){
			for(j=0; j<9;j++) {   
				MyPanel panneau = new MyPanel(i,j);
				
				pan.add(panneau);
				panneau.setBackground(Color.WHITE);
				panneau.addMouseListener(souris);
				
				
				if(this.grille[i][j]==0){
					JTextArea txt = new JTextArea(1, 1);		//si la case est égale à 0, on ajoute un JTextArea vide
					panneau.add(txt);
				}else {
					int val = this.grille[i][j];
					String valeur = Integer.toString(val);
					panneau.add(new JTextArea(valeur,1, 1));	//sinon on ajoute la valeur dans le JTextArea
				}
			}
		}

		fenetre.setVisible(true);
	}

    /**
     * Mise à jour de la grille.
     *
     * @param val  la valeur à entrer
     * @param i    coordonnée ligne de la valeur
     * @param j    coordonnée colonne de la valeur
     * @param etat représente le choix du joueur : ajouter la valeur ou la supprimer 
     */
    public void majGrille(int val, int i, int j, boolean etat) {
		int x,y;
		boolean test = true;
		
		if(etat){
			for(x=0; x<9;x++){    
				if(this.grille[x][j]==val  ){         //vérification colonne
																			//ne fait rien
					test=false;
					System.out.println("valeur présente dans la colonne à la ligne :" + x);
				}
			}

			for(y=0; y<9;y++){    
				if(this.grille[i][y]==val  ){          //vérification ligne
				
					test=false;  
					System.out.println("valeur présente dans la ligne à la colonne : " + y) ;    //ne fait rien
				
				}
			}
		
		int indiceHautGauche = i - i % 3;
		int indiceColonneGauche = j - j % 3;

		for (x = indiceHautGauche; x < indiceHautGauche + 3; x++) {
			for (y = indiceColonneGauche; y < indiceColonneGauche + 3; y++) {
				if (this.grille[x][y] == val) {
					test=false;
					System.out.println("valeur déjà présente dans le carré !") ;  //vérification carré
				}
			}
		}

		if(test==true){
			this.grille[i][j] = val;	//si tous les tests sont passés on ajoute la valeur
			
		}

	}
	else {
		this.grille[i][j] = val;		//si c'est une suppression, alors on met directement le 0 dedans sans passer par les tests
	}
}


    /**
     * Sauvegarde de la grille.
     *
     * @param nomFichier nom du fichier d'enregistrement
     */
    public void saveGrille(String nomFichier) {


		try {
			
			FileOutputStream fichier = new FileOutputStream(nomFichier);
			
			

			try (DataOutputStream fifi = new DataOutputStream(fichier)) {
				String [] tab= new String[9];
				int[] tabGrille = new int[9];
				int i, detect=0;
				int valeur=0;
			
				
				int j=0;
				int nbLigne = 0;
				String newval = "";
			
				for(i=0;i<9;i++){
					for(j=0;j<9;j++){
						valeur=this.grille[i][j];	//on récupère les valeurs de la grille de jeu

						if(valeur != 0) { 
							detect = 1; 
						}

						if(detect != 0) { 
							newval = newval + String.valueOf(valeur); //on les concatène sur une ligne
						}

					}

					if(detect == 1) { 
						nbLigne++; 
					}
					
					detect = 0;
					tab[i] = newval;
					newval= "";
         
				}
			
			
				for(i=0;i<9;i++){
					tabGrille[i]=Integer.parseInt(tab[i]);	//on transforme le tableau de String en int
					
				}

				for(i=0;i<9;i++){
					fifi.writeInt(tabGrille[i]);	//on écrit chaque ligne dans le fichier
				}

			
				fifi.close();

				} catch (IOException e) {
					System.err.println("Erreur dans l'écriture des données");
			}
	 
		} catch (IOException e){
			System.err.println("Erreur dans l'ouverture du fichier");
		}
	 
	}
}
