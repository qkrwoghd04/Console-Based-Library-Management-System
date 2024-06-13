package DesignPatterns.Creational_Builder_Car;

public class Client {
  public static void main(String[] args) {
    Director director = new Director();

    CarBuilder carBuilder = new CarBuilder();
    director.constructSportsCar(carBuilder);
    Car car = carBuilder.getResult();
    System.out.println("Car built: " + car.toString());
  }
}
