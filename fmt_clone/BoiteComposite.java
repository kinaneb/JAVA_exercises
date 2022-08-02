import java.util.LinkedList;

public class BoiteComposite extends Boite {

	LinkedList<Boite> suite = new LinkedList();

	@Override
	public int length() {
		int n = 0;
		for (Boite b : suite) {
			n += b.length();
		}
		return n;
	}

	@Override
	public String toString() {
		String s = "";
		for (Boite b : suite) {
			s += b;
		}
		//System.out.println(s);
		return s;
	}

	public boolean isEmpty() {
		if (suite.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public void addBoite(Boite b) {
		BoiteEspace es = new BoiteEspace();
		//System.out.println(b);
		suite.add(b);
		suite.add(es);
	}
}
