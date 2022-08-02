
public class testingtp7 {

	public static void main(String[] args) {
		/*ArrayList<Integer> t = new ArrayList<Integer>(15);
		int n = 10;
		Random rand = new Random();
			for(int i = 0; i < n;i++) {
				 t.add(rand.nextInt(n));
			}
			if ( (t.get(3)).compareTo(t.get(4)) > 0) {
				System.out.println("t " + t.get(3) +" "+ t.get(4)+ (t.get(3)).compareTo(t.get(4)));
			} else
				System.out.println("tt "+ t.get(3) +" "+ t.get(4)+(t.get(3)).compareTo(t.get(4)) );
		*/
		int[] n = {5, 0, 1, 3, 8, 7, 7, 3, 4 ,2};
		EntierTriable rn = new EntierTriable(n);
		System.out.println(rn);
		Triable.triBulles(rn);
		System.out.println(rn);
		String [] s = {"e","a","kinan","mais","kinda","rima"};
		Dictionnaire d = new Dictionnaire(s);
		System.out.println(d);
		Triable.triBulles(d);
		System.out.println(d);
		Triangle t = new Triangle(0, 0, 1, 1);
		t.affiche();
		Carre c = new Carre(0, 0, 2);
		c.affiche();
		t.deformation(2, 4).affiche();
		c.deformation(2, 4).affiche();
		/*Carre c3 = new Carre(0, 0, 3);
		Carre c4 = new Carre(0, 0, 4);
		Carre c5 = new Carre(0, 0, 5);
		Carre c6 = new Carre(0, 0, 6);
		
		//t.affiche();
		//c.affiche();
		FigueTriable ft = new FigueTriable();
		
		ft.t.add(c);
		ft.t.add(c3);
		ft.t.add(c4);
		ft.t.add(t);
		ft.t.add(c5);
		ft.t.add(c6);
		
		//System.out.println(ft.t);
		Triable.triBulles(ft);
		ft.affiche();*/
		

	}

}
