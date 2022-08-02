
public class QuestionChaine extends Question {
	private final String reponse;
	
	public QuestionChaine(String intit, int poin, String rep) {
		super(intit, poin);
		this.reponse = rep;
	}

	@Override
	public boolean estCorrecte(String reponseFournie) {
		if (reponse.compareToIgnoreCase(reponseFournie) == 0) {
			return true;
		}
		return false;
	}

}
