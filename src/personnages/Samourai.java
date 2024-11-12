package personnages;

public class Samourai extends Ronin{
	private String seigneur ;
	public Samourai( String seigneur, String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite,argent);
		this.seigneur = seigneur; 
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Je suis fier de servir le seigneur " + seigneur +".");
	}
	
	public static void main(String[] args) {
		Samourai akimoto = new Samourai("Miyamoto", "Akimoto", "sak�", 80);
		akimoto.direBonjour();
	}
}
