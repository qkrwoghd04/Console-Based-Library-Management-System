package DesignPatterns.Structural_Decorator_Cafe;

public class AddMilk extends CoffeeDecorator{

  public AddMilk(Coffee coffee){
    super(coffee);
  }

  @Override
  public double getCost(){
    return super.getCost() + 1.5;
  }
  
  @Override
  public String getDescription(){
    return super.getDescription() + ",Add milk";
  }
}
