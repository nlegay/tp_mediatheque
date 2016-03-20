import java.util.Calendar;
import java.util.GregorianCalendar;

public class Document {
	private String titre;
	private String auteur;
	private Calendar parution;
	private String cote;
	private int emprunteur = -1;
	private GregorianCalendar dateEmprunt;

	public Document() {
	}

	public Document(String titre, String auteur, Calendar parution, String cote) {
		this.titre = titre;
		this.auteur = auteur;
		this.parution = parution;
		this.cote = cote;
	}

	public int dureeEmprunt() {
		if (this instanceof Livre)
			return 15;
		return 5;
	}

	public GregorianCalendar dateRetour() {
		GregorianCalendar dateCopie = (GregorianCalendar) dateEmprunt.clone();
		dateCopie.add(Calendar.DAY_OF_MONTH, this.dureeEmprunt());
		return dateCopie;
	}

	public boolean emprunt(int emprunteur) {
		if (this.emprunteur < 0) {
			this.emprunteur = emprunteur;
			dateEmprunt = new GregorianCalendar();
			dateEmprunt.add(Calendar.DAY_OF_MONTH, -6);
			return true;
		}
		return false;
	}

	public boolean restitution() {
		if (this.emprunteur > 0) {
			this.emprunteur = -1;
			dateEmprunt = null;
			return true;
		}
		return false;
	}

	public boolean estLibre() {
		if (emprunteur < 0)
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result + ((cote == null) ? 0 : cote.hashCode());
		result = prime * result + ((parution == null) ? 0 : parution.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (auteur == null) {
			if (other.auteur != null)
				return false;
		} else if (!auteur.equals(other.auteur))
			return false;
		if (cote == null) {
			if (other.cote != null)
				return false;
		} else if (!cote.equals(other.cote))
			return false;
		if (parution == null) {
			if (other.parution != null)
				return false;
		} else if (!parution.equals(other.parution))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Calendar getParution() {
		return parution;
	}

	public void setParution(Calendar parution) {
		this.parution = parution;
	}

	public String getCote() {
		return cote;
	}

	public void setCote(String cote) {
		this.cote = cote;
	}

	public boolean aPourCote(String cote) {
		return this.cote == cote;
	}

	@Override
	public String toString() {
		return "Document [titre=" + titre + ", auteur=" + auteur + ", parution=" + parution.get(Calendar.DAY_OF_MONTH)
				+ "/" + (parution.get(Calendar.MONTH) + 1) + "/" + parution.get(Calendar.YEAR) + ", cote=" + cote + "]";
	}

}
