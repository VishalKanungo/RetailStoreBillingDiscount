package com.retail.store.billing.cart.discount;

import com.retail.store.billing.cart.domain.Customer;

public class DiscountCalculation {
	private Customer customer;

	public DiscountCalculation(Customer customer) {
		super();
		this.customer = customer;
	}

	public Double calculateDiscount(Discount<?> discount) {
		return discount.discount(customer).get();
	}
}
