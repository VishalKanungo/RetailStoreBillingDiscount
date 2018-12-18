package com.retail.store.billing.cart.process.service;

import java.util.Arrays;

import com.retail.store.billing.cart.discount.Discount;
import com.retail.store.billing.cart.domain.Customer;
import com.retail.store.billing.cart.domain.CustomerType;
import com.retail.store.billing.cart.process.RetailStoreBillingCart;
import com.retail.store.billing.cart.process.RetailStoreBillingCartRepository;
import com.retail.store.billing.exception.BillingTransactionException;

public class RetailStoreBillingCartServiceImpl implements RetailStoreBillingCartService {
	@Override
	public Double totalPayableAmount(Customer customer) {

		RetailStoreBillingCart retailStoreBilling = new RetailStoreBillingCartRepository();

		if (customer.getBilledAmount() == null || customer.getBilledAmount() <= 0.0) {
			throw new BillingTransactionException("Billed amount should be a positive number.",	EXIT_STATUS_BILLED_AMOUNT_NOT_CORRECT);
		}
		if (customer.getCustomerType() == null
				|| !Arrays.asList(CustomerType.values()).contains(customer.getCustomerType())) {
			throw new BillingTransactionException("Customer Type should be correct.", EXIT_STATUS_CUSTOMER_TYPE_NOT_CORRECT);
		}
		if (customer.getTransactionNumber() == null) {
			throw new BillingTransactionException("Transaction Number should not be blank.", EXIT_STATUS_TRANSACTION_NO_NOT_CORRECT);
		}
		try {
			Discount<Customer> discount = (Customer customerx) -> {
				switch (customer.getCustomerType()) {
				case EMPLOYEE:
					return () -> ((30 * customer.getBilledAmount()) / 100) + ((customer.getBilledAmount() / 100) * 5);
				case AFFILATED_CUSTOMER:
					return () -> ((10 * customer.getBilledAmount()) / 100) + ((customer.getBilledAmount() / 100) * 5);
				case CUSTOMER_OVER_2_YEARS:
					return () -> ((5 * customer.getBilledAmount()) / 100) + ((customer.getBilledAmount() / 100) * 5);
				case GROCERIES:
					return () -> (customer.getBilledAmount() / 100) * 5;
				default:
					return () -> 0.0;
				}
			};

			retailStoreBilling.totalPayable(customer, discount);
		} catch (Exception e) {
			throw new BillingTransactionException("Transaction failed!!!!", EXIT_STATUS_TRANSCATION_FAILED);

		}

		return customer.getTotalPayableAmount();
	}

}
