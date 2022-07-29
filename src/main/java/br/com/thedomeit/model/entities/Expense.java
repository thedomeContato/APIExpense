package br.com.thedomeit.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@ToString
public class Expense implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="CLIENTE_NAME", nullable = false)
	private String clientName;
	
	@Column(name="DESCRIPTION_EXPENSE", nullable = false)
	private String descriptionExpense;

	@Column(name="DATE_EXPENSE", nullable = false)
	private LocalDateTime dateExpense;

	@Column(name="VALUE_EXPENSE", nullable = false)
	private BigDecimal valueExpense;

	@Column(name="TAG", nullable = false)
	private String tag;
}
