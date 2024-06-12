package Exercise.Behavior_State_MP3;

public class Client {
  public static void main(String[] args) {
    MP3PlayerContext player = new MP3PlayerContext(new StandbyState());
    player.play();
    player.play();
  }
}
