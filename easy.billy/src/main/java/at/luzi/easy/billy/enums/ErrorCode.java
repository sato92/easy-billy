package at.luzi.easy.billy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration for Error Codes.
 *
 * @author lukaszimmermann
 *
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

	DUPLICATE_ENTRY("Duplicate Entry - not possible to create");

	private String msg;

}
