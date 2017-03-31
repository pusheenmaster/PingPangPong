
public class LesScores {
	
	private String[][] lesScores = new String[5][2];
	
	public LesScores() {
		for(int i=0;i<lesScores.length;i++){
			lesScores[i][0] = null;
			lesScores[i][1] = "";
	
		}
	}
	
	/** la classe score est inutile*/
	
	public String[][] getLesScores(){
		return lesScores;
	}
	
	public void ajouterScore(String nom, int s){
		
		// si aucun score n'est present dans le tableau
		if(lesScores[0][0] == null/* || Integer.parseInt(lesScores[0][1]) < s*/){
			lesScores[0][0] = nom;
			lesScores[0][1] += s;
		}
		// nouveau score en derniere position
		else if(lesScores[4][0] !=null && Integer.parseInt(lesScores[4][1]) < s){
			lesScores[4][0] = nom;
			lesScores[4][1] = "" + s;
		}
		else{
			for(int i=lesScores.length-2 ; i >= 0 ; i--){
				if(lesScores[i][0]!=null){ 
					if(Integer.parseInt(lesScores[i][1]) < s){
						lesScores[i+1] = lesScores[i];
						lesScores[i][0] = nom;
						lesScores[i][1] = "" + s;
					}
				}else if(i!=0 && lesScores[i-1][0]!=null){
					lesScores[i][0] = nom;
					lesScores[i][1] = "" + s;
				}
			}
		}
		
	}
}

