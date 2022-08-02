import java.util.LinkedList;
import java.util.Scanner;

public class testingTp6 {

	public static void main(String[] args) {

		/*
		 * String s = "TEST test   \n rrr \n   t  "; Scanner sc = new Scanner(s); // scc
		 * = new Scanner(""); LinkedList<Boite> suite = new LinkedList(); //
		 * System.out.println(suite.size()); while (sc.hasNextLine()) { Scanner scc =
		 * new Scanner(sc.nextLine());
		 * 
		 * while (scc.hasNext()) { System.out.println(scc.next()); } }
		 */
		Formateur f = new Formateur("videBis");
		f.read();
		f.print();
		int n =0;
		for(BoiteComposite b : f.liste) {
			n+=b.length();
		}
		System.out.println(n);

	}

}
/*
 public void print() {
		int nl = 0;
		for (BoiteComposite b : liste) {
			for (Boite bb : b.suite) {
				if (bb instanceof BoiteEspace) {
					System.out.println("****");
					
				}

				System.out.println(bb);
			}
		}
	}
	
	public void read() {
		int nl = 0;
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
					b.addBoite(bm);
					liste.add(b);
				}
			}

		}
	}
	
	
 * */
 