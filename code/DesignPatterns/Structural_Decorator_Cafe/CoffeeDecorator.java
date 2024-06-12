package Exercise.DecoratorCafe;

public abstract class CoffeeDecorator implements Coffee{
  private Coffee coffee;

  protected CoffeeDecorator(Coffee coffee){
    this.coffee = coffee;
  }

  @Override
  public double getCost(){
    return coffee.getCost();
  }

  @Override
  public String getDescription(){
    return coffee.getDescription();
  }
}
