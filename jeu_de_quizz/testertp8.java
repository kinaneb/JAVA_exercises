import java.util.LinkedList;
import java.util.Scanner;
public class testertp8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*String s = "TEST ";
		String t = "test ";
		System.out.println(s.compareToIgnoreCase(t));*/
		QuestionChaine q = new QuestionChaine("What", 3, "is");
		QuestionEntiereSansIntervalle q1 = new QuestionEntiereSansIntervalle("q sans interv", 1, 1);
		QuestionEntiereAvecIntervalle q2 = new QuestionEntiereAvecIntervalle("q avec interv", 2, 1, 1);
		QCM q3 = new QCM("QCM", 4);
		q3.setReponse("1");
		//q3.setReponse("2");
		q3.setBonReponse("2");
		q3.setReponse("3");
		q3.setReponse("1");
		q3.setReponse("4");
		
		/*Quizz qq = new Quizz(4);
		qq.setListeQuestions(q2);
		qq.setListeQuestions(q);
		qq.setListeQuestions(q1);
		qq.setListeQuestions(q3);
		
		
		qq.pose();*/
		/*String n = "33";
		int i = Integer.parseInt(n);
		System.out.println(i);
		System.out.println("h");
		if (scan.nextLine().compareTo("2") == 0) {
		System.out.println("h");
		}*/
		Quizz qq = new Quizz();
		Banque b = new Banque();
		b.ajouterQ(q);
		b.ajouterQ(q1);
		b.ajouterQ(q2);
		b.ajouterQ(q3);
		qq = b.CreationQuizzInteractive();
		qq.pose();
		
		

	}

}
