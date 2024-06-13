package DesignPatterns.Behavioral_Strategy_Ecommerce;

public class Client {
  public static void main(String[] args) {
    ShoppingCart shoppingCart = new ShoppingCart();
    shoppingCart.setShoppingCart(new CreditCardPayment());
    shoppingCart.checkout(50);
  }
}
