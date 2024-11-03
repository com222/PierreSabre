package personnages;

public class Commercant extends Humain {
	public Commercant( String nom, int argent) {
		super(nom, "thé",argent);
	}
	
	public int seFaireExtroquer() {
		int sommeExtroque = argent;
		perdreArgent(argent);
		parler("J’ai tout perdu! Le monde est trop injuste..."); 
		return sommeExtroque; 
	}
	
	public void recevoir(int argent) {
		gagnerArgent(argent); 
		parler(argent + " sous ! Je te remercie genereux donateur!");
	}
	
	public static void main(String[] args) {
		Commercant com = new Commercant("com",58);
		com.direBonjour();
	}
}