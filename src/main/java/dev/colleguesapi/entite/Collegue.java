package dev.colleguesapi.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Collegue {
		
		@Transient
		final String TIME_PATTERN = "yyyy-MM-d";
		@Id
		String matricule;
		@Column
		String nom;
		@Column
		String prenom ;
		@Column
		String email ;
		@Column
		String photoUrl;
		@Column
		LocalDate dateDeNaissance;
		@Column
		String motDePasse;
		
		@ElementCollection(fetch = FetchType.EAGER)
		private List<String> roles = new ArrayList<>();
		
		public Collegue() {
		}

		public Collegue (String nom,String prenom,String email,LocalDate dateDeNaissance,String photoUrl) {
			
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.dateDeNaissance = dateDeNaissance;
			this.photoUrl = photoUrl;
			
		}
		
		public Collegue(String matricule, String nom, String prenoms, String email, String photoUrl,
				LocalDate dateDeNaissance)
		{
			super();
			this.matricule = matricule;
			this.nom = nom;
			this.prenom = prenoms;
			this.email = email;
			this.dateDeNaissance = dateDeNaissance;
			this.photoUrl = photoUrl;
	}
		
	

		public String getMatricule() {
			return matricule;
		}

		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenoms) {
			this.prenom = prenoms;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public LocalDate getDateDeNaissance() {
			return dateDeNaissance;
		}

		public void setDateDeNaissance(LocalDate dateDeNaissance) {
			this.dateDeNaissance = dateDeNaissance;
		}

		public String getPhotoUrl() {
			return photoUrl;
		}

		public void setPhotoUrl(String photoUrl) {
			this.photoUrl = photoUrl;
		}

		public String getMotDePasse() {
			return motDePasse;
		}

		public void setMotDePasse(String motDePasse) {
			this.motDePasse = motDePasse;
		}

		public List<String> getRoles() {
			return roles;
		}

		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
}
