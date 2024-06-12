package Exercise.BuilderPracticeCar;

public class Car {
  int id;
  String brand;
  String model;
  String color;
  int door;
  int seat;
  String engine;
  int height;
  boolean tripcomputer;
  boolean gps;

  
  Car(){
    this.id = 0;
    this.brand = "";
    this.model = "";
    this.color = "";
    this.door = 0;
    this.seat = 0;
    this.engine = "";
    this.height = 0;
    this.tripcomputer = false;
    this.gps = false;
  }

  @Override
    public String toString() {
        return "Car{id=" + id + 
               ", brand='" + brand + '\'' + 
               ", model='" + model + '\'' + 
               ", color='" + color + '\'' + 
               ", door='" + door + '\'' + 
               ", seat='" + seat + '\'' + 
               ", engine='" + engine + '\'' + 
               ", height='" + height + '\'' + 
               ", tripcomputer='" + tripcomputer + '\'' + 
               ", gps='" + gps + '\'' + 
               '}';
    }
}
