


public class Joueur{
	
    private String nom;
    private Personnage perso;
    
    /**Constructeur de Joueur
    *@param nom (String)
    **/
    public Joueur(String nom){
        this.nom = nom;
        perso = null;
    }
    
    /**Constructeur de Joueur
    *@param nom (String), perso (Personnage)
    **/
    public Joueur(String nom, Personnage perso){
        this.nom = nom;
        this.perso = perso;
    }
    
    /**la méthode setPerso(perso) instancie le personnage
    *@param perso (Personnage)
    **/	
    public void setPerso(Personnage perso){
		this.perso=perso;
	}

   /**la méthode setNom(nom) instancie le nom
   *@param nom (String)
   **/	
   public void setNom(String nom){
		this.nom=nom;
	}


   /**la méthode getPerso() retourne le personnage
   *@return perso (Personnage)
   **/	
    public Personnage getPerso(){
		return perso;
	}
    

   /**la méthode getNom() retourne le nom
   *@return nom (String)
   **/	
    public String getNom(){
		return nom;
	}
}

