package dev.colleguesapi.entite;

public class Collegue {

		String matricule, nom, prenoms,email, dateDeNassaince,photoUrl;

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

		public String getPrenoms() {
			return prenoms;
		}

		public void setPrenoms(String prenoms) {
			this.prenoms = prenoms;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getDateDeNassaince() {
			return dateDeNassaince;
		}

		public void setDateDeNassaince(String dateDeNassaince) {
			this.dateDeNassaince = dateDeNassaince;
		}

		public String getPhotoUrl() {
			return photoUrl;
		}

		public void setPhotoUrl(String photoUrl) {
			this.photoUrl = photoUrl;
		}
}
