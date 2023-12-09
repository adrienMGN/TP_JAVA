import java.util.*;

/**
 * classe qui permet de modeliser un nombre de connexions
 * 
 */
public class Logs {
	/**
	 * attributs tableau de nombre de connexions
	 */
	private int[] connexions;

	/**
	 * attributs, nombre min, max et moyenne du tableau nbrConnexions
	 */
	private int min, max;
	private double moyenne;


	// ################ QUESTION 1 ########################

	/**
	 * constructeur ou tous les nombres de connexions mensuelles sont
	 * supposes nuls
	 * 
	 * @param n
	 *            nombre de mois d'etude (au moins 1)
	 */
	public Logs(int n) {
		if (n < 1) {
			this.connexions = new int[1];
		}
		else {
			this.connexions = new int[n];
		}
		this.max = 0;
		this.min = 0;
		this.moyenne = 0;
	}

	// ################ QUESTION 2 ########################

	/**
	 * pour l'affichage
	 * 
	 * @return chaine de caracteres representant le releve de
	 *         connexions
	 */
	public String toString() {
		String tab = "|";
		for (int i = 0; i < this.connexions.length; i++) {
			tab += this.connexions[i] + "|";
		}
		tab += "\n Max : " + this.max;
		tab += "\n Min : " + this.min;
		tab += "\n Moy : " + this.moyenne;
		return tab;
	}

	// ################ QUESTION 3 ########################

	/**
	 * methode de saisie des releves de connexions
	 */
	public void saisirConnexions() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < this.connexions.length; i++) {
			this.connexions[i] = sc.nextInt();
		}
	}

	/**
	 * methode qui met a jour les attributs min max et moyenne
	 */
	private void calculMinMaxMoy() {
		int maxi = this.connexions[0];
		int mini = this.connexions[0];
		int somme = 0;

		for (int i = 1; i < this.connexions.length; i++) {
			if (this.connexions[i] > maxi) {
				maxi = this.connexions[i];
			}
			if (this.connexions[i] < mini) {
				mini = this.connexions[i];
			}
			somme += this.connexions[i];
		}
		this.max = maxi;
		this.min = mini;
		this.moyenne = somme / connexions.length;
	}

	// ################ QUESTION 4 ########################
	
	/**
	 * permet de corriger des elements successifs du tableau de
	 * nombres de connexions mensuelles
	 * 
	 * @param mois_debut
	 *            indice de la premiere valeur a modifier
	 * @param tab
	 *            nouvelles valeurs
	 */
	public void corrigerConnexions(int mois_debut, int[] tab) {
		int j = 0;

		for (int i = mois_debut; i < tab.length + mois_debut; i++) {
			if (i < this.connexions.length) {
				this.connexions[i] = tab[j];
				j++;
			}
		}
		this.calculMinMaxMoy();
	}

	// ################ QUESTION 5 ########################

	/**
	 * permet d'inverser l'ordre des valeurs stockees dans le tableau
	 * de nombres de connexions mensuelles
	 */
	public void inverserConnexions() {
		int val = 0;
		for (int i = 0; i < this.connexions.length / 2; i++) {
			val = this.connexions[i];
			this.connexions[i] = this.connexions[this.connexions.length - 1 - i];
			this.connexions[this.connexions.length - 1 - i] = val;
		}
	}

	// ################ QUESTION 6 ########################

	/**
	 * permet de rentrer une nouvelle valeur (le nombre de connexions
	 * du dernier mois ecoule) dans le tableau, et met a jour le
	 * nombre minimum, maximum et moyen de connexions
	 * <p>
	 * la case i contient toujours le nombre de connexions mensuelles
	 * enregistre i mois auparavant
	 * 
	 * @param nv
	 *            nouvelle valeur
	 */
	public void entrerNouveauReleve(int nv) {
		int val = 0;
		int val2 = 0;
		for (int i = 0; i < this.connexions.length; i++) {
			if (i == 0) {
				val = this.connexions[i];
				this.connexions[i] = nv;
			}
			else {
				val2 = this.connexions[i];
				this.connexions[i] = val;
				val = val2;
			}
			this.calculMinMaxMoy();
		}
	}

	// ################ QUESTION 7 ########################

	/**
	 * constructeur a partir d'un tableau a 2 dimensions de taille n x
	 * 12 dont
	 * la case {[i,j]} correspond au j-ieme mois jour i-ieme.
	 * 
	 * @param tab2D
	 *            tableau a 2 dimensions
	 */
	public Logs(int[][] tab2D) {
		int somme = 0;
		this.connexions = new int[12];
		for (int i = 0; i < tab2D.length; i++) {
			somme = 0;
			for (int j = 0; j < tab2D[i].length; j++) {
				if (tab2D[i][j] != 0) {
					somme += tab2D[i][j];
				}
			}
			this.connexions[i] = somme;
		}
		this.calculMinMaxMoy();
	}

	// ################ QUESTION 8 ########################

	/**
	 * tri decroissant par selection
	 */
	public void trierDecroissantConnexions() {
		int[] t = this.connexions;
		int max = 0;
		int val = 0;
		int indice_max = 0;
		for (int i = 0; i < t.length - 2; i++) {
			max = t[i];
			indice_max = i;
			for (int j = i + 1; j < t.length - 1; j++) {
				if (t[j] > max) {
					max = t[j];
					indice_max = j;
				}
			}
			if (max > t[i]) {
				val = t[i];
				t[i] = max;
				t[indice_max] = val;
			}
		}
		this.connexions = t;
	}


	// ################ QUESTION 9 ########################

	/**	
	 * faire un tri decroissant par une methode a bulle
	 */
	public void trierDecroissantBulle() {
	}


	// ################ MAIN ########################


	/**
	 * test de nbconnexions
	 * 
	 * @param args
	 *            inutile
	 */
	public static void main(String[] args) {
		Logs nc = new Logs(8);
		nc.saisirConnexions();
		System.out.println(nc);
		nc.corrigerConnexions(2, new int[] { 54, 68, 687 });
		nc.inverserConnexions();
		System.out.println(nc);
		nc.entrerNouveauReleve(7653);
		nc.trierDecroissantConnexions();
		System.out.println(nc);
	}

	

	

	

	

	

	

	/**
	 * getter
	 * 
	 * @return le tableau de nombre de connexions
	 */
	public int[] getNbrConnexions() {
		return this.connexions;
	}

	/**
	 * getter
	 * 
	 * @return le min
	 */
	public int getMin() {
		return this.min;
	}

	/**
	 * getter
	 * 
	 * @return le max
	 */
	public int getMax() {
		return this.max;
	}

	/**
	 * getter
	 * 
	 * @return la moyenne
	 */
	public double getMoyenne() {
		return this.moyenne;
	}

	
}

/**
 * Tri décroissant par une méthode à bulle
 */
public void trierDecroissantBulle() {
	int n = connexions.length;
	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n - i - 1; j++) {
			if (connexions[j] < connexions[j + 1]) {
				// Échange les éléments
				int temp = connexions[j];
				connexions[j] = connexions[j + 1];
				connexions[j + 1] = temp;
			}
		}
	}
}


/**
 * Tri croissant
 */
public void triCroissant() {
	int n = connexions.length;
	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n - i - 1; j++) {
			if (connexions[j] > connexions[j + 1]) {
				// Échange les éléments
				int temp = connexions[j];
				connexions[j] = connexions[j + 1];
				connexions[j + 1] = temp;
			}
		}
	}
}


	public void trierCroissantConnexions() {
		int[] t = this.connexions;
		int min = 0;
		int val = 0;
		int indice_min = 0;
		for (int i = 0; i < t.length - 2; i++) {
			min = t[i];
			indice_min = i;
			for (int j = i + 1; j < t.length - 1; j++) {
				if (t[j] < min) {
					min = t[j];
					indice_min = j;
				}
			}
			if (min < t[i]) {
				val = t[i];
				t[i] = min;
				t[indice_min] = val;
			}
		}
		this.connexions = t;
	}
