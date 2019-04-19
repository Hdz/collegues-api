package dev.colleguesapi.service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import dev.colleguesapi.entite.Collegue;
import dev.colleguesapi.exception.CollegueInvalidException;
import dev.colleguesapi.exception.CollegueNotFoundException;
import dev.colleguesapi.repository.CollegueRepository;

public class CollegueServiceTest {
	CollegueRepository mockedRepository = Mockito.mock(CollegueRepository.class);
	CollegueService collegueService = new CollegueService();
	static String nomValide="GUY";
	static String prenomValide="Robert";
	static String emailValide="mail@mail.com";
	static String photoUrlValide = "http://nophoto.com";
	
	final static String TIME_PATTERN = "yyyy-MM-d"; 
	static LocalDate ddnvalide = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));
	static String matricule = "1";
	
	@Before
	public void init()
	{
		collegueService.setColRepo(mockedRepository);
}
	
	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_NomTropCourt()
	{
		collegueService.ajouterCollegue(new Collegue("a", prenomValide, emailValide, ddnvalide, photoUrlValide));
		
	}

	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_PrenomTropCourt()
	{
		collegueService.ajouterCollegue(new Collegue(nomValide, "b", emailValide, ddnvalide, photoUrlValide));
	}

	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_EmailTropCourt()
	{
		String emailTropCourt = "a@";

		Mockito.when(mockedRepository.findById(matricule)).thenReturn(Optional.of(new Collegue(matricule, nomValide,
				prenomValide, emailTropCourt, photoUrlValide, ddnvalide)));
		collegueService.modifierEmail(matricule, emailTropCourt);	}

	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_EmailSansArobase()
	{
		collegueService.ajouterCollegue(new Collegue(nomValide, prenomValide, "arthur.com", ddnvalide, photoUrlValide));
	}

	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_photoUrlSansHttp()
	{
		collegueService.ajouterCollegue(new Collegue(nomValide, prenomValide, emailValide, ddnvalide, "photo.com"));
	}

	@Test(expected = CollegueInvalidException.class)
	public void ajouterUnCollegue_pasMajeur()
	{
		collegueService.ajouterCollegue(new Collegue(nomValide, prenomValide, emailValide, LocalDate.now(), photoUrlValide));
}
	
	@Test(expected = CollegueInvalidException.class)
	public void modifierEmail_EmailTropCourt(){
		String emailTropCourt = "a@";

		Mockito.when(mockedRepository.findById(matricule)).thenReturn(Optional.of(new Collegue(matricule, nomValide,
		prenomValide, emailTropCourt, photoUrlValide, ddnvalide)));
		collegueService.modifierEmail(matricule, emailTropCourt);
	}

	@Test(expected = CollegueInvalidException.class)
	public void modifierEmail_EmailSansArobase()
	{
		String emailSansArobase = "aaazeazea";

		Mockito.when(mockedRepository.findById(matricule)).thenReturn(Optional.of(new Collegue(matricule, nomValide,
		prenomValide, emailSansArobase, photoUrlValide, ddnvalide)));
		collegueService.modifierEmail(matricule, emailSansArobase);
	}
	@Test(expected = CollegueNotFoundException.class)
	public void modifierEmail_mauvaisMatricule()
	{
		collegueService.modifierEmail("2", "a@a.a");
	}

	@Test(expected = CollegueInvalidException.class)
	public void modifierPhotoUrl_photoUrlMauvaise()
	{
		String photoUrlMauvaise = "azeazea.com";

		Mockito.when(mockedRepository.findById(matricule)).thenReturn(Optional.of(new Collegue(matricule, nomValide,
		prenomValide, emailValide, photoUrlMauvaise, ddnvalide)));
		collegueService.modifierPhotoUrl(matricule, photoUrlMauvaise);
	}

	@Test(expected = CollegueNotFoundException.class)
	public void modifierPhotoUrl_mauvaisMatricule()
	{
		collegueService.modifierPhotoUrl("2", "http://photo.com");
}
	
}
