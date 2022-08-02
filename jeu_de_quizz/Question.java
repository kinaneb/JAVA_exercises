
public abstract class Question {
	final private String intituleQ;
	final private int pointsQ;

	public Question(String intit, int poin) {
		this.intituleQ = intit;
		this.pointsQ = poin;
	}

	public String getIntituleQ() {
		return intituleQ;
	}

	public int getPointsQ() {
		return pointsQ;
	}
	public abstract boolean estCorrecte(String reponseFournie);
	
	public String toString() {
		return getIntituleQ();
	}
}
