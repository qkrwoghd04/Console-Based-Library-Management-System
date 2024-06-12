package Exercise.DecoratorRobot;

public class SmartRobotDecorator extends RobotDecorator{
  private boolean smart;

  protected SmartRobotDecorator(Robot r, boolean smart){
    super(r);
    this.smart = smart;
  }

  @Override
  public void move(int x, int y, int speed){
    super.move(x,y,speed);
  }

  @Override
  public void cook(){
    if(smart){
      System.out.println("Smart cooking...");
    }else{
      System.out.println("Typical cooking...");
    }
  }
}
