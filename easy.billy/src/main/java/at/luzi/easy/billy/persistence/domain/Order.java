package at.luzi.easy.billy.persistence.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class Order extends BaseCollection {

	@Min(1)
	private int number;

	private String title;

	private String description;

	@NotBlank
	private String table;

	private LocalDateTime finished;

	private BigDecimal priceTotal;

	@NotNull
	private User user;

	@NotNull
	private List<Item> items;

}
