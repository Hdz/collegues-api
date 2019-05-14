package dev.colleguesapi.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.colleguesapi.entite.Collegue;

public interface UtilisateurRepository extends JpaRepository<Collegue, String> {

	Optional<Collegue> findByEmail(String email);
}