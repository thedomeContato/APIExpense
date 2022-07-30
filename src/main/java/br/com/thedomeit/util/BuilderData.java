package br.com.thedomeit.util;

import br.com.thedomeit.model.dto.ExpenseDto;
import br.com.thedomeit.model.entities.Expense;
import br.com.thedomeit.repositories.ExpenseRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class BuilderData{

	@Autowired
	ExpenseRepository expenseRepository;

	private static final Logger logger = LogManager.getLogger(BuilderData.class);
	private Expense expense;
	private ExpenseDto expenseDto;

	public void builderAll() {

		for (int cont = 1; cont <= 10 ; cont++) {
			expense = new Expense();

			expense.setDateExpense(LocalDateTime.now());
			expense.setDescriptionExpense("Descrição " + cont);
			expense.setValueExpense(BigDecimal.valueOf(100 + cont));
			expense.setTag("#tag" + cont);
			expense.setClientName("Client number " + cont);

			expenseRepository.save(expense);
		}
	}

	public void builderIdOk() {

		expense = new Expense();

		expense.setDateExpense(LocalDateTime.now());
		expense.setDescriptionExpense("Descrição Teste Id Ok");
		expense.setValueExpense(BigDecimal.valueOf(100.01));
		expense.setTag("#testeId");
		expense.setClientName("João do Teste");
		expenseRepository.save(expense);

	}

	public ExpenseDto builderInsertOk() {
		expenseDto = new ExpenseDto();

		expenseDto.setDateExpense(LocalDateTime.now().toString());
		expenseDto.setDescriptionExpense("Descriçao Insert OK");
		expenseDto.setValueExpense(BigDecimal.valueOf(788.55));
		expenseDto.setTag("#TagTeste");
		expenseDto.setClientName("Maria do Teste");

		return expenseDto;
	}
}
