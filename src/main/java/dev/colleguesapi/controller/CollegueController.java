package dev.colleguesapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.colleguesapi.entite.Collegue;
import dev.colleguesapi.entite.CollegueACompleter;
import dev.colleguesapi.service.CollegueService;



/*
Un contrôleur est un composant de Spring qui permet de
gérer une requête HTTP et produire une réponse HTTP
 */
@RestController
//Ici cette classe va répondre aux requêtes `/exemples`
@RequestMapping("/collegues")
@CrossOrigin
public class CollegueController {
	@Autowired
	private CollegueService collegue1 = new CollegueService();
	
	// Cette méthode va être invoquée pour une requête HTTP `GET /collegues`?nomCollegue =
	@GetMapping
	public List<String> recherchercollegues(@RequestParam("nomCollegue") String nomCollegue) {
		List<String> collegueTrouve = new ArrayList<>();
		for (Collegue c : collegue1.rechercherParNom(nomCollegue)) {
			collegueTrouve.add(c.getMatricule());


		}		
		return collegueTrouve;
	}
	
	@GetMapping("/{matricule}")
	public Collegue recherchermatricules(@PathVariable String matricule) throws Exception {
		
		Collegue matriculetrouve = collegue1.rechercherParMatricule(matricule); 
				

		return matriculetrouve;
	}
	
	@PostMapping
	public ResponseEntity<Collegue> ajouterCollegue(@RequestBody Collegue collegueAAjouter)
	{
		
		Collegue collegueTemp = collegue1.ajouterCollegue(collegueAAjouter);
		return ResponseEntity.status(HttpStatus.OK).body(collegueTemp);
}

	@PatchMapping(path = "/{matriculeRecherche}")
	public ResponseEntity<Collegue> miseAJourCollegue(@PathVariable String matriculeRecherche,
			@RequestBody CollegueACompleter nvCollegue)
	{
		Collegue collegueTemp = new Collegue();

		if (nvCollegue.getEmail() != null)
		{
			collegueTemp = collegue1.modifierEmail(matriculeRecherche, nvCollegue.getEmail());
		}

		if (nvCollegue.getPhotoUrl() != null)
		{
			collegueTemp = collegue1.modifierPhotoUrl(matriculeRecherche, nvCollegue.getPhotoUrl());
		}

		return ResponseEntity.status(HttpStatus.OK).body(collegueTemp);
}
}