package at.luzi.easy.billy.service.resource;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class UserResource extends BaseResource {

	@NotBlank
	private String firstname;
	@NotBlank
	private String lastname;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;

	@Email
	private String email;

}
