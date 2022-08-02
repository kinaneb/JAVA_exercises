import java.util.ArrayList;
import java.util.Collections;

public class Dictionnaire implements Triable<String> {
	ArrayList<String> t = new ArrayList<String>();
	public Dictionnaire(String[] s) {
		for (String i : s) {
			t.add(i);
		}
	}

	@Override
	public void echange(int i, int j) {
		Collections.swap(t, i,j);
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
	
	public String toString() {
		String s = "";
		for (String f : t) {
			s += " " + f;
		}
		return s;
	}

}
