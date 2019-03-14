package ir.kuroshfarsimadan.demo21springbootswaggerapi.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import ir.kuroshfarsimadan.demo21springbootswaggerapi.bean.APIExceptions;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(NotFoundException ex, WebRequest request) {
		APIExceptions apiExceptions = new APIExceptions(new Date(), ex.getMessage(), request.getDescription(false),
				request.getRemoteUser(), ex.getLocalizedMessage());
		return new ResponseEntity<>(apiExceptions, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		APIExceptions apiExceptions = new APIExceptions(new Date(), ex.getMessage(), request.getDescription(false),
				request.getRemoteUser(), ex.getLocalizedMessage());
		return new ResponseEntity<>(apiExceptions, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}