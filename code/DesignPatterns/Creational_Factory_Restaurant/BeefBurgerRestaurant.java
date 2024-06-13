package DesignPatterns.Creational_Factory_Restaurant;

public class BeefBurgerRestaurant extends Restaurant{

  @Override
  public Burger createBurger(){
    return new BeefBurger();
  }
}
