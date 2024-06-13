package DesignPatterns.Creational_Factory_Restaurant;

public class BeefBurger implements Burger{
  String name;

  public BeefBurger(){
    this.name = "Beef";
  }

  @Override
  public void prepare(){
    System.out.println("Making Beef Burger");
  }
}
