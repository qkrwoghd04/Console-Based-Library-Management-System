package library;

import java.util.HashMap;
import java.util.Map;

// Using singleton pattern 
// The constructor of the class is declared as private to prevent instantiation of the class from the outside
public class DatabaseConnection {
  private static DatabaseConnection instance;
  private Map<String, User> users;

  private DatabaseConnection(){
    users = new HashMap<>();
  }

  public static DatabaseConnection getInstance(){
    if(instance == null){
      instance = new DatabaseConnection();
    }
    return instance;
  }

  public void addUser(User user){
    users.put(user.getName(), user);
  }

  public User getUser(String name){
    return users.get(name);
  }
}
