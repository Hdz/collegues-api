package exception;

public class CollegueInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	static String msg;
	
	public CollegueInvalidException(String message)
	{
		msg = message;
}

}
