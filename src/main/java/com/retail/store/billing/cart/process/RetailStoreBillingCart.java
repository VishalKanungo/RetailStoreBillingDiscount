package com.retail.store.billing.cart.process;

import com.retail.store.billing.cart.discount.Discount;
import com.retail.store.billing.cart.domain.Customer;

@FunctionalInterface
public interface RetailStoreBillingCart {
	Customer totalPayable(Customer input, Discount<Customer> logic);
}
