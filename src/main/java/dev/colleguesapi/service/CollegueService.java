package dev.colleguesapi.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.colleguesapi.entite.Collegue;
import exception.CollegueInvalidException;
import exception.CollegueNotFoundException;

@Service
public class CollegueService {

	private Map<String, Collegue> data = new HashMap<>();

	final String TIME_PATTERN = "yyyy-MM-d";
	LocalDate date1 = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));
	LocalDate date2 = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));
	LocalDate date3 = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));


	public CollegueService() {

		String matriculeTemp = UUID.randomUUID().toString();
		LocalDate date1 = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));

		data.put(matriculeTemp,	new Collegue(matriculeTemp, "GUY", "John", "mail.mail@mail.com", "url", date1));
		matriculeTemp = UUID.randomUUID().toString();
		data.put(matriculeTemp,	new Collegue(matriculeTemp, "ROBERT", "Pier", "mail.mail@mail.com", "url", date1));
		matriculeTemp = UUID.randomUUID().toString();
		data.put(matriculeTemp,	new Collegue(matriculeTemp, "JEAN", "Jak", "mail.mail@mail.com", "url", date1));
		data.put("1", new Collegue("1", "PHILIPPE", "Albert", "mail.mail@mail.com", "url", date1));
	}



	public List<Collegue> rechercherParNom(String nomRecherche)
	{
		return data.values().stream().filter(t -> t.getNom().equals(nomRecherche)).collect(Collectors.toList());
	}

	public Collegue rechercherParMatricule(String matriculeRecherche) throws CollegueNotFoundException
	{
		return Optional.ofNullable(data.get(matriculeRecherche)).orElseThrow(CollegueNotFoundException::new);
	}

	public Collegue ajouterCollegue(Collegue collegueAAjouter) throws CollegueInvalidException {

		if (collegueAAjouter.getNom().length() <= 2) {

			throw new CollegueInvalidException("Nom invalide trop court (2 Caracteres minimum)");
		}

		if (collegueAAjouter.getPrenom().length() <= 2) {

			throw new CollegueInvalidException("Prénom invalide trop court  (2 Caracteres minimum)");
		}


		if (collegueAAjouter.getEmail().length() <= 3) {

			throw new CollegueInvalidException("Nom invalide trop court (3 Caracteres minimum)");

		}

		if (!collegueAAjouter.getEmail().contains("@")) {

			throw new CollegueInvalidException("METTEZ UN AROBASE (@)");

		}


		if (!collegueAAjouter.getPhotoUrl().contains("http"))
		{
			throw new CollegueInvalidException(	"Mettre HTTP pour votre photo");

		}


		LocalDate majeur = LocalDate.now();
		Period period = Period.between(collegueAAjouter.getDateDeNassaince(), majeur);
		if (period.getYears() < 18)
		{
			throw new CollegueInvalidException("Vous devez être majeur pour vous inscrire");
		}


		collegueAAjouter.setMatricule(UUID.randomUUID().toString());
		data.put(collegueAAjouter.getMatricule(), collegueAAjouter);
		return collegueAAjouter;
	}

	public Collegue modifierEmail(String matricule, String email)
	{
		if (!data.containsKey(matricule))
		{
			throw new CollegueNotFoundException();
		}

		Collegue collegue = data.get(matricule);

		if (email.length() <= 3)
		{
			throw new CollegueInvalidException("Email invalide, trop court (3 caractères minimums)");
		}

		if (!email.contains("@"))
		{
			throw new CollegueInvalidException("Email invalide, doit contenir un @");
		}

		collegue.setEmail(email);
		data.put(matricule, collegue);

		return collegue;
	}

	public Collegue modifierPhotoUrl(String matricule, String photoUrl)
	{
		if (!data.containsKey(matricule))
		{
			throw new CollegueNotFoundException();
		}

		Collegue collegue = data.get(matricule);

		if (!photoUrl.contains("http"))
		{
			throw new CollegueInvalidException(
					"Url de la photo invalide, doit contenir au moins http en début de lien");
		}

		collegue.setPhotoUrl(photoUrl);
		data.put(matricule, collegue);

		return collegue;
	}

}

