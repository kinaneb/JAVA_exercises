
public class FichierTexte extends Element implements Affichable {
	private String contenu;
	public FichierTexte() {
	}

	@Override
	public String getType() {
		return " (FichierTexte)";
	}

	@Override
	public void afficher() {
		System.out.println(contenu);
		
	}

}
