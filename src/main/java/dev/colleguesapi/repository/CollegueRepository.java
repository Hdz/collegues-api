package dev.colleguesapi.repository;

	import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.colleguesapi.entite.Collegue;


	public interface CollegueRepository extends JpaRepository<Collegue, String>
	{
		 @Query("select distinct c from Collegue c where c.nom = :nom")
		 List<Collegue> findDistinctPeopleByNom(@Param("nom") String nom);
		 List<Collegue> findByEmail(String email);
		 
	}
