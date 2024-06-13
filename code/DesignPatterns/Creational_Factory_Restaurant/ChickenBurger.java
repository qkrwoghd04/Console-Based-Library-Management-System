package DesignPatterns.Creational_Factory_Restaurant;

public class ChickenBurger implements Burger{
  String name;

  ChickenBurger(){
    this.name = "Chicken";
  }

  @Override
  public void prepare(){
    System.out.println("Making a chicken burger...");
  }
}
