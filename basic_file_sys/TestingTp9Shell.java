import java.util.Arrays;
import java.util.Scanner;

public class TestingTp9Shell {

	public static void main(String[] args) {
		Dossier r = new Dossier(null);
		Dossier d = new Dossier(null);
		Dossier a = new Dossier(null);
		Dossier b = new Dossier(null);
		FichierTexte c = new FichierTexte();
		FichierTexte e = new FichierTexte();
		FichierTexte f = new FichierTexte();
		Point p = new Point(b, "f", f);
		d.ajouterEntree("a", a);
		a.ajouterEntree("c", c);
		a.ajouterEntree("b", b);
		b.ajouterEntree("e", e);
		b.ajouterEntree("f", f);
		System.out.println(a.parent.toString());
		d.afficher();
		a.afficher();
		b.afficher();
		e.afficher();
		f.afficher();
		System.out.println("  k");
		b.lireEntree("..", false).supprimer();
		System.out.println("  k");
		b.parent.afficher();
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
        String[] statement = scanner.nextLine().split(" ");
        String s = scanner1.nextLine();
        System.out.println(s + "\n*\n" + Arrays.toString(statement));
	}

}
