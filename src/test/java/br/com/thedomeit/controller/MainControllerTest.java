package br.com.thedomeit.controller;

import br.com.thedomeit.model.dto.ExpenseDto;
import br.com.thedomeit.util.BuilderData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private BuilderData builder;

	@Test
	public void findByIdOk() {
		long id = 1L;

		builder.builderIdOk();

		try {
			mockMvc.perform(get("/expense/" + id)
						 	 .contentType("application/json"))
			                 .andExpect(status().isOk())
			                 .andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findByIdNOk() {

		long id = 100L;

		try {
			mockMvc.perform(get("/expense/" + id)
							 .contentType("application/json"))
						     .andExpect(status().isNotFound())
							 .andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findByAllOk() {
		builder.builderAll();

		try {
			mockMvc.perform(get("/expense")
							 .contentType("application/json"))
							 .andExpect(status().isOk())
							 .andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertExpenseOk () {
		ExpenseDto expenseDto = new ExpenseDto();
		expenseDto.setDateExpense("2022-07-30 14:00:49");
		expenseDto.setDescriptionExpense("Gastos Testes");
		expenseDto.setClientName("João do Teste");
		expenseDto.setTag("#TAG123");
		expenseDto.setValueExpense(BigDecimal.valueOf(523.00));

		String obj = asJsonString(expenseDto);

		try {
			mockMvc.perform(MockMvcRequestBuilders
					.post("/expense")
					.content(asJsonString(expenseDto))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated());
			int i = 1;
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void insertExpenseNOK () {
		ExpenseDto expenseDto = new ExpenseDto();

		String obj = asJsonString(expenseDto);

		try {
			mockMvc.perform(MockMvcRequestBuilders
							.post("/expense")
							.content(asJsonString(expenseDto))
							.contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().is(400));
			int i = 1;
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
