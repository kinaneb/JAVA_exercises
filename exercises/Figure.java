
public abstract class Figure implements Comparable<Figure>{
	private int posX;
	private int posY;

	public Figure(int x, int y) {
		posX = x;
		posY = y;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public abstract void affiche();

	public abstract double surface();
	
	public abstract double perimetre();

	public double estDistantDe(Figure fig) {
		return Math.cbrt( Math.pow( (double)(fig.getPosX() - this.getPosX()) ,2.0) +
			   		      Math.pow( (double)(fig.getPosX() - this.getPosX()) ,2.0) );
	}

	public void deplacement(int x, int y) {
		posX = x;
		posY = y;
	}
	public int compareTo(Figure f) {
		if (this.surface() == f.surface()) return 0;
		else if (this.surface() > f.surface()) return 1;
		else return -1;
		
	}

}
