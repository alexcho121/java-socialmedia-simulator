
public class Main {
    public static void main(String[] args) {
        try {
            App app = new App();

            User alice = new User("Team: VCC", "1234");
            app.addUser(alice);

            // Create a post by the user
            Post p1 = new Post(alice, "This is MQGram!");
            app.addPost(p1);

            // Add a comment to the post
            Comment c1 = new Comment(alice, "We made it successfully");
            p1.addComment(c1);

            // Save users and posts/comments to files
            User.saveUsers(app.getUsers());
            app.savePostsAndComments("data/posts.dat");

            // Reload everything from files
            App loadedApp = new App();
            loadedApp.getUsers().addAll(User.loadUsers());
            loadedApp.loadPostsAndComments("data/posts.dat");

            // Print out the loaded posts and comments
            loadedApp.printAllPosts();
        } catch (Exception e) {
            // Print any exceptions that occur during the process
            e.printStackTrace();
        }
    }
}
