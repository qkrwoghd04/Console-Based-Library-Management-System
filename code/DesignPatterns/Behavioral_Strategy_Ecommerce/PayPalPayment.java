package Exercise.StrategyDesign_Ecommerce;

public class PayPalPayment implements PaymentStrategy{
  
  @Override
  public void pay(double amount){
    //algorithm A 
    System.out.println("Paid : " + amount * 1.4);
  }
}
