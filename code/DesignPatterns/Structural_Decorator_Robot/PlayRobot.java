package Exercise.DecoratorRobot;
import java.util.*;

class PlayRobot {
  private List<Robot> robots = new ArrayList<Robot>();

  public void AddRobot(Robot r){
    robots.add(r);
  }

  public void AllRobotsCook(){
    robots.stream().forEach(r -> r.cook());
  }
}
