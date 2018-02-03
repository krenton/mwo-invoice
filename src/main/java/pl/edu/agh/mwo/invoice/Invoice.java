package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	// TODO: implement lambdas for the totals
	private Map<Product, Integer> products = new HashMap<Product, Integer>();

	public void addProduct(Product product) {
		products.put(product, 1);
	}

	public void addProduct(Product product, Integer quantity) {
		
		if (quantity == 0 || quantity < 0) {
			throw new IllegalArgumentException("Product quantity cant be zero!");
		}
		
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
		BigDecimal tax = new BigDecimal(0.00);
		
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {			
			tax = tax.add(entry.getKey().getPrice().multiply(entry.getKey().getTaxPercent()).multiply(new BigDecimal(entry.getValue())));
		}
		
		return tax;
	}

	public BigDecimal getTotal() {
		return this.getTax().add(this.getNetPrice());
	}
}

interface Calculate {

	BigDecimal bob();
	
}
