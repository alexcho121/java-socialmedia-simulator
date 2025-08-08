import java.io.*;
import java.util.ArrayList;

public class App {
    
    private final ArrayList<User> users;
    private final ArrayList<Post> posts;

    // Constructor
    public App() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
    }

    // Adds a new user to the app
    public void addUser(User u) {
        users.add(u);
    }

    // Adds a new post to the app
    public void addPost(Post p) {
        posts.add(p);
    }

    
    public ArrayList<User> getUsers() {
        return users;
    }

    
    public ArrayList<Post> getPosts() {
        return posts;
    }

    // Finds a user by their username
    public User findUserByUsername(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(name)) {
                return users.get(i);
            }
        }
        return null;
    }

    // Prints all posts and their comments
    public void printAllPosts() {
        System.out.println("==== MQGram Social Feed ====");
        System.out.println("Team: VCC (Viviana, Cho, Cao)\n");

        for (int i = 0; i < posts.size(); i++) {
            Post p = posts.get(i);
            System.out.println("Post by " + p.getAuthor().getUsername() + ": " + p.getContent());
            ArrayList<Comment> comments = p.getComments();
            for (int j = 0; j < comments.size(); j++) {
                Comment c = comments.get(j);
                System.out.println(" - " + c.getAuthor().getUsername() + ": " + c.getContent());
            }
        }
    }

    // Saves all posts (including comments) 
    public void savePostsAndComments(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(posts);
        }
    }

    // Loads all posts
    public void loadPostsAndComments(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            ArrayList<Post> loaded = (ArrayList<Post>) ois.readObject();
            posts.clear();
            posts.addAll(loaded);
        }
    }
}
