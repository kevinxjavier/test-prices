package com.kevinpina;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
class TestPricesApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void giveTest1() throws Exception {

	    mvc.perform(get("/api/price/35455/2020-06-14 10:00:00")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(content()
	      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	      .andExpect(jsonPath("brand_id", is(1)))
	      .andExpect(jsonPath("start_date", is("2020-06-14 00:00:00")))
	      .andExpect(jsonPath("end_date", is("2020-12-31 23:59:59")))
	      .andExpect(jsonPath("price_list", is(1)))
	      .andExpect(jsonPath("product_id", is(35455)))
	      .andExpect(jsonPath("priority", is(0)))
	      .andExpect(jsonPath("price", is(35.5)));
	}

	@Test
	void giveTest2() throws Exception {

	    mvc.perform(get("/api/price/35455/2020-06-14 16:00:00")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(content()
	      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	      .andExpect(jsonPath("brand_id", is(1)))
	      .andExpect(jsonPath("start_date", is("2020-06-14 15:00:00")))
	      .andExpect(jsonPath("end_date", is("2020-06-14 18:30:00")))
	      .andExpect(jsonPath("price_list", is(2)))
	      .andExpect(jsonPath("product_id", is(35455)))
	      .andExpect(jsonPath("priority", is(1)))
	      .andExpect(jsonPath("price", is(25.45)));
	}

	@Test
	void giveTest3() throws Exception {

	    mvc.perform(get("/api/price/35455/2020-06-14 21:00:00")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(content()
	      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	      .andExpect(jsonPath("brand_id", is(1)))
	      .andExpect(jsonPath("start_date", is("2020-06-14 00:00:00")))
	      .andExpect(jsonPath("end_date", is("2020-12-31 23:59:59")))
	      .andExpect(jsonPath("price_list", is(1)))
	      .andExpect(jsonPath("product_id", is(35455)))
	      .andExpect(jsonPath("priority", is(0)))
	      .andExpect(jsonPath("price", is(35.5)));
	}

	@Test
	void giveTest4() throws Exception {

	    mvc.perform(get("/api/price/35455/2020-06-15 10:00:00")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(content()
	      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	      .andExpect(jsonPath("brand_id", is(1)))
	      .andExpect(jsonPath("start_date", is("2020-06-15 00:00:00")))
	      .andExpect(jsonPath("end_date", is("2020-06-15 11:00:00")))
	      .andExpect(jsonPath("price_list", is(3)))
	      .andExpect(jsonPath("product_id", is(35455)))
	      .andExpect(jsonPath("priority", is(1)))
	      .andExpect(jsonPath("price", is(30.5)));
	}

	@Test
	void giveTest5() throws Exception {

	    mvc.perform(get("/api/price/35455/2020-06-16 21:00:00")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(content()
	      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	      .andExpect(jsonPath("brand_id", is(1)))
	      .andExpect(jsonPath("start_date", is("2020-06-15 16:00:00")))
	      .andExpect(jsonPath("end_date", is("2020-12-31 23:59:59")))
	      .andExpect(jsonPath("price_list", is(4)))
	      .andExpect(jsonPath("product_id", is(35455)))
	      .andExpect(jsonPath("priority", is(1)))
	      .andExpect(jsonPath("price", is(38.95)));
	}

}
