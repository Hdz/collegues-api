package dev.colleguesapi.service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import dev.colleguesapi.entite.Collegue;
import exception.CollegueInvalidException;
import exception.CollegueNotFoundException;

public class CollegueServiceTest {

	CollegueService collegueService = new CollegueService();
	static String nomValide="Guy";
	static String prenomValide="Robert";
	static String emailValide="mail@mail.com";
	static String photoUrlValide = "photo";
	
	final static String TIME_PATTERN = "yyyy-MM-d";
	static LocalDate ddnvalide = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));
	static String matricule = "1";
	
	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_NomTropCourt()
	{
		collegueService.ajouterCollegue(
				new Collegue("a", prenomValide, emailValide, ddnvalide, photoUrlValide));
	}

	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_PrenomTropCourt()
	{
		collegueService.ajouterCollegue(
				new Collegue(nomValide, "b", emailValide, ddnvalide, photoUrlValide));
	}

	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_EmailTropCourt()
	{
		collegueService.ajouterCollegue(
				new Collegue(nomValide, prenomValide, "a@", ddnvalide, photoUrlValide));
	}

	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_EmailSansArobase()
	{
		collegueService.ajouterCollegue(
				new Collegue(nomValide, prenomValide, "arthur.com", ddnvalide, photoUrlValide));
	}

	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_photoUrlSansHttp()
	{
		collegueService.ajouterCollegue(
				new Collegue(nomValide, prenomValide, emailValide, ddnvalide, "photo.com"));
	}

	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_pasMajeur()
	{
		collegueService.ajouterCollegue(
				new Collegue(nomValide, prenomValide, emailValide, LocalDate.now(), photoUrlValide));
}
	
}
