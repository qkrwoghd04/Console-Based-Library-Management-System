package DesignPatterns.Structural_Decorator_Robot;

public class ChineseRobot implements Robot{
  @Override
  public void move(int x, int y , int speed){
    System.out.println("Chinese Robot moved to " + x + " and " + y + ",Speed: " + speed);
  }

  @Override
  public void cook(){
    System.out.println("Cooking Chinese food...");
  }
}
