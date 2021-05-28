package com.mit.wallet.exceptions;

public class WalletExceptionResponse {
    
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public WalletExceptionResponse(String id) {
		super();
		this.id = id;
	}

	
	
}
