package DesignPatterns.Structural_Decorator_Robot;

public class RobotDecorator implements Robot{
  private Robot r;

  protected RobotDecorator(Robot r){
    this.r = r;
  }

  @Override
  public void move(int x, int y, int speed){
    r.move(x, y, speed);
  }

  @Override
  public void cook(){
    r.cook();
  }
}
