package dev.colleguesapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import dev.colleguesapi.entite.Collegue;

public class CollegueService {
	private Map<String, Collegue> data = new HashMap<>();

	public CollegueService() {
		// TODO alimenter data avec des données fictives
		Collegue collegue = new Collegue();
		collegue.setMatricule(UUID.randomUUID().toString());
		collegue.setNom("Gérard");
		collegue.setPrenoms("Laurent");
		collegue.setEmail("mail.mail@mail.com");
		collegue.setDateDeNassaince("07/07/1992");
		collegue.setPhotoUrl("url");
		data.put(collegue.getNom(), collegue);

		Collegue collegue1 = new Collegue();
		collegue1.setMatricule(UUID.randomUUID().toString());
		collegue1.setNom("Guy");
		collegue1.setPrenoms("Gros");
		collegue1.setEmail("mail.mail@mail.com");
		collegue1.setDateDeNassaince("07/07/1992");
		collegue1.setPhotoUrl("url");
		data.put(collegue1.getNom(), collegue1);


	}

	public List<Collegue> rechercheParNom(String nomrecherche){
		List<Collegue> collegues = new ArrayList();
		collegues.add(data.get(nomrecherche));
		return collegues;
	}

}

