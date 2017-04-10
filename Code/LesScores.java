
public class LesScores {
	
	private String[][] lesScores = new String[5][2];
	
        /**constructeur de LesScores() remplit le tableau de scores par des cases vides
        **/	
	public LesScores() {
		for(int i=0;i<lesScores.length;i++){
			lesScores[i][0] = null;
			lesScores[i][1] = "";
	
		}
	}
	
        /**la méthode getLesScores() retourne les scores
	*@return lesScores (String[][])
        **/	
	public String[][] getLesScores(){
		return lesScores;
	}
	
        /**la méthode ajouterScores() ajoute le nouveau score au tableau en classant les 5 meilleurs
	*@param nom (String), s (int)
        **/
	public void ajouterScore(String nom, int s){
		// si aucun score n'est present dans le tableau
		if(lesScores[0][0] == null){
			lesScores[0][0] = nom;
			lesScores[0][1] += s;
		}
		// nouveau score en derniere position
		else if(lesScores[4][0]==null && lesScores[3][0]!=null && Integer.parseInt(lesScores[3][1]) >= s){
			lesScores[4][0] = nom;
			lesScores[4][1] = "" + s;
		}else{
			for(int i=lesScores.length-2 ; i >= 0 ; i--){
				if(lesScores[i][0]!=null){ 
					if(Integer.parseInt(lesScores[i][1]) < s){
						lesScores[i+1][0] = lesScores[i][0];
						lesScores[i+1][1] = lesScores[i][1];
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
