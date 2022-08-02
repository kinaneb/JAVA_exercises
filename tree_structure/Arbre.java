import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Arbre {
	private class Noeud {
		private boolean repertoire;
		private String nom;
		private long taille;
		private ArrayList<Noeud> fils = null;

		public Noeud(File f) throws FileNotFoundException {
			if (!f.exists()) {
				throw new FileNotFoundException("Could not find file: " + f.getName());
			} else {
				nom = f.getName();
				taille = f.length();
				repertoire = f.isDirectory();
				if (repertoire) {
					fils = new ArrayList<>();
					for (File ff : f.listFiles()) {
						fils.add(new Noeud(ff));
					}

				}
			}
		}

		public String toString() {
			return nom + " (" + taille + ")";
		}

		private String affich(String x) {
			String s = "";
			String ss = " ";
			s += this.toString();
			if (this.repertoire) {

				for (Noeud n : fils) {
					// System.out.println("''");
					ss += x;
					s += "\n  " + x + n.affich(ss);
					// s += "**";
				}
			}
			return s;
		}

	}

	private Noeud racine;

	public Arbre(String chemin) throws FileNotFoundException {
		File rac = new File(chemin);
		if (!rac.exists()) {
			throw new FileNotFoundException("Could not find file: " + rac.getName());
		} else {
			this.racine = new Noeud(rac);
			// System.out.println(racine.fils);
		}
	}

	public void afficher() {

		String s = "";
		s += racine.toString();
		for (Noeud n : racine.fils) {
			s += "\n  " + n.affich(" ");

		}
		System.out.println(s);
	}
}
