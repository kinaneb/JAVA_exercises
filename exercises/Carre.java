
public class Carre extends Rectangle {

	public Carre(int x, int y, int l) {
		super(x, y ,l ,l);
	}
	public void affiche() {
		System.out.println("la position du centre de cette carre X: " + this.getPosX()+" Y: "+ this.getPosY() +
				" le longueur: "+this.getLargeur());

	}

}
