package personnages;

public class Humain {
	
	private String nom ;
	protected String boissonFavorite ;
	private int argent ; 
	protected int nbConnaissance = 0;
	private String [] memoire = new String[30];
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom ;
		this.boissonFavorite = boissonFavorite ;
		this.argent = argent ;
	}
	
	public String getNom() {
		return nom ;
	}
	
	public int getArgent() {
		return argent; 
	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
	protected void gagnerArgent(int gain) {
		argent += gain ; 
	}
	
	protected void perdreArgent(int perte) {
		argent -= perte ; 
	}
	
	private void memoriser(Humain humain) {
		if (nbConnaissance == 30 ) {
			for (int i = 1; i < memoire.length; i++) {
				memoire[i-1] = memoire[i];
			}
			nbConnaissance = 29;
		}
		memoire[nbConnaissance] = humain.getNom(); 
		nbConnaissance ++ ;
	}
	
	private void repondre(Humain humain) {
		humain.direBonjour();
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'apelle " + nom + " et j'aime boire du " + boissonFavorite + "."); 
	}
	
	public void boire() {
		parler("Hmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !"); 
	}
	
	public void acheter(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " a " + prix + " sous.");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux meme pas m'offrir " + bien + " a " + prix + " sous.");
		}
		
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		repondre(humain);
		memoriser(humain);
		humain.memoriser(this);
	}
	
	public void listerConnaissance() {
		StringBuilder connaissance = new StringBuilder();
		for (int i = 0; i < nbConnaissance; i++) {
			connaissance.append(" " + memoire[i]) ;
			if ( i+1 != nbConnaissance) {
				connaissance.append(",") ;
			}
		}
		String c = connaissance.toString();
		parler("Je connais beaucoup de monde dont :" + c); 
	}
	
	
	
	public static void main(String[] args) {
		Humain humain = new Humain("nom", "boisson", 4 ); 
		humain.direBonjour();
		humain.boire();
		humain.acheter("une chose", 2);
		humain.acheter("une chose", 5);
		Humain hum = new Humain ("hum","boisson",4);
		humain.faireConnaissanceAvec(hum);
		humain.listerConnaissance();
	}
}
