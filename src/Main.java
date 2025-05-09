import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Kullanıcıları oluşturup listeye ekliyorum
        ArrayList<User> users = new ArrayList<>();
        User u1 = new User("Nisa1","nisaperi1@gmail.com",20);
        User u2 = new User("Nisa2","nisaperi2@gmail.com",15);
        User u3 = new User("Nisa3","nisaperi3@gmail.com",17);
        users.add(u1);
        users.add(u2);
        users.add(u3);

        //Kullanıcıların arkadaşlarını ekliyorum
        u1.addFriend(u2);
        u1.addFriend(u3);
        u2.addFriend(u3);
        u2.addFriend(u1);
        u3.addFriend(u1);
        u3.addFriend(u2);

        //Gonderi oluşturuyorum
        HashMap<String, LinkedList<Post>> allposts = new HashMap<>();
        Post p1= new Post("Content1");
        Post p2 = new Post("Content2");
        Post p3 = new Post("Content3");

        u1.addPost(p1);
        u2.addPost(p2);
        u3.addPost(p3);

        allposts.put(u1.username,u1.posts);
        allposts.put(u2.username,u2.posts);
        allposts.put(u3.username,u3.posts);

        //Begenileri ekliyorum
        p1.like(u1.username);
        p1.like(u2.username);
        p1.like(u3.username);
        p2.like(u1.username);
        p2.like(u3.username);
        p3.like(u1.username);

        //Begeni Sıralaması
        TreeMap<Integer,String> likes = new TreeMap<>();;

        for (User user : users){ //tum like sayılarını ekliyorum
            int totalLikes =0;
            for(Post post : user.posts){
                totalLikes+= post.getLikeCount();
            }
            likes.put(totalLikes,user.username);
        }

        //en yuksek bulma
        Map.Entry<Integer, String> enBegeni = likes.lastEntry();
        System.out.println("En begeni alan kullanıcı: " + enBegeni.getValue() + "Beğeni sayisi: " + enBegeni.getKey());

        //Kullanıcıları ve gönderileri listeleme

        System.out.println("\n*************************\n");
        Iterator<User> iterator_User = users.listIterator();
        while (iterator_User.hasNext()) {
            User user = iterator_User.next();
            System.out.println(user.username+":");
            for (Post p : user.posts) {
                System.out.println(p.content + "like:" + p.likes);
            }
            System.out.println("\n");
        }

        //18 Yas altı kullanıcılar

        UserFilter ageFilter = new UserFilter() {
            @Override
            public boolean filter(User user) {
                if(user.age<18){
                    return true;
                }
                return false;
            }
        };

        System.out.println("18 yaş altı kullanıcılar:");
        for (User user : users) {
            if (ageFilter.filter(user)) {
                System.out.println( user.username);
            }
        }
    }
}