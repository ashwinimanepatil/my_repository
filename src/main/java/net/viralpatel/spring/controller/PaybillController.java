package net.viralpatel.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.viralpatel.spring.dao.ProductListDao;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PaybillController {
	@Autowired
	private ProductListDao productListDAO;
	
	@GetMapping("/products/buyProdct")
	public ResponseEntity buyProdct(@RequestParam int id) {
		return new ResponseEntity(id, HttpStatus.OK);
	}
}
