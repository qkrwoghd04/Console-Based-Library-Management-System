package Exercise.sales;

public class OrderServiceComposition {
  public static void main(String[] args) {
    Customer c = new Customer("Jayden", false);
    Order o = new Order(c);

    o.SendMessage();
  }
}
