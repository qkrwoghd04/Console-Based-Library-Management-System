package DesignPatterns.Structural_Decorator_Robot;

public class Client {
  public static void main(String[] args) {
    PlayRobot play = new PlayRobot();

    Robot r = new KoreanRobot();
    Robot rr = new RationalRobotDecorator(r, true);
    Robot sr = new SmartRobotDecorator(rr, true);
    // play.AddRobot(rr);
    play.AddRobot(sr);

    play.AllRobotsCook();
  }
}
