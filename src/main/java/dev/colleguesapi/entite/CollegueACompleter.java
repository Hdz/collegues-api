package dev.colleguesapi.entite;

public class CollegueACompleter {
	
		private String email;
		private String photoUrl;

		public CollegueACompleter()
		{

		}

		/**
		 * Getter
		 * 
		 * @return the photoUrl
		 */
		public String getPhotoUrl()
		{
			return photoUrl;
		}

		/**
		 * Setter
		 * 
		 * @param photoUrl the photoUrl to set
		 */
		public void setPhotoUrl(String photoUrl)
		{
			this.photoUrl = photoUrl;
		}

		/**
		 * Getter
		 * 
		 * @return the email
		 */
		public String getEmail()
		{
			return email;
		}

		/**
		 * Setter
		 * 
		 * @param email the email to set
		 */
		public void setEmail(String email)
		{
			this.email = email;
	}
}
