package dev.colleguesapi.entite;

import java.time.LocalDate;

public class Collegue {

		final String TIME_PATTERN = "yyyy-MM-d";
		String matricule, nom, prenom,email, photoUrl;
		LocalDate dateDeNassaince;
		
		public Collegue() {
		}

		public Collegue (String nom,String prenom,String email,LocalDate dateDeNassaince,String photoUrl) {
			
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.dateDeNassaince = dateDeNassaince;
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
			this.dateDeNassaince = dateDeNaissance;
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

		public LocalDate getDateDeNassaince() {
			return dateDeNassaince;
		}

		public void setDateDeNassaince(LocalDate dateDeNassaince) {
			this.dateDeNassaince = dateDeNassaince;
		}

		public String getPhotoUrl() {
			return photoUrl;
		}

		public void setPhotoUrl(String photoUrl) {
			this.photoUrl = photoUrl;
		}
}
