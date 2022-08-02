import java.util.ArrayList;
import java.util.Collections;

public class FigueTriable<T> implements Triable<Figure> {

	ArrayList<Figure> t = new ArrayList<Figure>();
	/*
	public FigueTriable(Figure f) {
		t.add(f);
	}*/
	@Override
	public void echange(int i, int j) {
		Collections.swap(t, i,j);
	}

	@Override
	public boolean plusGrand(int i, int j) {
		if ( (t.get(i)).compareTo(t.get(j)) < 0) {
			return false;
		} else
			return true;
	}

	@Override
	public int taille() {
		return t.size();
	}
/*
	static void triBulles(Triable tt) {
		boolean change = false;
		do {
			change = false;
			for (int i = 0; i < tt.taille() - 1; i++) {
				if (tt.plusGrand(i, i+1)) {
					tt.echange(i, i+1);
					change = true;
				}
			}
		} while (change);
	}*/
	public void affiche() {
		for(Figure f: t) {
			 f.affiche();
		}
	}

}
