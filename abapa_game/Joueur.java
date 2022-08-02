import java.util.Scanner;

public class Joueur {
	private VuePlateau monVue;
	private Scanner scan = new Scanner(System.in);
	private String name;
	private int joueurVue = 0;

	public Joueur(VuePlateau monVue) {
		this.monVue = monVue;
		name = "";
		joueurVue = 0;
	}

	public int nombreChoisi() {
		String reponse = scan.nextLine();
		try {
			return Integer.parseInt(reponse);

		} catch (NumberFormatException nfe) {
			System.out.println("Ce n'est pas un nombre");
		}
		return nombreChoisi();
	}

	public void setNom(String name) {
		this.name = name;
	}

	public void setJouVue(int n) {
		joueurVue = n;
	}

	public String getNom() {
		return name;
	}

	public int getjouVue() {
		return joueurVue;
	}
	
	/*public int bonombreChoisi(){
		int trou = nombreChoisi();
		if ((trou < 0) || (trou > 5)) {
			System.out.println("Enter nombre entre 0 et 5 SVP");
			trou=bonombreChoisi();
		}
		return trou;
	}*/

	public int demanderCoup() {
		//System.out.println("\n \n \n");
		monVue.afficherPlateau();
		System.out.println("Choisissez le numéro de truo s'il vous plaît ");
		int trou = nombreChoisi();
		if (!monVue.viderCase(trou)) {
			rejeterCoup();
		}
		return trou;
	}

	public void rejeterCoup() {
		System.out.println("Mouvement interdit");
	}

}
