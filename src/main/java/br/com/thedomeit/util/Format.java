package br.com.thedomeit.util;

import br.com.thedomeit.model.dto.ExpenseDto;
import br.com.thedomeit.model.entities.Expense;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;


@Component
public class Format {

	private Expense expense = new Expense();
	private ExpenseDto expenseDto = new ExpenseDto();

	public Expense formatExpenseDtoToExpense(ExpenseDto expenseDto){
		expense = new Expense();

		expense.setDateExpense(LocalDateTime.parse(expenseDto.getDateExpense()));
		expense.setDescriptionExpense(expenseDto.getDescriptionExpense());
		expense.setValueExpense(expenseDto.getValueExpense());
		expense.setId(expenseDto.getId());
		expense.setTag(expenseDto.getTag());
		expense.setClientName(expenseDto.getClientName());

		return expense;
	}

	public ExpenseDto formatExpenseToExpenseDto(Expense expense){
		expenseDto = new ExpenseDto();

		expenseDto.setDateExpense(expense.getDateExpense().toString());
		expenseDto.setDescriptionExpense(expense.getDescriptionExpense());
		expenseDto.setValueExpense(expense.getValueExpense());
		expenseDto.setId(expense.getId());
		expenseDto.setTag(expense.getTag());
		expenseDto.setClientName(expense.getClientName());

		return expenseDto;
	}
}
