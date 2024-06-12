package Exercise.FactoryPracticeRestaurant;

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
