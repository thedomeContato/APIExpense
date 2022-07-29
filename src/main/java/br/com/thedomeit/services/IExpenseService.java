package br.com.thedomeit.services;

import br.com.thedomeit.model.dto.ExpenseDto;

import java.util.List;

public interface IExpenseService {

	public void insertClient(ExpenseDto expenseDto);
	public ExpenseDto findById(Long id);
	public List<ExpenseDto> findAll();

}

