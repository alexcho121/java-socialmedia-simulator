import java.io.Serializable;
import java.util.ArrayList;


public class Post implements Serializable {
    

    private final String postId;
    private final String content;
    private final User author;
    private final ArrayList<Comment> comments;

    
     // Constructor: creates a new Post with the given author and content.
    public Post(User author, String content) {
        this.postId = "post_" + System.currentTimeMillis();
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    
    public void addComment(Comment c) {
        comments.add(c);
    }

     // Returns the post ID.
     
    public String getPostId() {
        return postId;
    }

    
     //Returns the content of the post.
     
    public String getContent() {
        return content;
    }

    
     //Returns the author (User) who created the post.
     
    public User getAuthor() {
        return author;
    }

    
     //Returns the list of comments on this post.
     
    public ArrayList<Comment> getComments() {
        return comments;
    }
}
