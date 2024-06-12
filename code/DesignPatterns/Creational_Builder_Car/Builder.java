package Exercise.BuilderPracticeCar;

public interface Builder {
  void reset();
  void setSeats(int seat);
  void setEngine(String engine);
  void setTripComputer(boolean tripcomputer);
  void setGPS(boolean gps);
}
