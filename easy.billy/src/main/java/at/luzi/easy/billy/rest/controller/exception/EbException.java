package at.luzi.easy.billy.rest.controller.exception;

import at.luzi.easy.billy.enums.ErrorCode;
import lombok.Getter;

/**
 *
 * Internal Exception.
 *
 * @author lukaszimmermann
 *
 */
@Getter
public class EbException extends RuntimeException {

	private static final long serialVersionUID = 6330886605752586812L;

	private final ErrorCode errorCode;

	public EbException(final ErrorCode errorCode) {
		super(errorCode.getMsg());
		this.errorCode = errorCode;
	}

	public EbException(final ErrorCode errorCode, final Throwable throwable) {
		super(errorCode.getMsg(), throwable);
		this.errorCode = errorCode;
	}

}
