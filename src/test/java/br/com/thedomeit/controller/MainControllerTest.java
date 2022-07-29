package br.com.thedomeit.controller;

import br.com.thedomeit.util.BuilderData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
			MvcResult result = mockMvc.perform(get("/expense/" + id)
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
			MvcResult result = mockMvc.perform(get("/expense/" + id)
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
			MvcResult result = mockMvc.perform(get("/expense/")
										.contentType("application/json"))
									  .andExpect(status().isOk())
									  .andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
