
public class VuePlateau {
	private Plateau plateau;
	public VuePlateau(Plateau plateau){
		this.plateau = plateau;
	}
	String grainesNom(int i){
		String nom;
		if (plateau.trous[i].graines < 10){
			nom = "0" + plateau.trous[i].graines;
		}else{ 
			nom = ""+plateau.trous[i].graines;
		}
		return nom;
	}
	public void afficherPlateau() {
		
		String affichage = "     ———  ———  ———  ———  ———  ——— \n    ";
		if (plateau.joueurVue == 0) {
			for (int i = 12; i > 6; i--) {
				affichage += "| " + grainesNom(i) + " ";
			}
			affichage += "|\n     ———  ———  ———  ———  ———  ——— \n";
			affichage += "———                                ———";
			affichage += "\n " + grainesNom(13) + " |                             | " + grainesNom(6) + " \n";
			affichage += "———                                ———";
			affichage += "\n     ———  ———  ———  ———  ———  ——— \n    | ";

			for (int i = 0; i < 6; i++) {
				affichage += grainesNom(i) + " | ";
			}
			affichage += "\n     ———  ———  ———  ———  ———  ——— \n  ";
		} else {
			for (int i = 5; i > -1; i--) {
				affichage += "| " + grainesNom(i) + " ";
			}
			affichage += "|\n     ———  ———  ———  ———  ———  ——— \n";
			affichage += "———                                ———";
			affichage += "\n " + grainesNom(6) + " |                             | " + grainesNom(13) + " \n";
			affichage += "———                                ———";
			affichage += "\n     ———  ———  ———  ———  ———  ——— \n    | ";
			for (int i = 7; i < 13; i++) {
				affichage += grainesNom(i) + " | ";
			}
			affichage += "\n     ———  ———  ———  ———  ———  ——— \n";
		}
		System.out.println(affichage);
		System.out.println("\n \n \n");
	}

	public boolean viderCase(int trou){
		if ((trou < 0) || (trou > 5)) {
			System.out.println("Enter nombre entre 0 et 5 SVP");
			return false;
		}
		if (plateau.joueurVue == 1){
			trou = 7 + trou;
		}
		if ((plateau.joueurVue != plateau.trous[trou].joueurVue)||
			(plateau.grainesCase(trou) == 0)||
			(trou == 6)||(trou == 13)){
			return false;
		}
		else{
			int i = trou + 1;
			while(plateau.grainesCase(trou) > 0){
				plateau.trous[trou].graines--;
				if (i != trou){
				plateau.trous[i].graines++;
				}
				if ((plateau.grainesCase(i) == 2) || (plateau.grainesCase(i) == 3)){
					//System.out.println("test vidcas");
					int temp = plateau.trous[i].graines;
					plateau.trous[i].graines = 0;
					if(plateau.trous[6].joueurVue == plateau.joueurVue){
						plateau.trous[6].graines += temp;
					}else{plateau.trous[13].graines += temp;}
				}
				i++;
				if(i == 14){ i = 0;}
			}
			
			return true;
		}
	}
	public boolean peutJouer(){
		int i = 0;
		if (plateau.joueurVue == 1){i = 7;}
		//System.out.println(i+"test peutJouer iiii");
		for (int j = 0; j < 6; j++){

			//System.out.println(j+"test peutJouer jjj");
			//System.out.println(i+"test peutJouer ii");
			if (plateau.grainesCase(i) != 0){
				return true;
				}
			i++;
		}
		return false;
	}

}
