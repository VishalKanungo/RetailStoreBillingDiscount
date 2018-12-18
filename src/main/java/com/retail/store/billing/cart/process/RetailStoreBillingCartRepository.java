package com.retail.store.billing.cart.process;

import com.retail.store.billing.cart.discount.Discount;
import com.retail.store.billing.cart.discount.DiscountCalculation;
import com.retail.store.billing.cart.domain.Customer;

public class RetailStoreBillingCartRepository implements RetailStoreBillingCart{
	@Override
	public Customer totalPayable(Customer input, Discount<Customer> logic) {

		return new RetailStoreBillingCartProcessor().execute(input, logic, (Customer inputx, Discount<Customer> logicx) -> {

			DiscountCalculation calculation = new DiscountCalculation(input);
			Double totaldiscount = calculation.calculateDiscount(logic);
			Double netPayable = input.getBilledAmount() - totaldiscount;
			input.setTotalPayableAmount(netPayable);
			return input;

		});

	}
}
