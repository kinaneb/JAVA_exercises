import java.util.Random;
import java.util.ArrayList;

public class Jeu {
	Random rand = new Random();
	ArrayList<Case> plat = new ArrayList<>();
	ArrayList<Joueur> joueurs = new ArrayList<>();

	public Jeu(int n, int j) {
		for (int i = 1; i <= j; i++) {
			joueurs.add(new Joueur(i));
		}
		for (int i = 0; i < n; i++) {
			plat.add(new Case(i));
		}
		for (int i = 0; i < n / 10; i++) {
			echelle(plat);
			serpent(plat);
		}
		

	}

	public void affichJoueur() {
		for (int i = 0; i < joueurs.size(); i++) {
			System.out.println(joueurs.get(i));
		}
	}

	private int getCase(ArrayList<Case> p) {
		int posi = 1 + rand.nextInt(p.size() - 2);
		if (p.get(posi).dest != p.indexOf(p.get(posi))) {
			return getCase(p);
		} else {
			return posi;
		}
	}

	private void echelle(ArrayList<Case> p) {
		int posi = getCase(p);
		int dest = getCase(p);
		if (posi > dest) {
			dest = dest + posi;
			posi = dest - posi;
			dest = dest - posi;
		}
		p.get(posi).dest = dest;
	}

	private void serpent(ArrayList<Case> p) {
		int posi = getCase(p);
		int dest = getCase(p);
		if (posi > dest) {
			dest = dest + posi;
			posi = dest - posi;
			dest = dest - posi;
		}
		p.get(dest).dest = posi;
	}

	static class Case {
		int dest;

		Case(int n) {
			dest = n;
		}

		int destination() {
			//System.out.println("dest  " + dest);
			return dest;
		}
	}

	class Joueur {
		int num;
		int position = 0;

		Joueur(int n) {
			num = n;
		}

		boolean joueUnTour() {
			/*
			 * if (this.position == plat.size() - 1) { return true; } else {
			 */
			System.out.println("Lancez le dé !!!");
			int de = (rand.nextInt(6) + 1);
			System.out.println(de);
			this.position += de;
			//System.out.println(this.position + "***");
			if (this.position > (plat.size() - 1)) {
				//System.out.println("%% %% %%");
				int temp = this.position - (plat.size() - 1);
				this.position = (plat.size() - 1) - temp;
				//System.out.println(plat.size() - 1+"  "+ temp + "%% %% %%" + this.position);
			}

			this.position = plat.get(this.position).destination();
			if (this.position == plat.size() - 1) {
				//System.out.println(this.num + "** gan");
				return true;
			}
			return false;

		}

		public String toString() {
			String s = "";
			s += "joueur num " + num + " a la position " + position;
			/*
			 * if (joueUnTour()) { s += " *** gagné ***"; }
			 */
			return s;
		}
	}

}
