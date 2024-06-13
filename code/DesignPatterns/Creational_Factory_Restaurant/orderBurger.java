package DesignPatterns.Creational_Factory_Restaurant;

public class orderBurger {
  public static void main(String[] args) {
    Restaurant beefrestaurant = new BeefBurgerRestaurant();
    Burger beef = beefrestaurant.orderBurger();
    System.out.println("Beef burger ordered.");
    
    Restaurant veggierestaurant = new VeggieBurgerRestaurant();
    Burger veggie = veggierestaurant.orderBurger();
    System.out.println("Veggie burger ordered.");
    
    Restaurant chickenrestaurant = new ChickenBurgerRestaurant();
    Burger chicken = chickenrestaurant.orderBurger();
    System.out.println("Chicken burger ordered.");
  }
}
