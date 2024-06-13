package DesignPatterns.Structural_Decorator_Cafe;

public class Client {
  public static void main(String[] args) {
    Coffee coffee = new AddMilk(new NormalCoffee());
    
    System.out.println(coffee.getDescription());

  }
}
