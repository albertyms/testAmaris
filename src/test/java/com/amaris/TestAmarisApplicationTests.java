package com.amaris;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
class TestAmarisApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void givenPricesURI_whenMockMVC_thenResultOk_withDay14And10clock() throws Exception {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("dateApply", "2020-06-14 10:00:00");
		params.add("brandId", "1");
		params.add("productId", "1");

		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/prices").queryParams(params));
		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
	}

	@Test
	void givenPricesURI_whenMockMVC_thenResultOk_withDay14And16clock() throws Exception {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("dateApply", "2020-06-14 16:00:00");
		params.add("brandId", "1");
		params.add("productId", "1");

		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/prices").queryParams(params));
		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
	}

	@Test
	void givenPricesURI_whenMockMVC_thenResultOk_withDay14And21clock() throws Exception {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("dateApply", "2020-06-14 21:00:00");
		params.add("brandId", "1");
		params.add("productId", "1");

		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/prices").queryParams(params));
		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
	}

	@Test
	void givenPricesURI_whenMockMVC_thenResultOk_withDay15And10clock() throws Exception {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("dateApply", "2020-06-15 10:00:00");
		params.add("brandId", "1");
		params.add("productId", "1");

		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/prices").queryParams(params));
		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
	}

	@Test
	void givenPricesURI_whenMockMVC_thenResultOk_withDay16And21clock() throws Exception {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("dateApply", "2020-06-16 21:00:00");
		params.add("brandId", "1");
		params.add("productId", "1");

		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/prices").queryParams(params));
		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.message").exists());
	}



}
