


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
    
    public void setPerso(Personnage perso){
		this.perso=perso;
	}
	
	public void setNom(String nom){
		this.nom=nom;
	}
	
    public Personnage getPerso(){
		return perso;
	}
    
    public String getNom(){
		return nom;
	}
}

