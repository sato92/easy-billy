package at.luzi.easy.billy.service.resource;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import at.luzi.easy.billy.enums.ItemCategory;
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
public class ItemResource extends BaseResource {

	@NotBlank
	private String name;

	private String description;

	private BigDecimal price;

	private String unit;

	private Double unitAmount;

	private String icon;

	@NotNull
	private ItemCategory category;

}
