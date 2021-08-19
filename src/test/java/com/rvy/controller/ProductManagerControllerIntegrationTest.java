//package com.rvy.controller;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.rvy.ProductMasterApplication;
//import com.rvy.entity.Product;
//import com.rvy.service.ProductOperation;
//
//		
//
//@TestPropertySource(
//  locations = "classpath:application-integrationtest.properties")
////
////@SpringBootTest(properties = "spring.main.lazy-initialization=true", webEnvironment = WebEnvironment.RANDOM_PORT, classes = ProductManagerController.class)
////@ExtendWith(SpringExtension.class)
////
//
//@AutoConfigureMockMvc 
//@AutoConfigureTestDatabase(replace=Replace.NONE)
//
//@SpringBootTest(classes = ProductMasterApplication.class, 
//webEnvironment = WebEnvironment.RANDOM_PORT)
//
//public class ProductManagerControllerIntegrationTest {
//	
//	 @LocalServerPort
//	    private int port;
//	 
//	static byte[] asJsonString(Object object) throws IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//		return mapper.writeValueAsBytes(object);
//	}
//
//	@Autowired
//	private MockMvc mvc;
//
//	@MockBean
//	private ProductOperation productOperation;
//	private Product product;
//	private List<Product> productList;
//
//
//	@InjectMocks
//	private ProductManagerController productManagerController;
//
//
//	@BeforeEach
//	public void setup(){
//		 product  = new Product(null,"Electronics","laptop","Lenovo","Ideapad S340",null,null);
//		mvc = MockMvcBuilders.standaloneSetup(productManagerController).build();
//
//	}
//
//	@Test
//	public void whenValidInput_thenCreateProduct() throws IOException, Exception {
//		when(productOperation.addProduct(product)).thenReturn(product);
//		mvc.perform(post("/pms/v1/product").contentType(MediaType.APPLICATION_JSON).content(asJsonString(product))).
//		andExpect(status().isCreated());
//	}
//
//	@Test
//	public void whenFindAll_ReturnAll() throws IOException, Exception{
//		when(productOperation.getAllProducts()).thenReturn(productList);
//		mvc.perform(get("/pms/v1/products").contentType(MediaType.APPLICATION_JSON))
//		.andDo(print())
//		.andExpect(status().isOk())
//		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//		.andExpect(jsonPath("$[0].category", is("Electronics")));
//	}
//
//	@Test
//	public void whenValidId_ReturnProduct() throws IOException, Exception {
//
//		productOperation.addProduct(product);
//
//		when(productOperation.getDetailsById(product.getProductId())).thenReturn(product);
//
//		mvc.perform(get("/pms/v1/product/1")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(asJsonString(product)))
//		.andExpect(status().isOk())
//		.andExpect(jsonPath("$.category", is("Electronics")));
//
//	}   
//
//}
