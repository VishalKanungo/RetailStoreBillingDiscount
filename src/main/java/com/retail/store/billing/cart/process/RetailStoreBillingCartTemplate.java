package com.retail.store.billing.cart.process;

import com.retail.store.billing.cart.discount.Discount;
import com.retail.store.billing.cart.domain.Customer;

public interface RetailStoreBillingCartTemplate {
	default Customer invoke(Customer input, Discount<Customer> logic) {
		return process(input, logic);
	}

	public Customer process(Customer input, Discount<Customer> logic);
}
