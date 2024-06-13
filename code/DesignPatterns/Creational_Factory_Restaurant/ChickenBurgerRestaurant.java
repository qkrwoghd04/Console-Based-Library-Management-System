package DesignPatterns.Creational_Factory_Restaurant;

public class ChickenBurgerRestaurant extends Restaurant{
  
  @Override
  public Burger createBurger(){
    ChickenBurger chickenBurger = new ChickenBurger();
    return chickenBurger;
  }
}

