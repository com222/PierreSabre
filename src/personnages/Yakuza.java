package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}

	public String getClan() {
		return clan;
	}

	public int getReputation() {
		return reputation;
	}

	public void extroquer(Commercant victime) {
		int argentVole;
		reputation++;
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par la ?");
		parler(victime.getNom() + ", si tu tiens a la vie donne moi ta bourse !");
		argentVole = victime.seFaireExtroquer();
		gagnerArgent(argentVole);
		parler("J'ai pique les " + argentVole + " sous de " + victime.getNom() + ", ce qui me fait " + getArgent()
				+ " sous dans ma poche. Hi ! Hi !");
	}

	public int perdre() {
		int perte = getArgent();
		perdreArgent(perte);
		reputation--;
		parler("J'ai perdu mon duel et mes " + perte + " sous, snif... J'ai desonore le clan de " + getClan() + ".");
		return perte;
	}

	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation++;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + getClan()
				+ "? Je l'ai depouille de ses " + gain + " sous.");
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan);

	}

	public static void main(String[] args) {
		Yakuza ya = new Yakuza("ya", "boisson", 10000, "el clan");
		ya.direBonjour();
		Commercant com = new Commercant("com", 58);
		ya.extroquer(com);
		ya.perdre();
		ya.gagner(6);
	}
}
