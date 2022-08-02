import java.util.Scanner;


public class Joueur {
	private String nom;
	private Scanner scan =  new Scanner(System.in);
	private String reponse[];
	private int gagner = 0, perdu = 0;

	public Joueur() {
		// Par défaut, le nom du joueur est "Anonyme".
		nom = "Anonyme";
	}

	public void setNom() {
		System.out.println("Entrez votre nom :");
		nom = scan.nextLine();
	}
	public void setGagner(int n) {
		gagner = n;
	}
	public void setPerdu(int n) {
		perdu = n;
	}
	
	public String getNom() {
		return nom;
	}
	public int getGagner() {
		return gagner;
	}
	public int getPerdu() {
		return perdu;
	}

	public int nombreChoisi() {
		String reponse = scan.nextLine();
		try {
			return Integer.parseInt(reponse);
		} catch (NumberFormatException nfe) {
			System.out.println("Ce n'est pas un nombre");
		}
		return nombreChoisi();
	}
	
	public boolean ouiNon() {
		String reponse;
		while (true) {
			System.out.println("Tapez 1 pour Oui ou 0 pour Non");
			reponse = scan.nextLine();
			if (reponse.equals("1")) {
				return true;
			} else if (reponse.equals("0")) {
				return false;
			}
		}
	}
	
	public int[] actionChoisie() {
		int[] action = new int[3];
		String jouRep = scan.nextLine();
		reponse = jouRep.split("\\s+");
		 if (reponse.length == 3) {
			action[0] = (int) (reponse[0].charAt(0) - 49);
			if (action[0] < 0 || action[0] > 25) {
				System.out.println("Mauvais ligne number ");
				return actionChoisie();
			}
			action[1] = (int) (reponse[1].charAt(0) - 49);
			if (action[1] < 0 || action[1] > 25) {
				System.out.println("Mauvais colonne number ");
				return actionChoisie();
			} else {
					switch (reponse[2].toUpperCase()) {
					case "REVELER":
					case "R":
						action[2] = Plateau.REVELER;
						break;
					case "POSERDRAPEAU":
					case "P":
						action[2] = Plateau.POSERDRAPEAU;
						break;
					case "ENLEVERDRAPEAU":
					default:
						System.out.println("Mauvais type d'action : " + reponse[2]);
						break;
					}

					/*if (line[0].length() != 1) {
						System.out.println("Mauvais premier argument ++" + line[0]);
						error = true;
					} */
					/*try {
						action[0] = Integer.parseInt(line[0]) - 1;
					} catch (Exception e) {
						System.out.println("Mauvais p argument &&" + line[0]);
						error = true;
					}

					try {
						action[1] = Integer.parseInt(line[1]) - 1;
					} catch (Exception e) {
						System.out.println("Mauvais deucième argument &&" + line[1]);
						error = true;
					}*/

				}
			}
		 if(reponse.length != 3){
			 System.out.println("Mauvais nombre d'arguments : " + reponse.length);
			 actionChoisie();
		 }
			return action;
		}
}
