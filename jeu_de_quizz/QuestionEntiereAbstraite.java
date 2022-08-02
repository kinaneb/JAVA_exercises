//import java.util.Scanner;

public abstract class QuestionEntiereAbstraite extends Question {
	private final int reponse;
	//private Scanner scan = new Scanner(System.in);
	public QuestionEntiereAbstraite(String intit, int poin, int rep) {
		super(intit, poin);
		this.reponse = rep;
	}
	public int getIntReponse() {
		return this.reponse;
	}
	@Override
	public boolean estCorrecte(String reponseFournie) {
		try{
	        int r = Integer.parseInt(reponseFournie);
	        return estCorrecte(r);
	        
		}
	    catch(NumberFormatException e){
	    	System.out.println("votre réponse doit être un entier");
	    	
	    }
		return false;
	}

	public abstract boolean estCorrecte(int i);

}
