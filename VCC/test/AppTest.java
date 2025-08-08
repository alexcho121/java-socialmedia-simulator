import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class AppTest {

    
     //Test that a user and a post can be added to the app correctly.
    
    @Test
    public void testAddUserAndPost() {
        App app = new App();

        User user = new User("lucas", "pw");
        app.addUser(user);

        Post post = new Post(user, "First post!");
        app.addPost(post);

        assertEquals(1, app.getUsers().size());
        assertEquals(1, app.getPosts().size());
    }

    
     //Test that a user can be found by username.
     
    @Test
    public void testFindUserByUsername() {
        App app = new App();
        User user = new User("emily", "pw");
        app.addUser(user);

        User found = app.findUserByUsername("emily");
        assertNotNull(found);
        assertEquals("emily", found.getUsername());
    }

    
     // Test that printing posts with comments does not throw an exception.
     
    @Test
    public void testPrintAllPostsOutput() {
        App app = new App();
        User user = new User("dan", "pw");
        app.addUser(user);

        Post post = new Post(user, "Hello!");
        app.addPost(post);
        post.addComment(new Comment(user, "Nice post!"));

        assertDoesNotThrow(() -> app.printAllPosts());
    }
}
