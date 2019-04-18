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

import dev.colleguesapi.entite.Collegue;
import exception.CollegueInvalidException;
import exception.CollegueNotFoundException;

public class CollegueService {
	
	final String TIME_PATTERN = "yyyy-MM-d";
	LocalDate date1 = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));
	LocalDate date2 = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));
	LocalDate date3 = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));

	
	private Map<String, Collegue> data = new HashMap<>();

	public CollegueService() {

		this.ajouterCollegue(new Collegue("Guy", "Robert", "mail@mail.com", date1, "photo" ));

		this.ajouterCollegue(new Collegue("Dede", "Noelle", "mail@mail.com", date2, "photo"));
		
		this.ajouterCollegue(new Collegue("Robert", "Arthur", "mail@mail.com", date3, "photo"));
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

        // TODO Vérifier que le nom et les prenoms ont chacun au moins 2 caractères
		if (collegueAAjouter.getNom().length() <= 2) {
			
			throw new CollegueInvalidException("Nom invalide trop court (2 Caracteres minimum)");
		}
			
	if (collegueAAjouter.getPrenom().length() <= 2) {
			
			throw new CollegueInvalidException("Prénom invalide trop court  (2 Caracteres minimum)");
		}
			
	    // TODO Vérifier que l'email a au moins 3 caractères et contient `@`
			
			if (collegueAAjouter.getEmail().length() <= 3) {
				
				throw new CollegueInvalidException("Nom invalide trop court  (3 Caracteres minimum)");
				
			}
			
			if (collegueAAjouter.getEmail().contains("@")) {
				
				throw new CollegueInvalidException("METTEZ UN AROBASE M'ENFIN (@@@@)");
				
			}
			
			
	    // TODO Vérifier que la photoUrl commence bien par `http`
			if (!collegueAAjouter.getPhotoUrl().contains("http"))
			{
				throw new CollegueInvalidException(	"Mettre HTTP pour votre photo");
				
			}
		
				
	    // TODO Vérifier que la date de naissance correspond à un age >= 18
			LocalDate majeur = LocalDate.now();
			Period period = Period.between(collegueAAjouter.getDateDeNassaince(), majeur);
			if (period.getYears() < 18)
			{
				throw new CollegueInvalidException("Vous devez être majeur pour vous inscrire");
	}
	

	
	    // TODO Si une des règles ci-dessus n'est pas valide, générer une exception :
			
			
		collegueAAjouter.setMatricule(UUID.randomUUID().toString());
		data.put(collegueAAjouter.getMatricule(), collegueAAjouter);
		return collegueAAjouter;
	}

}

