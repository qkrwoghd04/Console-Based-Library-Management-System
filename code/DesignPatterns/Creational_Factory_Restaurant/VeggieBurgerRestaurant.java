package DesignPatterns.Creational_Factory_Restaurant;

public class VeggieBurgerRestaurant extends Restaurant{
  
  @Override
  public Burger createBurger(){
    return new VeggieBurger();
  }
}
