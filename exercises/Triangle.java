
public class Triangle extends Figure implements Deformer{
	final private int hauteur;
	final private int base;
	public Triangle(int x, int y, int b, int h) {
		super(x, y);
		base = b;
		hauteur = h;
	}

	@Override
	public void affiche() {
		System.out.println("la position du centre de cette triangle X: " + this.getPosX()+" Y: "+ this.getPosY() +
				" le hauteur: "+hauteur+" le base: "+base);

	}

	@Override
	public Figure deformation(double coeffH, double coeffV) {
		int l = (int)(base * coeffH);
		int h = (int)(hauteur * coeffV);
		return new Triangle(super.getPosX(), super.getPosY(), l, h);
	}

	@Override
	public double surface() {
		return (double)(base * hauteur)/2.0;
	}

	@Override
	public double perimetre() {
		return ( 2*Math.cbrt(Math.pow((base/2.0) ,2.0)+Math.pow(hauteur,2.0)) + base ) ;
	}

}
