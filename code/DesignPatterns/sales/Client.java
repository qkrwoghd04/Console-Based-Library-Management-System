package DesignPatterns.sales;

public class Client {
  public static void main(String[] args) {
    Customer c = new Customer("Jayden", false);
    Order o = new Order(c);

    o.SendMessage();
  }
}
