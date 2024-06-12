package Exercise.DecoratorRobot;

public class KoreanRobot implements Robot{
  @Override
  public void move(int x, int y, int speed){
    System.out.println("Korean Robot moved to " + x + " and " + y);
  }

  @Override
  public void cook(){
    System.out.println("Cooking korean food...");
  }
}
