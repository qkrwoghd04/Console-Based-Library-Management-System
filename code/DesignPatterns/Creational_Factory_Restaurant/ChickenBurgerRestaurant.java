package Exercise.FactoryPracticeRestaurant;

public class ChickenBurgerRestaurant extends Restaurant{
  
  @Override
  public Burger createBurger(){
    ChickenBurger chickenBurger = new ChickenBurger();
    return chickenBurger;
  }
}

