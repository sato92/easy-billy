package at.luzi.easy.billy.rest.controller.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * BindException, MethodArgumentNotValidException @Valid
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers,
			final HttpStatus status, final WebRequest request) {
		List<String> errors = new ArrayList<>();

		ex.getBindingResult().getFieldErrors().forEach(
				error -> errors.add(error.getField() + ": " + error.getDefaultMessage()));

		ex.getBindingResult().getGlobalErrors().forEach(
				error -> errors.add(error.getObjectName() + ": " + error.getDefaultMessage()));

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
	}

	/**
	 * MissingServletRequestPartException, MissingServletRequestParameterException
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			final MissingServletRequestParameterException ex, final HttpHeaders headers,
			final HttpStatus status, final WebRequest request) {
		String error = ex.getParameterName() + " parameter is missing";

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	/**
	 * ConstrainViolationException
	 *
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(
			final ConstraintViolationException ex, final WebRequest request) {
		List<String> errors = new ArrayList<>();

		ex.getConstraintViolations().forEach(
				violation -> errors.add(violation.getRootBeanClass().getName() + " " +
						violation.getPropertyPath() + ": " + violation.getMessage()));

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	/**
	 *
	 * TypeMismatchException, MethodArgumentTypeMismatchException
	 *
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
			final MethodArgumentTypeMismatchException ex, final WebRequest request) {
		String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(
				apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ EbException.class })
	public ResponseEntity<Object> handleEbExceptions(
			final EbException ex, final WebRequest request) {

		String error = ex.getErrorCode().getMsg();

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		return new ResponseEntity<>(
				apiError, new HttpHeaders(), apiError.getStatus());

	}

}
