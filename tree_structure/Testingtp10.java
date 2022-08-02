import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Testingtp10 {
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> inte = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			inte.add(i);
		}
		System.out.println(inte.indexOf(9));
		
		
		
		Random rand = new Random();
		System.out.println(rand.nextInt(8));
		/*File f = new File("tt.txt");
		f.createNewFile();
		Arbre a = new Arbre("ttt");
		a.afficher();*/
		/*
		File f = new File("tt.txt");
		System.out.println(f.getAbsolutePath());
		System.out.println(f.exists());
		System.out.println(f.isFile());
		//System.out.println(f.delete());
		System.out.println(f.createNewFile());
		System.out.println(f.length());
	
		 if (!f.exists()) { // It's not there!
			 System.out.println(f.getName());
		      throw new FileNotFoundException("Could not find file: " + "tt");
		    }*/

				/*try 
				{
					f.exists();
				  //This already throws FileNotFoundException
					//BufferedReader br = new BufferedReader(new FileReader("tt"));
				} 
				catch(FileNotFoundException e)
				{
				  System.out.println(e.toString());
				}*/
			

		

		//FileInputStream fis = new FileInputStream(f);
	}

}
