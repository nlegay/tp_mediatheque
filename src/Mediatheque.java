import java.util.List;
import java.util.ArrayList;

public class Mediatheque {
	List<Document> docs = new ArrayList<>();

	public Mediatheque() {

	}

	public void ajouterDocument(Document document) {
		docs.add(document);
	}

	public Document rechercherCote(String cote) {
		for (Document doc : docs) {
			if (doc.aPourCote(cote))
				return doc;
		}
		return null;
	}

	public void afficherEmprunts() {
		for (Document doc : docs)
			if (!doc.estLibre())
				System.out.print(doc);
	}

	public boolean emprunter(String cote, int emprunteur) {
		if (this.rechercherCote(cote) != null) {
			return this.rechercherCote(cote).emprunt(emprunteur);
		}
		return false;
	}

	public boolean restituer(String cote) {
		if (this.rechercherCote(cote) != null) {
			return this.rechercherCote(cote).restitution();
		}
		return false;
	}
}
