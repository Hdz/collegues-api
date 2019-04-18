package exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class MyExceptionHandler {
	
		@ExceptionHandler(value = CollegueNotFoundException.class)
		protected ResponseEntity<Object> handleConflictCollegueNotFound(RuntimeException ex, WebRequest request)
		{
			String bodyOfResponse = "Collegue non trouvé";
			return ResponseEntity.status(404).body(bodyOfResponse);
		}

		@ExceptionHandler(value = CollegueInvalidException.class)
		protected ResponseEntity<Object> handleConflictCollegueInvalid(RuntimeException ex, WebRequest request)
		{
			String bodyOfResponse = "Collegue invalide : " + CollegueInvalidException.msg;
			return ResponseEntity.status(404).body(bodyOfResponse);
		}
	
}