package Exercise.BuilderPracticeCar;

public class CarBuilder implements Builder{
  private Car car;

  @Override
  public void reset(){
    car = new Car();
  }

  @Override
  public void setSeats(int seat){
    car.seat = seat;
  }

  @Override
  public void setEngine(String engine){
    car.engine = engine;
  }

  @Override
  public void setTripComputer(boolean tripcomputer){
    car.tripcomputer = tripcomputer;
  }

  @Override
  public void setGPS(boolean gps){
    car.gps = gps;
  }
  
  public Car getResult(){
    return car;
  }
}
