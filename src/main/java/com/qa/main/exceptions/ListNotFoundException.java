package com.qa.main.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT, reason = "List not found. Try a different id")

public class ListNotFoundException extends EntityNotFoundException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1595084675298716417L;
	
	

}
