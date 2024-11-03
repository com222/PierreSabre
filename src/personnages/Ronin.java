package personnages;

public class Ronin extends Humain {
	private int honneur = 1;
	
	public Ronin( String nom,String boissonFavorite, int argent) {
		super(nom, boissonFavorite,argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = argent / 10;
		argent -= don;
		parler(beneficiaire.getName() + " prend ces " + don + " sous.");
		beneficiaire.recevoir(don);
	}
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if ((honneur * 4) >= adversaire.getReputation()) {
			parler("Je t’ai eu petit yakusa!");
			gagnerArgent(adversaire.perdre()); 
		} else {
			honneur -= 1;
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup");
			adversaire.gagner(argent);
			perdreArgent(argent); 
		}
	}
	
	public static void main(String[] args) {
		Ronin ro = new Ronin ("nom","boisson",45);
		ro.direBonjour();
		Commercant com = new Commercant("nom",10); 
		ro.donner(com);
	}
}