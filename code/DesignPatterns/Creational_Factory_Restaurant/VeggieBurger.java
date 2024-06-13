package DesignPatterns.Creational_Factory_Restaurant;

public class VeggieBurger implements Burger{
  String name;

  public VeggieBurger(){
    this.name = "Veggie";
  }
  @Override
  public void prepare(){
    System.out.println("Making Veggie Burger");
  }
}
