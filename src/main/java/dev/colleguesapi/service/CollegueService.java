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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.colleguesapi.entite.Collegue;
import dev.colleguesapi.exception.CollegueInvalidException;
import dev.colleguesapi.exception.CollegueNotFoundException;
import dev.colleguesapi.repository.CollegueRepository;

@Service
public class CollegueService {


	final String TIME_PATTERN = "yyyy-MM-d";
	LocalDate date1 = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));
	LocalDate date2 = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));
	LocalDate date3 = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));


	
	public List<Collegue> rechercherParNom(String nomRecherche)
	{
		return colRepo.findAll().stream().filter(t -> t.getNom().equals(nomRecherche)).collect(Collectors.toList());
	}

	public Collegue rechercherParMatricule(String matriculeRecherche) throws CollegueNotFoundException
	{
		return (colRepo.findById(matriculeRecherche).orElseThrow(CollegueNotFoundException::new));
	}

	@Autowired
	CollegueRepository colRepo;

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
		colRepo.save(collegueAAjouter);
		return collegueAAjouter;
	}

	public Collegue modifierEmail(String matricule, String email)
	{
			Collegue collegue = colRepo.findById(matricule).orElseThrow(CollegueNotFoundException::new);

		if (email.length() <= 3)
		{
			throw new CollegueInvalidException("Email invalide, trop court (3 caractères minimums)");
		}

		if (!email.contains("@"))
		{
			throw new CollegueInvalidException("Email invalide, doit contenir un @");
		}

		collegue.setEmail(email);
		colRepo.save(collegue);
		return collegue;
	}

	public Collegue modifierPhotoUrl(String matricule, String photoUrl)
	{
		

		Collegue collegue = colRepo.findById(matricule).orElseThrow(CollegueNotFoundException::new);

		if (!photoUrl.contains("http"))
		{
			throw new CollegueInvalidException(
					"Url de la photo invalide, doit contenir au moins http en début de lien");
		}

		collegue.setPhotoUrl(photoUrl);
		colRepo.save(collegue);
		
		return collegue;
	}

	public CollegueRepository getColRepo() {
		return colRepo;
	}

	public void setColRepo(CollegueRepository colRepo) {
		this.colRepo = colRepo;
	}



}

