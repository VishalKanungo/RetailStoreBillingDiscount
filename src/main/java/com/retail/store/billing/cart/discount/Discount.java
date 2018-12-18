package com.retail.store.billing.cart.discount;

import com.retail.store.billing.cart.domain.Customer;
import java.util.function.Supplier;

@FunctionalInterface
public interface Discount<C> {
	
	Supplier<Double> discount(Customer customer);

}
