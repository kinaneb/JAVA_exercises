
public class Plateau {
	int joueurVue = 0;
	// Plateau is a table of trous
	Trou[] trous = new Trou[14];
	//constructor
	public Plateau(){
		for (int i = 0; i < 14 ;i++){
			if (i > 6){ 
				joueurVue = 1;
				}
			if ((i == 6)||(i == 13)){
				trous[i] = new Trou(0, joueurVue);
			}
			else{
				trous[i] = new Trou(4, joueurVue);
			}
		}
		joueurVue = 0;
	}
	public int grainesCase(int c){
		return trous[c].graines;
	}
	
}
