
public class HexagoneRegulier extends Figure {
	final private int longueur;
	public HexagoneRegulier(int x, int y, int l) {
		super(x, y);
		longueur = l;
		
	}

	@Override
	public void affiche() {
		System.out.println("la position du centre de cette hexagone régulie X: " + this.getPosX()+" Y: "+ this.getPosY() +
				" le longueur: "+longueur);

	}

	@Override
	public double surface() {
		return ( (3.0*Math.cbrt(3)/2.0) * (Math.pow(longueur, 2.0)) );
	}

	@Override
	public double perimetre() {
		return (6*longueur);
	}

}
