package com.retail.store.billing.cart.domain;

public class Customer {
	private String customerName;
	private CustomerType customerType;
	private Double billedAmount;
	private Double totalPayableAmount;
	private String transactionNumber;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	public Double getBilledAmount() {
		return billedAmount;
	}
	public void setBilledAmount(Double billedAmount) {
		this.billedAmount = billedAmount;
	}
	public Double getTotalPayableAmount() {
		return totalPayableAmount;
	}
	public void setTotalPayableAmount(Double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}	
}
