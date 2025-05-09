import sun.java2d.cmm.Profile;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.LinkedList;

public class User {

    String username;
    String email;
    int age;
    Profile profile;

    public User(String username, String email, int age){
        this.username=username;
        this.email=email;
        this.age=age;
        this.profile= new Profile();
    }

    HashSet<User> friends = new HashSet<>();
    LinkedList<Post> posts = new LinkedList<>();

    class Profile {

        String profile_picture;
        String bio;

    }
    public void addFriend(User user){
        friends.add(user);
    }
    public void addPost(Post post) {
        posts.add(post);
    }

}
