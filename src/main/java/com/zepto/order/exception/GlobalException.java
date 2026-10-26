
package com.zepto.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorRes> handleOrderNotFoundException(
			OrderNotFoundException exception) {

		ErrorRes error = new ErrorRes();
		error.setErrorCode("ORDER_NOT_FOUND");
		error.setErrorMessage(exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(error);
	}
}
