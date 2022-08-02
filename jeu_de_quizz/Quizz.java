import java.util.LinkedList;
import java.util.Scanner;

public class Quizz {
	private LinkedList<Question> listeQuestions;
	private Question q;
	private Scanner scan = new Scanner(System.in);
	private int jouerPoints = 0;
	private int fullPoints = 0;

	public Quizz() {
		listeQuestions = new LinkedList<Question>();
	}

	public Question getListeQuestions(int n) {
		return listeQuestions.get(n);
	}

	public void setListeQuestions(Question q) {
		this.listeQuestions.add(q);
	}

	public void pose() {
		//System.out.println(listeQuestions.toString());
		for (int i = 0; i < listeQuestions.size(); i++) {
			//System.out.println(i);
			System.out.println(getListeQuestions(i).toString() + " ("+ getListeQuestions(i).getPointsQ() + " point)");
			if (getListeQuestions(i).estCorrecte(scan.nextLine())) {
				System.out.println("Bonne reponse");
				jouerPoints += getListeQuestions(i).getPointsQ();
				fullPoints += getListeQuestions(i).getPointsQ();
			} else {
				System.out.println("Mauvaise reponse");
				fullPoints += getListeQuestions(i).getPointsQ();
			}
		}
		System.out.println("FINI : Vous avez marque " + jouerPoints + " points sur " + fullPoints);
		// Exercice 2: 3.non on peut pas parce que la fonction estCorrecte est abstract
		// et il est pas definie ecoure
	}
}
