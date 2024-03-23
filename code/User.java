public abstract class User{
  private String name;

  public User(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public abstract void displayInfo();
}


class Student extends User{
  public Student(String name){
    super(name);
  }

  @Override
  public void displayInfo(){
    System.out.println("Student Name: " + getName());
  }
}

class Faculty extends User{
  public Faculty(String name){
    super(name);
  }

  @Override
  public void displayInfo(){
    System.out.println("Faculty name: "+ getName());
  }
}

class userFactory{
  public static User createUser(String type, String name){
    switch(type.toLowerCase()){
      case "student":
        return new Student(name);

      case "faculty":
        return new Faculty(name);
        
      default:
        throw new IllegalArgumentException("Unknown user type.");
    }
  }
}
