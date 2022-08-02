
public class Entree {

	private Dossier contenant;

	private String nom;

	private Element element;

	public Entree(Dossier c, String n, Element e) {
		this.contenant = c;
		this.nom = n;
		this.element = e;
	}

	public String toString() {
		//return nom + element.getType();
		if (element != null) {
			return nom + element.getType();
		}
		return nom + " (Dossier)";
	}

	public String getNom() {
		return nom;
	}

	public String getContenantType() {
		return contenant.getType();
	}

	public Dossier getContenant() {
		return contenant;
	}

	public Element getElement() {
		return element;
	}

	public void supprimer() {
		this.contenant = null;
	}

	public void inserer(Element e) {
		if (e instanceof Dossier) {
			((Dossier) e).parent = contenant;
		}
		this.element = e;
	}

}
