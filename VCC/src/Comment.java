import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


 //The Comment class represents a comment on a post in MQGram.
 
public class Comment implements Serializable {

   
    private String commentId;
    private String content;
    private Date timestamp;
    private User author;
    private ArrayList<Comment> replies;

    
     //Constructor: creates a new Comment with an author and content.
    public Comment(User author, String content) {
        this.commentId = "comment_" + System.currentTimeMillis();
        this.content = content;
        this.timestamp = new Date();
        this.author = author;
        this.replies = new ArrayList<>();
    }

    
    // Adds a reply to this comment and returns the newly created Comment.
    
    public Comment addReply(User author, String text) {
        Comment reply = new Comment(author, text);
        replies.add(reply);
        return reply;
    }

    
    public String getCommentId() {
        return commentId;
    }

    
    public String getContent() {
        return content;
    }

    
    public User getAuthor() {
        return author;
    }

    
    public Date getTimestamp() {
        return timestamp;
    }

    
    public ArrayList<Comment> getReplies() {
        return new ArrayList<>(replies);
    }

    
     //Custom string representation of the comment for debugging or display.
     
    @Override
    public String toString() {
        String authorName = (author != null) ? author.getUsername() : "unknown";
        return "Comment{" +
                "id='" + commentId + '\'' +
                ", content='" + content + '\'' +
                ", author=" + authorName +
                ", timestamp=" + timestamp +
                ", replies=" + replies.size() +
                '}';
    }
}
