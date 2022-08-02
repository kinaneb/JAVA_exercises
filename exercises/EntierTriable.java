import java.util.ArrayList;
import java.util.Collections;

public class EntierTriable implements Triable<Integer> {
	ArrayList<Integer> t = new ArrayList<Integer>();
	
	
	public EntierTriable(int[] n) {
		for (int i: n) {
			t.add(new Integer(i));
		}
	}

	@Override
	public void echange(int i, int j) {
		Collections.swap(t, i, j);

	}

	@Override
	public boolean plusGrand(int i, int j) {
		if (t.get(i).compareTo(t.get(j)) <= 0) {
			return false;
		} else
			return true;
	}

	@Override
	public int taille() {
		return t.size();
	}

	@Override
	public String toString() {
		String s = "";
		for (Integer f : t) {
			s += " " + f;
		}
		return s;
	}

}
