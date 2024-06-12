package Exercise.StrategyDesign_Ecommerce;

public class ShoppingCart {
  private PaymentStrategy paymentStrategy;


  public void setShoppingCart(PaymentStrategy paymentStrategy){
    this.paymentStrategy = paymentStrategy;
  }

  public void checkout(double amount){
    paymentStrategy.pay(amount);
  }
}
