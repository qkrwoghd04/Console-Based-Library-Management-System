package Exercise.Behavior_State_MP3;

public class MP3PlayerContext {
  MP3State mp3State;

  MP3PlayerContext(MP3State mp3state){
    this.mp3State = mp3state;
  }

  void play(){
    mp3State.pressPlay(this);
  }

  void setState(MP3State mp3State){
    this.mp3State = mp3State;
  }

  public MP3State getState(){
    return mp3State;
  }
}
