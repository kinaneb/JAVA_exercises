import java.util.Scanner;

public class TestingTp9Finalisation {
	private static Scanner scan = new Scanner(System.in);

	public static int nomRep() {
		System.out.println("combien de gros objets vous voulez créer ?");

		try {
			return Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("votre réponse doit être un entier");

		}

		return nomRep();
	}

	/*
	 * EX: 1 , 3) pour qu'ils puissent être désavoué par Java avant la fin du
	 * programme il fout qu'on crée des nombre d'objet assez pour qu'ils remplissent
	 * tout l'ecpace reservée pour JVM dans le Tas
	 */
	public static void main(String[] args) {
		int n = nomRep();
		for (int i = 0; i < n; i++) {
			new GrosObjet();
		}

	}

	/*
	 * EX: 1 , 4) après plusieur execution j'ai choisi de crée 20 objets est comme
	 * la resulta en bas les object ne finalisés pas regulierment; 
	 * mais oui dans l'order (8 aprés 17 aprés 18); 
	 * non, tous les objets ne sont pas finalisés à la sortie du programme
	 */

	// com combien de gros objets vous voulez créer ?
	// 20
	// 1 2 3 4 5 6 7 8 finalize... 8
	// finalize... 8
	// finalize... 8
	// finalize... 8
	// finalize... 8
	// finalize... 8
	// finalize... 8
	// finalize... 8
	// 9 10 11 12 13 14 15 16 17 finalize... 17
	// finalize... 17
	// finalize... 17
	// finalize... 17
	// finalize... 17
	// finalize... 17
	// finalize... 18
	// 18 finalize... 18
	// 19 20

}
