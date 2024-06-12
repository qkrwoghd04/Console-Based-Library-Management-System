package Exercise.Behavior_State_MP3;

public class StandbyState implements MP3State{
  public void pressPlay(MP3PlayerContext context){
    System.out.println("Playing...");
    context.setState(new PlayingState());
  }
}
