package ch.hevs.exception;

public class BookException extends RuntimeException {

	public BookException() {
		super();
	}
 
	public BookException(String arg0) {
		super(arg0);
	}

	public BookException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BookException(Throwable arg0) {
		super(arg0);
	}

}
