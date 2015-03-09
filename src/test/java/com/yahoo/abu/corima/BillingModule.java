package com.yahoo.abu.corima;

public class BillingModule extends AbstractModule {
    @Override 
    protected void configure() {
      bind(TransactionLog.class).to(DatabaseTransactionLog.class);
      bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
      bind(BillingService.class).to(RealBillingService.class);
    }

  }