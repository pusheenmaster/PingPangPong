


public class Joueur{
	
	private String nom;
    private Personnage perso;
    
    public Joueur(String nom){
        this.nom = nom;
        perso = null;
    }
    
    public Joueur(String nom, Personnage perso){
        this.nom = nom;
        this.perso = perso;
    }
    
    public String getNom(){
		return nom;
	}
    
    public void setPersonnage(String nomImage){
        perso = new Personnage(nomImage);
    }
		
	
}


