import java.io.*;
import java.util.ArrayList;


 //Users can follow each other and are serializable for data persistence.
 
public class User implements Serializable {

    private final String username;
    private final String password;
    private final ArrayList<User> following;
    private final ArrayList<User> followers;

    
     //Constructor: Initializes a new user with a username and password.
     
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.following = new ArrayList<>();
        this.followers = new ArrayList<>();
    }

    
     //Makes this user follow another user.
     
    public void follow(User target) {
        if (!following.contains(target)) {
            following.add(target);
            target.followers.add(this);
        }
    }

    
     //Saves a list of users to a file using serialization.
     
    public static void saveUsers(ArrayList<User> users) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/users.txt"))) {
            oos.writeObject(users);
        }
    }

    
     //Loads a list of users from a file.
     
    public static ArrayList<User> loadUsers() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/users.txt"))) {
            return (ArrayList<User>) ois.readObject();
        }
    }

    
     //Returns the username of the user.
     
    public String getUsername() {
        return username;
    }
}