package br.dev.giovanni.wayon.transaction;

public class TaxException extends RuntimeException {
	public TaxException() {
		super("Fee not applicable. Transfer is not permitted.");
	}
}
