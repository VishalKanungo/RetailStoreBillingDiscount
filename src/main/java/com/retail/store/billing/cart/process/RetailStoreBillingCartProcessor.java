package com.retail.store.billing.cart.process;

import com.retail.store.billing.cart.discount.Discount;
import com.retail.store.billing.cart.domain.Customer;

public class RetailStoreBillingCartProcessor {
	protected Customer execute(Customer input, Discount<Customer> logic, RetailStoreBillingCartTemplate template) {
		return template.invoke(input, logic);
	}
}
