package net.viralpatel.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.viralpatel.spring.dao.ProductListDao;
import net.viralpatel.spring.model.ProductList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductListController {
	@Autowired
	private ProductListDao productListDAO;

	
	@GetMapping("/products")
	public List getProducts() {
		return productListDAO.list();
	}
	
	

	@GetMapping("/products/{id}")
	public ResponseEntity getProduct(@PathVariable("id") Long id) {

		ProductList product = productListDAO.get(id);
		if (product == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(product, HttpStatus.OK);
	}

	@PostMapping(value = "/products")
	public ResponseEntity createProduct(@RequestBody ProductList product) {

		productListDAO.create(product);

		return new ResponseEntity(product, HttpStatus.OK);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity deleteProduct(@PathVariable Long id) {

		if (null == productListDAO.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/products/{id}")
	public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody ProductList product) {

		product = productListDAO.update(id, product);

		if (null == product) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(product, HttpStatus.OK);
	}



//	private static void buyProduct()
//	{
//	    final String uri = "http://localhost:8080/http://localhost:8080/Spring4Rest/products/buyProduct?id=";
//	     
//	    Map<String, String> params = new HashMap<String, String>();
//	    params.put("id", "1");
//	     
//	    RestTemplate restTemplate = new RestTemplate();
//	    String result = restTemplate.getForObject(uri, String.class, params);
//	    System.out.println(result);
//	}
	
	@GetMapping("/products/buyProduct")
	public ResponseEntity buyProdct(@RequestParam int id) {
		return new ResponseEntity(id, HttpStatus.OK);
	}
	
	
	

}