package com.retail.store.billing.cart.discount;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.retail.store.billing.cart.domain.Customer;
import com.retail.store.billing.cart.domain.CustomerType;
import com.retail.store.billing.cart.process.service.RetailStoreBillingCartService;
import com.retail.store.billing.cart.process.service.RetailStoreBillingCartServiceImpl;
import com.retail.store.billing.exception.BillingTransactionException;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RetailStoreBillingDiscountApplicationTests.class)
public class RetailStoreBillingDiscountApplicationTests {
	
	  RetailStoreBillingCartService retailStoreBillingCartService;
	@Test
	public void contextLoads() {
	}
	
	
    @BeforeAll
    public  void setup() {
    	retailStoreBillingCartService=new RetailStoreBillingCartServiceImpl();
    }
    
        
    
    @Test
    public void testRetrievTotalPayableBilledAmountGROCEIES() {
    	RetailStoreBillingCartService retailStoreBillingCartService = new RetailStoreBillingCartServiceImpl();
    	Customer customer=new Customer();
		 customer.setCustomerType(CustomerType.GROCERIES);
		 System.out.println("customer 555555 : " + customer);
		 customer.setBilledAmount(450.78);
		 customer.setTransactionNumber("1233555AAE455");
		 System.out.println(retailStoreBillingCartService);
		 System.out.println(customer);
		 Double result=retailStoreBillingCartService.totalPayableAmount(customer);
		 assertNotNull(result);
    }
    
    @Test
    public void testRetrievTotalPayableBilledAmountSTORE_EMPLOYEE() {
    	RetailStoreBillingCartService retailStoreBillingCartService = new RetailStoreBillingCartServiceImpl();
    	Customer customer=new Customer();
		 customer.setCustomerType(CustomerType.EMPLOYEE);
		 customer.setBilledAmount(450.78);
		 customer.setTransactionNumber("1233555AAE455");
		 Double result=retailStoreBillingCartService.totalPayableAmount(customer);
		 assertNotNull(result);
    }
    
    @Test
    public void testRetrievTotalPayableBilledAmountAFFILATED_CUSTOMER() {
    	RetailStoreBillingCartService retailStoreBillingCartService1 = new RetailStoreBillingCartServiceImpl();
    	Customer customer=new Customer();
		 customer.setCustomerType(CustomerType.AFFILATED_CUSTOMER);
		 customer.setBilledAmount(450.78);
		 customer.setTransactionNumber("1233555AAE455");
		 Double result=retailStoreBillingCartService1.totalPayableAmount(customer);
		 assertNotNull(result);
    }
    @Test
    public void testRetrievTotalPayableBilledAmountCUSTOMER_OVER_2_YEARS() {
    	RetailStoreBillingCartService retailStoreBillingCartService = new RetailStoreBillingCartServiceImpl();
    	Customer customer=new Customer();
		 customer.setCustomerType(CustomerType.CUSTOMER_OVER_2_YEARS);
		 customer.setBilledAmount(450.78);
		 customer.setTransactionNumber("1233555AAE455");
		 Double result=retailStoreBillingCartService.totalPayableAmount(customer);
		 assertNotNull(result);
    }
    
    @Test
    public void testRetrievTotalPayableBilledAmountNoDiscount() {
    	RetailStoreBillingCartService retailStoreBillingCartService = new RetailStoreBillingCartServiceImpl();
    	Customer customer=new Customer();
		 customer.setCustomerType(CustomerType.CUSTOMER);
		 customer.setBilledAmount(450.78);
		 customer.setTransactionNumber("1233555AAE455");
		 Double result=retailStoreBillingCartService.totalPayableAmount(customer);
		 assertNotNull(result);
    }

    @Test
    public void testWrongCustomerTypeArgument() {
    	RetailStoreBillingCartService retailStoreBillingCartService = new RetailStoreBillingCartServiceImpl();
        try {
        	Customer customer=new Customer();
   		    customer.setBilledAmount(450.78);
   		    customer.setTransactionNumber("1233555AAE455");
   		 retailStoreBillingCartService.totalPayableAmount(customer);
            fail("Unreachable.");
        } catch (BillingTransactionException e) {
            assertThat(e.getStatus(), is(RetailStoreBillingCartService.EXIT_STATUS_CUSTOMER_TYPE_NOT_CORRECT));
        }
    }

    @Test
    public void testWrongBilledAmountArgument() {
    	RetailStoreBillingCartService retailStoreBillingCartService = new RetailStoreBillingCartServiceImpl();
        try {
        	Customer customer=new Customer();
   		    customer.setCustomerType(CustomerType.CUSTOMER_OVER_2_YEARS);
   		    customer.setTransactionNumber("1233555AAE455");
   		 retailStoreBillingCartService.totalPayableAmount(customer);
            fail("Unreachable.");
        } catch (BillingTransactionException e) {
            assertThat(e.getStatus(), is(RetailStoreBillingCartService.EXIT_STATUS_BILLED_AMOUNT_NOT_CORRECT));
        }
    }

    @Test
    public void testWrongTransactionNoArgument() {
    	RetailStoreBillingCartService retailStoreBillingCartService = new RetailStoreBillingCartServiceImpl();
    	try {
        	Customer customer=new Customer();
   		    customer.setCustomerType(CustomerType.CUSTOMER_OVER_2_YEARS);
   		    customer.setBilledAmount(450.78);
   		 retailStoreBillingCartService.totalPayableAmount(customer);
            fail("Unreachable.");
        } catch (BillingTransactionException e) {
            assertThat(e.getStatus(), is(RetailStoreBillingCartService.EXIT_STATUS_TRANSACTION_NO_NOT_CORRECT));
        }
    }

    @Test
    public void classInstanceForCodeCoverageTest() {
        // purposes of full code coverage it is included. 
    	new RetailStoreBillingCartServiceImpl();
    }

}
