
public class Lanceur {
	public static void main(String[] args) {
		int h = 5, l = 5, m = 2;
		Joueur player = new Joueur();
		player.setNom();
		System.out.println("Bienvenue au démineur " + player.getNom() + " !");
		System.out.println("Voulez-vous jouer ?");
		while (player.ouiNon()) {
			System.out.println("Vous resultats :\nGagner :" + player.getGagner() + ", Perdu :"+ player.getPerdu());
			System.out.println("Les paramètres par défaut sont :");
			System.out.println(" hauteur : " + h + "\n largeur : " + l + "\n mines : " + m);
			System.out.println("Voulez-vous les changer ?");
			if (player.ouiNon()) {
				System.out.println("Quelle hauteur ?");
				h = player.nombreChoisi();
				while (h < 1 || h > 26) {
					System.out.println("Veuillez donner une hauteur entre 1 et 26");
					h = player.nombreChoisi();
				}
				System.out.println("Quelle largeur ?");
				l = player.nombreChoisi();
				while (l < 1 || l > 38) {
					System.out.println("Veuillez donner une largeur entre 1 et 38");
					l = player.nombreChoisi();
				}
				System.out.println("Combien de mines ?");
				m = player.nombreChoisi();
				while (m < 1 || m > h * l) {
					System.out.println("Veuillez donner un nombre de mines entre 1 et " + (h * l));
					m = player.nombreChoisi();
				}
			}
			System.out.println("Ok, c'est parti !");
			Plateau lePlateau = new Plateau(h, l, m);
			Jeu demineur = new Jeu(player, lePlateau);
			demineur.jouer();
			if(lePlateau.jeuGagne()){
				System.out.println("Bravo !");
			    System.out.println("Voulez-vous rejouer ?");
				} else{
				System.out.println("Ouch...");
			    System.out.println("Voulez-vous rejouer ?");
			    }

		}
	}
}
