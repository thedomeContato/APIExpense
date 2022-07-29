package br.com.thedomeit.model.dto;

import lombok.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class ExpenseDto {

	private Long id;

	@NotBlank(message = "ClientName is necessary")
	private String clientName;

	@NotBlank(message = "Description Expense is necessary")
	private String descriptionExpense;

	private LocalDateTime dateExpense;

	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer=5, fraction=2)
	private BigDecimal valueExpense;

	@NotBlank(message = "Tag is necessary")
	private String tag;

}
