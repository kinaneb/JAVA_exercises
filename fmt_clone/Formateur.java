import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Formateur {
	Scanner sc;
	Scanner scm;
	LinkedList<BoiteComposite> liste;

	public Formateur(String fic) {
		sc = null;
		try {
			sc = new Scanner(new File(fic));
		} catch (Exception e) {
			System.out.println("Erreur lors d’ouverture fichier:");
			e.printStackTrace();
			System.exit(1);
		}
		liste = new LinkedList<BoiteComposite>();
	}

	private BoiteComposite readParagraphe(String l) {
		BoiteComposite b = new BoiteComposite();
		scm = new Scanner(l);
		while (scm.hasNext()) {
			b.addBoite(new BoiteMot(scm.next()));
		}
		if (!b.isEmpty()) {
			b.suite.removeLast();
		}
		return b;

	}

	public void read() {
		int nl = 2;
		while (sc.hasNextLine()) {
			BoiteMot bm = new BoiteMot("***");
			BoiteComposite b = new BoiteComposite();
			String s = sc.nextLine();
			// System.out.println(s);
			b = readParagraphe(s);
			if (!b.isEmpty()) {

				liste.add(b);

				// liste.add(bm);
				nl = 0;
			}
			if (b.isEmpty()) {
				nl++;
				if (nl == 1) {
					liste.add(b);
				}
			}

		}
	}

	public void print() {
		int n = liste.size();
		for (int i = 0; i < n; i++) {
			
			if (i == n-1) {
				if (liste.get(i).isEmpty()) {
					continue;
				}
			}
			System.out.println(liste.get(i));
		}
	}
}
