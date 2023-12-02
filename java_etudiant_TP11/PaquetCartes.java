public class PaquetCartes { 

 private Carte [] paquetCartes;


 /**constructeur vide 
  * 
  */
 
 public PaquetCartes(){

    this.paquetCartes = new Carte [0];

 }

 /**
  * constructeur
  * @param cartes Carte []
  */

 public PaquetCartes(Carte [] paquet){

    this.paquetCartes = paquet;

 }

 /**
  * méthode getNbCartes
  * 
  */
 public int getNbCartes() {
    return this.paquetCartes.length;

 }

/** 
 * méthode getCarte
 * @param place int
 */

 public Carte getCarte(int place){


    Carte res;
    if (place < this.paquetCartes.length)
    {
        res = this.paquetCartes[place];
    } else {
        res = null;
    }
    return res;
}

    /**
     * Méthode ajouterCarteFin 
     * 
     * @param carte Carte
     * 
     * 1. créer un nouveau tableau de taille sup ́erieure ;
     * 2. y recopier les objets cartes de l’attribut cartes ;
     * 3. ajouter dans la case suppl ́ementaire la carte `a ajouter ;
     * 4. modifier les r ́ef ́erences pour que l’attribut cartes soit  ́egal `a ce nouveau tableau
     * 
     */

public void ajouterCarteFin(Carte carte){

    Carte [] nouvPaquetCartes = new Carte [this.paquetCartes.length + 1 ];
    for (int i = 0; i < this.paquetCartes.length; i++) {
        nouvPaquetCartes[i] = this.paquetCartes[i];
    }
    nouvPaquetCartes[nouvPaquetCartes.length - 1] = carte;
    this.paquetCartes = nouvPaquetCartes;
}


    /**
     * ajoute une carte au debut du paquet
     * @param carte Carte à ajouter au debut du paquet
     */
    public void ajouterCarteDebut(Carte carte) {
        Carte[] newCartes = new Carte[this.paquetCartes.length + 1];
        newCartes[0] = carte;
        for (int i = 0; i < this.paquetCartes.length; i++) {
            newCartes[i + 1] = this.paquetCartes[i];
        }
        this.paquetCartes = newCartes;
    }






/** 1 récupérer le tableau de cartes et sa taille
 * créer un tab de taille inf
 * boucle dans le tab ajouter l'elmt i dans le nouveau sauf lorsque i = place
 * 
 * méthode reirerCarte
 * @param place int
 * 
 * 
 */

    /**
     * retire une carte du paquet
     * @param place position de la carte a retirer
     * @return la carte retiree
     */

    public Carte retirerCarte(int place) {
/** condition à remplir sinon null */
        if (place >= this.paquetCartes.length || place < 0 || this.paquetCartes.length == 0) {
            return null;
        }

        Carte[] newCartes = new Carte[this.paquetCartes.length - 1];
        Carte carteSupp = this.paquetCartes[place];
        for (int i = 0; i < this.paquetCartes.length; i++) {
            if (i < place) {
                newCartes[i] = this.paquetCartes[i];
            } else if (i > place) {
                newCartes[i - 1] = this.paquetCartes[i];
            }
        }
        this.paquetCartes = newCartes;
        return carteSupp;
    }

     /**
     * affiche le paquet de cartes
     * @return une chaine de caracteres representant le paquet de cartes
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--------------------------\n");
        for (int i = 0; i < this.cartes.length; i++) {
            sb.append(i).append(". ").append(this.cartes[i].toString()).append("\n");
        }
        sb.append("--------------------------");
        return sb.toString();
    }


}