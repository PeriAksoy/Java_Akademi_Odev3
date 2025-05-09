import java.util.HashSet;

public class Post {
    String content;
    HashSet<String> likes = new HashSet<>();

    public Post(String content){
        this.content=content;
    }
    public void like(String username){
        likes.add(username);
    }
    public int getLikeCount(){
        return likes.size();
    }

}
