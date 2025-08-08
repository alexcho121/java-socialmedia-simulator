import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


 //CommentTest class provides unit tests for the Comment class
 //to validate comment creation, replies, and recursive reply structure.
 
public class CommentTest {

    
    // Test the creation of a comment with content and author.
     
    @Test
    public void testCreateComment() {
        User user = new User("Alice", "pass");
        Comment comment = new Comment(user, "This is a comment.");

        assertNotNull(comment.getCommentId());
        assertEquals("This is a comment.", comment.getContent());
        assertEquals("Alice", comment.getAuthor().getUsername());
        assertNotNull(comment.getTimestamp());
    }

    
     //Test adding a reply to a comment and validating its content.
     
    @Test
    public void testAddReply() {
        User author = new User("Bob", "pw");
        Comment original = new Comment(author, "Main comment");
        Comment reply = original.addReply(author, "Replying to comment");

        assertEquals(1, original.getReplies().size());
        assertEquals("Replying to comment", original.getReplies().get(0).getContent());
        assertSame(reply, original.getReplies().get(0));
    }

    
    // Test a recursive reply structure spanning multiple levels.
     
    @Test
    public void testRecursiveReply() {
        User author = new User("Jane", "pw");
        Comment c1 = new Comment(author, "Level 1");
        Comment c2 = c1.addReply(author, "Level 2");
        Comment c3 = c2.addReply(author, "Level 3");

        assertEquals(1, c1.getReplies().size());
        assertEquals(1, c1.getReplies().get(0).getReplies().size());
        assertEquals("Level 3", c1.getReplies().get(0).getReplies().get(0).getContent());
    }
}
