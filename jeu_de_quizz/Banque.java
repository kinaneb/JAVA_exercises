import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Banque {
	private LinkedList<Question> listeQuestions = new LinkedList<Question>();
	private LinkedList<Question> listeQuestionsCopy = new LinkedList<Question>();
	private Random rand = new Random();
	private Scanner scan;
	private String peron;

	public void supprimerQ(int n) {
		listeQuestions.remove(n);
	}

	public void ajouterQ(Question q) {
		listeQuestions.add(q);
	}

	public void changerOQ(int i, int j) {
		Collections.swap(listeQuestions, i, j);
	}

	public void cloneLQ() {
		for (int i = 0; i < listeQuestions.size(); i++) {
			listeQuestionsCopy.add(listeQuestions.get(i));
		}
	}

	public Question pollQuestion() {
		int n = rand.nextInt(listeQuestionsCopy.size());
		Question qq;
		qq = listeQuestionsCopy.get(n);
		listeQuestionsCopy.remove(n);
		return qq;
	}

	public Quizz CreationQuizzAleatoire(int nbQuestions) {
		cloneLQ();
		Quizz qui = new Quizz();
		for (int i = 0; i <= nbQuestions; i++) {
			qui.setListeQuestions(pollQuestion());
		}
		return qui;
	}

	public Question createQuestion() {
		Scanner scann = new Scanner(System.in);
		String intit, repon;
		int poin, rep, intrev;
		System.out.println("si vous souhaitez de create un Question Chaine choisez 1"
				+ "si vous souhaitez de create un Question Entiere Sans Intervalle choisez 2"
				+ "\nsi vous souhaitez de create un Question Entiere Avec Intervalle choisez 3"
				+ "\nsi vous souhaitez de create un QCM choisez 2");
		peron = scan.nextLine();
		if (peron.compareTo("1") == 0) {
			System.out.println("intrez le question intitulé");
			intit = scann.nextLine();
			//System.out.println("test1 " + intit);
			System.out.println("intrez le question points");
			poin = Integer.parseInt(scann.nextLine());
			//System.out.println("test1 " + poin);
			System.out.println("intrez le question réponse");
			repon = scann.nextLine();
			//System.out.println("test1 " + repon);
			return new QuestionChaine(intit, poin, repon);
		} else if (peron.compareTo("2") == 0) {
			System.out.println("intrez le question intitulé");
			intit = scann.nextLine();
			System.out.println("intrez le question points");
			poin = Integer.parseInt(scann.nextLine());
			System.out.println("intrez le question réponse");
			rep = Integer.parseInt(scann.nextLine());
			return new QuestionEntiereSansIntervalle(intit, poin, rep);
		} else if (peron.compareTo("3") == 0) {
			System.out.println("intrez le question intitulé");
			intit = scann.nextLine();
			System.out.println("intrez le question points");
			poin = Integer.parseInt(scann.nextLine());
			System.out.println("intrez le question réponse");
			rep = Integer.parseInt(scann.nextLine());
			System.out.println("intrez le réponse intervalle");
			intrev = Integer.parseInt(scann.nextLine());
			return new QuestionEntiereAvecIntervalle(intit, poin, rep, intrev);
		}
		return null;
	}

	public Quizz CreationQuizzInteractive() {
		scan = new Scanner(System.in);
		boolean interact = true;
		cloneLQ();
		// System.out.println(listeQuestionsCopy.toString());
		Quizz qui = new Quizz();
		while (interact) {
			System.out.println("Si vous souhaitez de piocher un question dans la banque choisez 1"
					+ "\n si vous souhaitez de create un nouvelles question choisez 2" + "\n pour terminer entrez 0");
			peron = scan.nextLine();
			if (peron.compareTo("1") == 0) {
				if (!listeQuestionsCopy.isEmpty()) {
					qui.setListeQuestions(pollQuestion());
				} else {
					System.out.println("Banque est vide");
				}
			} else if (peron.compareTo("2") == 0) {
				qui.setListeQuestions(createQuestion());
			} else if (peron.compareTo("0") == 0) {
				interact = false;
			}
		}
		return qui;

	}

}
