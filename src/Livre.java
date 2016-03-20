import java.util.Calendar;

public class Livre extends Document {
	private String editeur;
	private int pages;

	public Livre() {
		super();
	}

	public Livre(String titre, String auteur, Calendar parution, String cote, String editeur, int pages) {
		super(titre, auteur, parution, cote);
		this.editeur = editeur;
		this.pages = pages;
	}
}
