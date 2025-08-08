import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


// PostTest class provides unit tests for the Post class
// to validate post creation and adding comments functionality.

public class PostTest {

    
     // Test that a Post object is correctly created with content and author.
     
    @Test
    public void testPostCreation() {
        User author = new User("julia", "pw1");
        Post post = new Post(author, "This is a post.");

        assertEquals("This is a post.", post.getContent());
        assertEquals("julia", post.getAuthor().getUsername());
        assertNotNull(post.getPostId());
    }

    
    //  Test that a comment can be added to a post and is stored correctly.
     
    @Test
    public void testAddCommentToPost() {
        User user = new User("sam", "pw2");
        Post post = new Post(user, "Post content");
        Comment comment = new Comment(user, "Nice one!");

        post.addComment(comment);

        ArrayList<Comment> comments = post.getComments();
        assertEquals(1, comments.size());
        assertEquals("Nice one!", comments.get(0).getContent());
    }
}
