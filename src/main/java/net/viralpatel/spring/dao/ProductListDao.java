package net.viralpatel.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.viralpatel.spring.model.Customer;
import net.viralpatel.spring.model.ProductList;

@Component
public class ProductListDao {


	// Dummy database. Initialize with some dummy values.
	private static List<ProductList> products;
	{
		products = new ArrayList();
		products.add(new ProductList(1,"Nokia 6.1 Plus",15999,"Available","https://st1.bgr.in/wp-content/uploads/2018/07/Nokia-6.1-Plus-2-Gadget-page.jpg"));
		products.add(new ProductList(2,"Redmi Note 7 Pro",14999,"Not Available","https://www.compareprix.in/images/trendingstoriesandnews/redmi-note-7-and-redmi-note-7-pro-launched-in-india-price-features-and-specifications-ds.jpg"));
		products.add(new ProductList(3,"Samsung Galaxy A50",17565,"Few Left","https://www.gizbot.com/images/2019-02/samsung-galaxy-a50_155135792060.jpg"));
		products.add(new ProductList(4,"Apple iPhone 6",43300,"Out Of Sold","https://secure.i.telegraph.co.uk/multimedia/archive/03448/6iphone6s_3448299k.jpg"));
	}
	public List list() {
		return products;
	}

	
	public ProductList get(long id) {

		for (ProductList c : products) {
			if (c.getProductId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	
	public ProductList create(ProductList product) {
		product.setProductId(System.currentTimeMillis());
		products.add(product);
		return product;
	}

	
	public Long delete(Long id) {

		for (ProductList c : products) {
			if (c.getProductId().equals(id)) {
				products.remove(c);
				return id;
			}
		}

		return null;
	}



	public ProductList update(Long id, ProductList product) {

		for (ProductList c : products) {
			if (c.getProductId().equals(id)) {
				product.setProductId(c.getProductId());
				products.remove(c);
				products.add(product);
				return product;
			}
		}

		return null;
	}

}