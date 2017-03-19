


public class Joueur{
	
	private String nom;
    private Personnage perso;
    
    public Joueur(String nom){
        this.nom = nom;
        perso = null;
    }
    
    public String getNom(){
		return nom;
	}
    
    public void setPersonnage(String nomImage){
        perso = new Personnage(nomImage);
    }
		
	
}

