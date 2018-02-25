package com.cts.ejb.training.facade;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class ShoppingCartException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 426686206787053903L;

	public ShoppingCartException() {}
}
