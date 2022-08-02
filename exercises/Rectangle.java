
public class Rectangle extends Figure implements Deformer {
	final private int largeur;
	final private int hauteur;

	public Rectangle(int x, int y, int l, int h) {
		super(x, y);
		largeur = l;
		hauteur = h;
	}
	
	int getLargeur() {
		return largeur;
	}
	
	@Override
	public void affiche() {
		System.out.println("la position du centre de cette rectangle X: " + this.getPosX()+" Y: "+ this.getPosY() +
				" le largeur: "+largeur+" le hauteur: "+hauteur);

	}

	@Override
	public Figure deformation(double coeffH, double coeffV) {
		int l = (int)(largeur * coeffH);
		int h = (int)(hauteur * coeffV);
		return new Rectangle(super.getPosX() , super.getPosY() , l, h);
	}

	@Override
	public double surface() {
		return (double)(largeur * hauteur);
	}

	@Override
	public double perimetre() {
		return ((largeur+hauteur)*2);
	}

	

}
