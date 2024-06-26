package DesignPatterns.Structural_Decorator_Cafe;

public class NormalCoffee implements Coffee{

  @Override
  public double getCost(){
    return 10.0;
  }

  @Override
  public String getDescription(){
    return "The cost is " + getCost() + "\n" + "Normal Coffee";
  }
}
