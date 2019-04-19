package dev.colleguesapi.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.colleguesapi.entite.Collegue;

@Component
public class StartupDataInit {

	@Autowired
	CollegueRepository collegueRepo;
static final String TIME_PATTERN = "yyyy-MM-d";

//La méthode init va être invoquée au démarrage de l'application.
	@EventListener(ContextRefreshedEvent.class)
	public void init()
	{
		LocalDate date1 = LocalDate.parse("1950-11-14", DateTimeFormatter.ofPattern(TIME_PATTERN));

		String matriculeTemp = UUID.randomUUID().toString();
		
		collegueRepo.save(new Collegue(matriculeTemp, "Bobbi", "Albert", "mail@mail.com", "http://nophoto.com", date1));
		matriculeTemp = UUID.randomUUID().toString();
		
		collegueRepo.save(new Collegue(matriculeTemp, "ROBERT", "Noelle", "mail@mail.com", "http://nophoto.com", date1));
		matriculeTemp = UUID.randomUUID().toString();
		
		collegueRepo.save(new Collegue(matriculeTemp, "JEAN", "Arthur", "mail@mail.com", "http://nophoto.com", date1));

		collegueRepo.save(new Collegue("1", "GUY", "Robert", "mail@mail.com", "http://nophoto.com", date1));
}
}
