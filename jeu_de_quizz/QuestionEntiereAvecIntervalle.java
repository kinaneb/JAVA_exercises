
public class QuestionEntiereAvecIntervalle extends QuestionEntiereAbstraite {
	private final int intervalle;
	public QuestionEntiereAvecIntervalle(String intit, int poin, int rep, int interv) {
		super(intit, poin, rep);
		this.intervalle = interv;
	}

	@Override
	public boolean estCorrecte(int i) {
		if ( (i <= getIntReponse() + intervalle) || (i >= getIntReponse() - intervalle) ) {
			return true;
		}
		return false;
	}
	public String toString() {
		return getIntituleQ() + "(à " + intervalle + " près) ";
	}

}
