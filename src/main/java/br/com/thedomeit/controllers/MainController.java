package br.com.thedomeit.controllers;

import javax.validation.Valid;

import br.com.thedomeit.model.dto.ExpenseDto;
import br.com.thedomeit.services.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/expense")
@Api(tags = "Expense")
public class MainController {

	@Autowired
	IExpenseService expenseService;

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insert Expense")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Insert Ok", response = ExpenseDto.class),
			@ApiResponse(code = 400, message = "Bad request is received"),
			@ApiResponse(code = 500, message = "800000 - Server error")
	})
	public void insertClient(@Valid @RequestBody ExpenseDto expenseDto){
		expenseService.insertClient(expenseDto);
	}


	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Consult Expense By Id")
	@ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Ok Process"),
            @ApiResponse(code = 400, message = "Bad request is received"),
            @ApiResponse(code = 404, message = "Client Not Found"),
            @ApiResponse(code = 500, message = "800000 - Server error")
      })
	public ExpenseDto findById(@PathVariable("id") Long id){
		return expenseService.findById(id);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Consult List of Expense ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok Process"),
			@ApiResponse(code = 400, message = "Bad request is received"),
			@ApiResponse(code = 500, message = "800000 - Server error")
	})
	public List<ExpenseDto> findAll(){
		return expenseService.findAll();
	}

}
