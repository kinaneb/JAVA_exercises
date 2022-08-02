
public class DeuxPoints extends Entree {

	public DeuxPoints(Dossier c, String n, Element e) {
			super(c, "..", e);
		}
	/*
	public String getType() {
		return super.getContenant().getType();
	}
	*/
	
	public void supprimer() {
		System.out.println("ce type ne peut pas etre modifiées");
	}

	public void inserer(Element e) {
		System.out.println("ce type ne peut pas etre modifiées");
	}

}
