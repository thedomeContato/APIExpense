package br.com.thedomeit.repositories;

import br.com.thedomeit.model.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

	public Optional<Expense> findById(Long id);
}
