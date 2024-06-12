package Exercise.Behavior_State_MP3;

public class PlayingState implements MP3State{
  public void pressPlay(MP3PlayerContext context){
    System.out.println("I am already in PLAYING state");
  }
}
