package DesignPatterns.Creational_Builder_Car;

public class Director {
  public void constructSportsCar(Builder builder){
    builder.reset();
    builder.setSeats(4);
    builder.setEngine("8L");
    builder.setTripComputer(true);
    builder.setGPS(true);
  }
}
