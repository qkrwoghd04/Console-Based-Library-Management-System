package DesignPatterns.Structural_Decorator_Robot;

public class RationalRobotDecorator extends RobotDecorator{
  private boolean gender;

  public RationalRobotDecorator(Robot r, boolean gender){
    super(r);
    this.gender = gender;
  }

  @Override
  public void move(int x, int y, int speed){
    super.move(x,y,speed);
  }

  @Override
  public void cook(){
    if(gender){
      System.out.println("I will cook you a small portion");
    }else{
      System.out.println("I will cook you a big portion");
    }
    super.cook();
  }
}
