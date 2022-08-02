import java.util.LinkedList;

public class Dossier extends Element implements Affichable {
	LinkedList<Entree> entrées = new LinkedList<>();
	Dossier parent;

	Point moi = new Point(this, ".", this);
	DeuxPoints monParent = new DeuxPoints(this, "..", parent);

	public Dossier(Dossier p) {
		this.parent = p;
		entrées.add(moi);
		entrées.add(monParent);
	}

	@Override
	public String getType() {
		return " (Dossier)";
	}

	public void ajouterEntree(String s, Element e) {
		Entree en = new Entree(this, s, null);
		en.inserer(e);
		entrées.add(en);

	}

	public Entree lireEntree(String nom, boolean creer) {
		for (Entree e : entrées) {
			if (e.getNom().equals(nom)) {
				return e;
			}
		}
		if (creer) {
			ajouterEntree(nom, new Dossier(this));
		}
		return null;
	}

	@Override
	public void afficher() {
		for (Entree e : entrées) {
			System.out.println(e);/*
			if (!e.equals(null)) {
				System.out.println(e);
			}*/
		}
	}

}