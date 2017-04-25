package org.iita.trainingunit.applications.service;

/**
 * Exception in approval process.
 * 
 * @author koraegbunam
 * 
 */
public class ApprovalException extends Exception {

	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = -2030696532797961993L;

	public ApprovalException() {
	}

	public ApprovalException(String message) {
		super(message);
	}

	public ApprovalException(Throwable cause) {
		super(cause);

	}

	public ApprovalException(String message, Throwable cause) {
		super(message, cause);

	}

}
