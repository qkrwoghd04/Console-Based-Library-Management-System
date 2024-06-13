package DesignPatterns.Behavioral_Strategy_Ecommerce;

public class CreditCardPayment implements PaymentStrategy{
  
  @Override
  public void pay(double amount){
    //Algorithm B
    System.out.println("Paid : " + amount * 1.5);
  }
}
