package at.luzi.easy.billy.persistence.domain;

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
public class Item extends BaseCollection {

	@NotBlank
	private String name;

	private String description;

	@NotNull
	private BigDecimal price;

	private String unit;

	private Double unitAmount;

	private String icon;

	@NotNull
	private ItemCategory category;
}
