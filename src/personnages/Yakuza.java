package personnages;

public class Yakuza extends Humain {
	private String clan ;
	private int reputation = 0;
	
	public Yakuza( String nom,String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite,argent);
		this.clan = clan ;
	}
	
	public String getClan() {
		return clan; 
	}
	
	public int getReputation() {
		return reputation; 
	}
	
	public void extroquer(Commercant victime) {
		int argentVole; 
		reputation += 1; 
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getName() + ", si tu tiens à la vie donne moi ta bourse !");
		argentVole = victime.seFaireExtroquer(); 
		gagnerArgent(argentVole);
		parler("J’ai piqué les " + argentVole + " sous de " + victime.getName() + ", ce qui me fait " + argent + " sous dans ma poche. Hi ! Hi !");
	}
	
	public int perdre() {
		int perte = argent;
		perdreArgent(argent);
		reputation = Math.max(0, (reputation - 1)); 
		parler("J’ai perdu mon duel et mes " + perte + " sous, snif... J'ai déshonoré le clan de " + getClan() + "."); 
		return perte; 
	}
	
	public void gagner(int gain) {
		argent += gain;
		reputation += 1;
		parler("Ce ronin pensait vraiment battre " + getName() +" du clan de " + getClan() + "? Je l'ai dépouillé de ses " + gain + " sous.");
	}
	
	public static void main(String[] args) {
		Yakuza ya = new Yakuza ("ya","boisson",10000,"el clan");
		ya.direBonjour();
		Commercant com = new Commercant("com",58);
		ya.extroquer(com);
		ya.perdre(); 
		ya.gagner(6);
	}
}
