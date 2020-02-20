package at.luzi.easy.billy.persistence.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseCollection {

	@NotBlank
	private String firstname;
	@NotBlank
	private String lastname;

	private LocalDate birthday;

	private String email;
}
