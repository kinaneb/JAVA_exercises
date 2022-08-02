import java.util.Scanner;

public class Jeu {
	Plateau plateau = new Plateau();
	VuePlateau vuePlateau = new VuePlateau(plateau);
	Joueur jouUn = new Joueur(vuePlateau);
	Joueur jouDeux = new Joueur(vuePlateau);
	Scanner scan = new Scanner(System.in);
	int n;

	public int nombreChoisi() {
		String reponse = scan.nextLine();
		try {
			int i = Integer.parseInt(reponse);
			if (!((i == 0) || (i == 1))) {
				System.out.println("Entre 1 ou 2 SVP");
				nombreChoisi();
			}
			return i;
		} catch (NumberFormatException nfe) {
			System.out.println("Ce n'est pas un nombre");
		}
		return nombreChoisi();
	}

	public Jeu() {

		System.out.println("Joueur un, Entrez votre nom SVP");
		jouUn.setNom(scan.nextLine());
		System.out.println("Joueur deux, Entrez votre nom SVP");
		jouDeux.setNom(scan.nextLine());
		System.out.println("Qui souhaite commencer ?");
		System.out.println("Pour " + jouUn.getNom() + " enter 0 , Pour " + jouDeux.getNom() + " enter 1");
		n = nombreChoisi();
		if (n == 1) {
			jouUn.setJouVue(n);
		} else if (n == 0) {
			jouDeux.setJouVue(1);
		}
		//vuePlateau.afficherPlateau();

	}

	public boolean fini() {
		if ((plateau.grainesCase(6) > 24) || (plateau.grainesCase(13) > 24)) {
			vuePlateau.afficherPlateau();
			return true;
		}
		if ((plateau.grainesCase(6) == 24) && (plateau.grainesCase(13) == 24)){
			return true;
		}
			
		return false;
	}

	public Joueur jouActif() {
		if (jouDeux.getjouVue() == plateau.joueurVue) {
			return jouDeux;
		}
		return jouUn;
	}

	public void swichJou() {
		if (jouActif().getjouVue() == 1) {
			plateau.joueurVue = 0;
		} else {
			plateau.joueurVue = 1;
		}
	}

	public boolean jouerTour() {

		if (vuePlateau.peutJouer()) {
			System.out.println("* " + jouActif().getNom() + " :");
			jouActif().demanderCoup();
			swichJou();
			return true;
		} else {
			//swichJou();
			System.out.println("Adversaire est affame , Dommage" + jouActif().getNom());
			return false;
			
		}
	}

	public void afficherGagnant() {
		System.out.println("Bravo " + jouActif().getNom());
	}

}
