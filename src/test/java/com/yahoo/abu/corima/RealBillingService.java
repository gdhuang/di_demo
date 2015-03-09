package com.yahoo.abu.corima;

public class RealBillingService implements BillingService {
    public final CreditCardProcessor processor;
    public final TransactionLog transactionLog;

    @Inject
    public RealBillingService(CreditCardProcessor processor, TransactionLog transactionLog) {
      this.processor = processor;
      this.transactionLog = transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
      ChargeResult result = processor.charge(creditCard, order.getAmount());
      transactionLog.logChargeResult(result);

      return (Receipt) (result.wasSuccessful()
        ? Receipt.forSuccessfulCharge(order.getAmount())
        : Receipt.forDeclinedCharge(result.getDeclineMessage()));
    }
  }