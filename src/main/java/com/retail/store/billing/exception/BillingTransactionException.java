package com.retail.store.billing.exception;

public class BillingTransactionException extends RuntimeException {

	private static final long serialVersionUID = -4243482858349075121L;
	private final int status;
	private final String messge;

	public BillingTransactionException(String messge, int status) {
		this.status = status;
		this.messge = messge;
	}

	public int getStatus() {
		return status;
	}

	public String getMessge() {
		return messge;
	}
}
