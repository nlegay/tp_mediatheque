import java.util.Calendar;
import java.util.GregorianCalendar;

public class EssaiMediatheque {

	public static void main(String[] args) {
		Mediatheque media = new Mediatheque();
		media.ajouterDocument(new Document("Le voyage", "Jean", new GregorianCalendar(1996, 11, 1), "voyage"));
		media.ajouterDocument(new Document("La rencontre", "Dupont", new GregorianCalendar(2016, 03, 17), "rencontre"));
		media.ajouterDocument(new Document("La chute", "Paul", new GregorianCalendar(2001, 06, 23), "chute"));
		System.out.println(media.rechercherCote("voyage"));
		media.ajouterDocument(new Livre("Pierre et le loup", "Pierre", new GregorianCalendar(2015, 03, 17), "pierre",
				"hachette", 100));
		media.ajouterDocument(
				new Dvd("La fosse aux lions", "Le tigre", new GregorianCalendar(2015, 03, 17), "lion", "Caillou", 120));
		media.rechercherCote("lion").emprunt(42);
		media.rechercherCote("pierre").emprunt(11);
		media.rechercherCote("chute").emprunt(11);
		media.afficherEmprunts();

		Calendar date = media.rechercherCote("lion").dateRetour();
		System.out.println(
				date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.YEAR));
		System.out.println("Les documents en retard : ");
		for (Document doc : media.docs)
			if (!doc.estLibre())
				if (doc.dateRetour().compareTo(new GregorianCalendar()) < 0)
					System.out.println(doc);
	}

}
