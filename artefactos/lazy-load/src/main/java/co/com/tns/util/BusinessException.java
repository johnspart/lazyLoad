package co.com.tns.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String label;
	private Logger error = Logger.getGlobal();

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		error.log(Level.SEVERE, message, cause);
	}

	public BusinessException(String message) {
		super(message);
		error.log(Level.SEVERE, message);
	}

	public BusinessException(String message, String label) {
		super(message);
		this.label = label;
		error.log(Level.SEVERE, message);
	}

	public BusinessException(Throwable cause) {
		super(cause.getMessage(), cause);
		error.log(Level.SEVERE, cause.getMessage(), cause);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
