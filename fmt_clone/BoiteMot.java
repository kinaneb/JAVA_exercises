
public class BoiteMot extends Boite {
	String s;
	
	public BoiteMot(String s) {
		this.s = s;
	}
	
	@Override
	public int length() {
		return s.length();
	}

	@Override
	public String toString() {
		return s;
	}
}
