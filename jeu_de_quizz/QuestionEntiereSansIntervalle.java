
public class QuestionEntiereSansIntervalle extends QuestionEntiereAbstraite {

	public QuestionEntiereSansIntervalle(String intit, int poin, int rep) {
		super(intit, poin, rep);
	}

	@Override
	public boolean estCorrecte(int i) {
		if (i == getIntReponse()) {
			return true;
		}
		return false;

	}

}
