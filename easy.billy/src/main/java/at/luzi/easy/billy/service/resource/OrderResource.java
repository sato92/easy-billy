package at.luzi.easy.billy.service.resource;

import java.math.BigDecimal;
import java.util.List;

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
public class OrderResource extends BaseResource {

	private Integer number;

	private String title;

	private String description;

	@NotBlank
	private String table;

	private BigDecimal priceTotal;

	private UserResource user;

	private List<ItemResource> items;

}
