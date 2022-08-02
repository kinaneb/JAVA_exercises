
public class GrosObjet {
	private static int nomero = 0;
	private int[] tabl = new int[1000000];
	public GrosObjet() {
		nomero++;
		System.out.print(nomero + " ");
	}
	public void finalize() {
		System.out.println("finalize... "+nomero);
	}
}
