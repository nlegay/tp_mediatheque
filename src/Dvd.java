import java.util.Calendar;

public class Dvd extends Document {
	private String producteur;
	private int duree;

	public Dvd() {
		super();
	}

	public Dvd(String titre, String auteur, Calendar parution, String cote, String producteur, int duree) {
		super(titre, auteur, parution, cote);
		this.producteur = producteur;
		this.duree = duree;
	}

}
