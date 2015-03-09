package com.yahoo.abu.corima;
import java.lang.reflect.InvocationTargetException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RealBillingServiceTest extends TestCase {
    @Override public void setUp() {
    }

    @Override public void tearDown() {
    }

    public void testSuccessfulInject() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
      Injector injector = Guice.createInjector(new BillingModule());
      BillingService billingService = injector.getInstance(BillingService.class);

      assertTrue(billingService instanceof RealBillingService);
      assertTrue(((RealBillingService)billingService).processor instanceof PaypalCreditCardProcessor);
      assertTrue(((RealBillingService)billingService).transactionLog instanceof DatabaseTransactionLog);
    }
  }