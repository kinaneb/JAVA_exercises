
public class Abapa {
	static boolean fini = false;

	public static void main(String[] args) {
		//boolean fini = false;
		Jeu jeu = new Jeu();
		while(!fini){
			if(jeu.jouerTour()){fini = jeu.fini();}
			else{
			fini = true;}
		}
		//jeu.vuePlateau.afficherPlateau();
		jeu.afficherGagnant();
	}

}
