import java.util.LinkedList;

public class QCM extends Question {
	private LinkedList<String> reponse = new LinkedList<String>();
	public QCM(String intit, int poin) {
		super(intit, poin);
		reponse.add("B R");
	}
	public void setBonReponse(String qcmRep) {
		reponse.set(0, qcmRep);
		reponse.add(qcmRep);
	}
	public void setReponse(String qcmRep) {
		reponse.add(qcmRep);
	}
	@Override
	public boolean estCorrecte(String reponseFournie) {
		
			if (reponse.get(0).compareToIgnoreCase(reponseFournie) == 0) {
				return true;
		}
		return false;
	}
	public String toString() {
		String s = getIntituleQ();
		for (int i = 1; i < reponse.size(); i++) {
			 s += "\n" + reponse.get(i).toString();
		}
		s += "\n";
		return s;
	}

}
