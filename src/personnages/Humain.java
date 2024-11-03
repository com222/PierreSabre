package personnages;

public class Humain {
	
	protected String nom ;
	protected String boissonFavorite ;
	protected int argent ; 
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom ;
		this.boissonFavorite = boissonFavorite ;
		this.argent = argent ;
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
	
	public String getName() {
		return nom ;
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
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " a " + prix + " sous.");
		}
		
	}
	
	public static void main(String[] args) {
		Humain humain = new Humain("nom", "boisson", 4 ); 
		humain.direBonjour();
		humain.boire();
		humain.acheter("une chose", 2);
		humain.acheter("une chose", 5);
	}
}
