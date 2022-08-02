import java.util.Scanner;

public class lancerJeu {
	static Scanner scan = new Scanner(System.in);

	public static int nombreChoisi() {

		String reponse = scan.nextLine();
		try {
			//int n = Integer.parseInt(reponse);
			if (Integer.parseInt(reponse) > 0) {
				return Integer.parseInt(reponse);
			}
		} catch (NumberFormatException e) {
			System.out.println("Ce n'est pas un nombre");
		}
		return nombreChoisi();
	}

	public static void main(String[] args) {
		int n, j;
		System.out.println("Combien de joueurs voulez-vous ?");
		j = nombreChoisi();
		System.out.println("Quelle est la taille de la plateau ?");
		n = nombreChoisi();
		Jeu jeu = new Jeu(n, j);
		System.out.println(jeu.plat.size());
		boolean jouer = false;

		while (!jouer) {
			for (int i = 0; i < j; i++) {
				jeu.affichJoueur();
				System.out.println("appuyez sur enter pour continuer");
				scan.nextLine();
				jouer = jeu.joueurs.get(i).joueUnTour();
				if (jouer) {
					System.out.println("joueur num " + jeu.joueurs.get(i).num + " ** gagné **");
					return;
				}
				// System.out.println(jouer);
			}

		}
	}
}
