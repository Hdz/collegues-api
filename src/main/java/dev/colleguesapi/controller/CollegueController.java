package dev.colleguesapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.colleguesapi.entite.Collegue;
import dev.colleguesapi.service.CollegueService;



/*
Un contrôleur est un composant de Spring qui permet de
gérer une requête HTTP et produire une réponse HTTP
 */
@RestController
//Ici cette classe va répondre aux requêtes `/exemples`
@RequestMapping("/colleguesapi")
public class CollegueController {

	// Cette méthode va être invoquée pour une requête HTTP `GET /exemples`
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody // parser l'objet Client
	public List<String> recherchercollegues(@RequestParam ("nomCollegue") String nomCollegue) {
		CollegueService collegue1 = new CollegueService();
		List<String> collegueTrouve = new ArrayList<>();
		
		for (Collegue c : collegue1.rechercheParNom(nomCollegue)) {
			collegueTrouve.add(c.getMatricule());
		}		

		return collegueTrouve;
	}
}