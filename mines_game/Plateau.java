import java.util.Random;

public class Plateau {
	public final int hauteur, largeur, nbMines ;

	private boolean[][] mines;
	/* indique où sont les mines sur le plateau */

	private int[][] etats;
	/*
	 * indique dans quel état est chaque case (cachée, révélée, avec/sans
	 * drapeau)
	 */

	private int[][] adja;
	/*
	 * indique le nombre de mines adjacentes à chaque case
	 */

	// Libre à vous de rajouter d'autres attributs si vous sentez que vous en
	// aurez besoin.

	public static final int CACHEE = 0, REVELEE = 1, DRAPEAU = 2;
	/* l'etats de case */

	public static final int REVELER = 1, POSERDRAPEAU = 2;
	/* l'action sur case */
	
	private int drapeau = 0;

	public Plateau(int hauteur, int largeur, int nbMines) {
		/*
		 * Constructeur de la classe Plateau crée le plateau avec des cases
		 * vides (sans mines)
		 */
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.nbMines = nbMines;
		mines = new boolean[hauteur][largeur];
		etats = new int[hauteur][largeur];
		adja = new int[hauteur][largeur];

		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				mines[i][j] = false;
				etats[i][j] = CACHEE;
				adja[i][j] = 0;
			}
		}
		ajouteMinesAlea(mines, nbMines);
		/* fonction qui ajoute les mines */

	}

	private void ajouteMinesAlea(boolean[][] mines, int nbMines) {
		// int nbMinesRestantes = nbMines;
		Random randomN = new Random();
		while (nbMines > 0) {
			int ligne = randomN.nextInt(hauteur);
			int colonne = randomN.nextInt(largeur);
			if (!mines[ligne][colonne]) {
				mines[ligne][colonne] = true;
				adja[ligne][colonne] = -1;
				nbMines--;
				calculeAdjacence(ligne, colonne);
				/* fonction qui remplit le tableau d'adjacence */
			}
		}
	}

	private void calculeAdjacence(int i, int j) {
		// adja(i-1, j-1) +=1;
		// adja(i-1, j) +=1;
		// adja(i-1, j+1) +=1;
		// adja(i, j+1) +=1;
		// adja(i+1, j+1) +=1;
		// adja(i+1, j) +=1;
		// adja(i+1, j-1) +=1;
		// adja(i, j-1) +=1;
		/* ajoute 1 dans la valeur de adja des case voisins de min */
		for (int l = i - 1; l <= i + 1; l++) {
			for (int c = j - 1; c <= j + 1; c++) {
				if (!((l < 0) || (l > hauteur - 1) || (c < 0) || (c > largeur - 1) || (l == i && c == j) || (mines[l][c]))) {
					adja[l][c] += 1;
				}
			}
		}
	}

	private boolean revelerCase(int i, int j, boolean forcerDrapeau) {
		/*
		 * fonction révèle la case dont l'utilisateur a donné les coordonnées
		 * et révèle les les 8 cases voisin si sa adja est 0
		 */
		if ((etats[i][j] == CACHEE) || forcerDrapeau) {
			etats[i][j] = REVELEE;
			if (mines[i][j]) {
				jeuPerdu();
				jeuGagne();
			} else if (adja[i][j] == 0) {
				revelerAdja(i, j);
			}
			return true;
		} else if (etats[i][j] == DRAPEAU) {
			System.out.println("Il y a un drapeau sur cette case");
			return false;
		} else {
			System.out.println("Cette case est déjà révélée");
			return false;
		}
	}

	private void revelerAdja(int i, int j) {
		for (int l = i - 1; l <= i + 1; l++) {
			for (int c = j - 1; c <= j + 1; c++) {
				if (!((l < 0) || (l > hauteur - 1) || (c < 0) || (c > largeur - 1) || (l == i && c == j))) {
					// System.out.println(l + " " + c);
					if ((etats[l][c] == CACHEE)||((etats[l][c] == DRAPEAU))) {
						revelerCase(l, c, true);
				}
				//System.out.println("test en dehors");

			}
		}
	}
	}
	public boolean drapeauCase(int l, int c) {
		if (!((l < 0) || (l > hauteur - 1) || (c < 0) || (c > largeur - 1))) {
			//System.out.println(l + "   " + c);
				if ((etats[l][c] == CACHEE)) {
					etats[l][c] = DRAPEAU;
					drapeau++;
					return true;
				} else if ((etats[l][c] == DRAPEAU)) {
					etats[l][c] = CACHEE;
					drapeau--;
					return true;
				} else {
					System.out.println("Cette case est déjà révélée");
					return false;
				}
			}
		
		System.out.println("en dehors");
		return false;
	}

	String affichageNomber(int i) {
		String nom;
		if (i == -1){
			nom = "**";
		}
		else if (i < 10) {
			nom = "0" + i;
		} else {
			nom = "" + i;
		}
		return nom;
	}

	public String affichage() {
		String affichage = new String();
		affichage += new String(new char[largeur]).replace("\0", "* * ");
		affichage += "   \n*Mines/Drapeaux*";
		affichage += "   \n*  " + nbMines + "   /  " +drapeau+" *\n";
		affichage += new String(new char[largeur]).replace("\0", "* * ");
		affichage += "\n    ";
		for (int i = 1; i <= largeur; i++) {
			affichage += "(" + affichageNomber(i) + ")";
		}
		affichage += "\n";
		for (int i = 0; i < hauteur; i++) {
			affichage += "(" + affichageNomber(i + 1) + ")";
			for (int j = 0; j < largeur; j++) {
				switch (etats[i][j]) {
				case REVELEE:
					affichage += "["+affichageNomber(adja[i][j])+"]";
					break;
				case CACHEE:
					affichage += "[..]";
					break;
				case DRAPEAU:
					affichage += "[??]";
					break;
				default:
					affichage += "";
					break;
				}
			}
			affichage += "\n";
		}
		return affichage;
	}

	public boolean jeuPerdu() {
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				if ((etats[i][j] == REVELEE) && (mines[i][j])) {
					//System.out.println("test predu");
					return true;
				}
			}
		}
		//System.out.println("test predu 1");
		return false;
	}

	public boolean jeuGagne() {
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				if ((etats[i][j] == CACHEE) && (!mines[i][j])) {
					return false;
				}
			}
		}
		System.out.println("Vous avez gagné!");
		return true;
	}

	public boolean agir(int[] action) {
		// On decompose action (x,y,typeAction)
		int x = action[0];
		int y = action[1];
		int typeAction = action[2];
		// Reveler une case
		switch (typeAction) {
		case REVELER:
			return revelerCase(x, y, false);
		case POSERDRAPEAU:
			return drapeauCase(x,y);
		default:
			return false;
		//
		}
	}
}
