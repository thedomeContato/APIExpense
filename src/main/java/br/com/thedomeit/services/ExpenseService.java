package br.com.thedomeit.services;

import br.com.thedomeit.exception.NotFoundException;
import br.com.thedomeit.model.dto.ExpenseDto;
import br.com.thedomeit.model.entities.Expense;
import br.com.thedomeit.repositories.ExpenseRepository;
import br.com.thedomeit.util.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService implements IExpenseService{

	@Autowired ExpenseRepository expenseRepository;
	@Autowired Format format;

	@Override
	public void insertClient(ExpenseDto expenseDto) {
		expenseRepository.save(format.formatExpenseDtoToExpense(expenseDto));
	}

	@Override
	public ExpenseDto findById(Long id) {

		Optional<Expense> expenseOptional = expenseRepository.findById(id);

		return format.formatExpenseToExpenseDto
				(expenseOptional.orElseThrow(
				     () -> new NotFoundException("There are not expense with id = " + id)));
	}

	@Override
	public List<ExpenseDto> findAll() {

		List<ExpenseDto> expensesDto = new ArrayList<ExpenseDto>();
		List<Expense> expenses = expenseRepository.findAll();

		expenses.forEach( expense -> {
					ExpenseDto expenseDtoRet = format.formatExpenseToExpenseDto(expense);
					expensesDto.add(expenseDtoRet);
				}
		);
		return expensesDto;
	}
}