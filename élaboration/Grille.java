import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Grille {

	private int[][] grille = new int[9][9];

	public Grille() {

	}

	public void initGrilleVide() {
		for ( int n=0; n<9; n++ ) {
			for( int z=0; z<9; z++) {
				this.grille[n][z] = 0;
			}
		}
	}

	public void initGrilleFichier(String nomFichier) {
		
		try { FileInputStream fichier = new FileInputStream(nomFichier);
			try (DataInputStream fifi = new DataInputStream(fichier)) {
				int y, i;
				int hauteur = 9;
				int nbchiffres = 0;
	 
				int val, val2;
				int j=0;
	
				for (y = 0; y < hauteur; y++) {
					val = fifi.readInt();
					val2 = val;
					nbchiffres = 0;
	
					// System.out.println(val);
	
					while(val2 > 0){
						nbchiffres++;
						val2 = val2/10;
					}
	
					// System.out.println(nbchiffres);
	
					int k = 9 - nbchiffres;
	
					for(int l = j; l < k; l++){
						grille[j][l] = 0;
					}
	
					double m=(val-val%(Math.pow(10, nbchiffres-1)))/(Math.pow(10, nbchiffres-1));
					this.grille[j][k] = (int)m;
					k = k+1; 
	
					for(i = nbchiffres; i > 1; i--){
						double c=(val%(Math.pow(10, i-1))-val%(Math.pow(10, i-2)))/(Math.pow(10, i-2));
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

	public void afficheGrilleTxt() {
		for ( int n=0; n<9; n++ ) {
			for( int z=0; z<9; z++) {
				System.out.print(this.grille[n][z] + " ");
			}
			System.out.println();
		}
	}

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

		GestionSouris souris = new GestionSouris(this, fenetre);

		int i,j;
		for(i = 0; i < 9; i++){
			for(j=0; j<9;j++) {   
				MyPanel panneau = new MyPanel(i,j);
				
				pan.add(panneau);
				panneau.setBackground(Color.WHITE);
				panneau.addMouseListener(souris);
				
				
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

		fenetre.setVisible(true);
	}

	public void majGrille(int val, int i, int j, boolean etat) {
		int x,y;
		boolean test = true;
		
		if(etat){
			for(x=0; x<9;x++){    
				if(this.grille[x][j]==val  ){         //vérif colonne
																			//renvoie grille inchangée
					test=false;
					System.out.println("valeur présente dans la colonne à la ligne :" + x);
				}
			}

			for(y=0; y<9;y++){    
				if(this.grille[i][y]==val  ){          //vérif ligne
				
					test=false;  
					System.out.println("valeur présente dans la ligne à la colonne : " + y) ;    //renvoie grille inchangée
				
				}
			}
		
		int indiceHautGauche = i - i % 3;
		int indiceColonneGauche = j - j % 3;

		for (x = indiceHautGauche; x < indiceHautGauche + 3; x++) {
			for (y = indiceColonneGauche; y < indiceColonneGauche + 3; y++) {
				if (this.grille[x][y] == val) {
					test=false;
					System.out.println("valeur déjà présente dans le carré !") ;
				}
			}
		}

		if(test==true){
			this.grille[i][j] = val;
			
		}

	}
	else {
		this.grille[i][j] = val;
	}
}



	public void saveGrille(String nomFichier) {

		System.out.println(nomFichier);

		try {
			
			FileOutputStream fichier = new FileOutputStream(nomFichier);
			
			// int[][] grille = new int[9][9];
			// this.grille=grille;

			try (DataOutputStream fifi = new DataOutputStream(fichier)) {
				String [] tab= new String[9];
				int[] tabGrille = new int[9];
				int i, detect=0;
				int valeur=0;
			
				// int power=8;
				int j=0;
				int nbLigne = 0;
				String newval = "";
			
				for(i=0;i<9;i++){
					for(j=0;j<9;j++){
						valeur=this.grille[i][j];

						if(valeur != 0) { detect = 1; }

						if(detect != 0) { 
							newval = newval + String.valueOf(valeur); 
						}

						System.out.print(valeur + " ");
					}

					if(detect == 1) { nbLigne++; }
					
					detect = 0;
					tab[i] = newval;
					newval= "";
					System.out.println();
         
				}
			
			
				System.out.println();
				System.out.println();
			
				for (int k=0;k<9;k++) {
					System.out.println(tab[k]);
				}
			
				for(i=0;i<9;i++){
					tabGrille[i]=Integer.parseInt(tab[i]);
					
				}

				for(i=0;i<9;i++){
					fifi.writeInt(tabGrille[i]);
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
