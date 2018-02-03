package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	private Map<Product, Integer> products = new HashMap<Product, Integer>();

	public void addProduct(Product product) {
		// TODO: implement
	}

	public void addProduct(Product product, Integer quantity) {
		products.put(product, quantity);
	}

	public BigDecimal getNetPrice() {
		
		BigDecimal netPrice = new BigDecimal(0.00);
		
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {			
			netPrice = netPrice.add(entry.getKey().getPrice().multiply(new BigDecimal(entry.getValue())));
		}
		
		return netPrice;
	}

	public BigDecimal getTax() {
		return null;
	}

	public BigDecimal getTotal() {
		return null;
	}
}
