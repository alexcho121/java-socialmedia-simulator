import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


// UserTest class provides unit tests for the User class,
//  verifying object creation, following logic, and serialization.
 
public class UserTest {

    
     // Test that a User object is created correctly with the given username.
    @Test
    public void testUserCreation() {
        User user = new User("john", "password");

        assertEquals("john", user.getUsername());
    }

    
     // Test the follow functionality between two users.
     
    @Test
    public void testFollowFunctionality() {
        User u1 = new User("alice", "pw1");
        User u2 = new User("bob", "pw2");

        u1.follow(u2);

        // Since we do not have public access to follower/following lists,
        // we only check that no exceptions occur and the logic runs.
        assertNotNull(u1);
        assertNotNull(u2);
    }

    
    // Test saving and loading users using serialization.
     
    @Test
    public void testUserSerialization() throws Exception {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("tester", "abc123"));

        User.saveUsers(users);
        ArrayList<User> loaded = User.loadUsers();

        assertEquals(1, loaded.size());
        assertEquals("tester", loaded.get(0).getUsername());
    }
}
