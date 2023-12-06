package service.impl;

import db.DataBase;
import model.Post;
import model.User;
import service.PostService;

import java.util.Scanner;

public class PostServiceImpl implements PostService {

    @Override
    public String addPost() {
        Scanner scanner = new Scanner(System.in);
        Post post = new Post();
        post.setId(Generator.genera());
        while (true) {
            System.out.print("enter URL: ");
            String url = scanner.nextLine();
            if (!url.isEmpty()) {
                post.setImageUrl(url);
                break;
            } else System.out.println("ne doljen byt pustym");
        }
        while (true) {
            System.out.print("enter Description: ");
            String url = scanner.nextLine();
            if (!url.isEmpty()) {
                post.setDescription(url);
                break;
            } else System.out.println("ne doljen byt pustym");
        }
        for (User user : DataBase.users) {
            user.posts.add(post);
        }
        return "Successfully added";
    }

    @Override
    public void getAllPost(User currentUser) {
        System.out.println(currentUser.posts);
    }

    @Override
    public String update(long id, User currentUser) {
        System.out.print("enter new Url: ");
        String name = new Scanner(System.in).nextLine();
        if (currentUser.getId() == id) {
            for (Post post : currentUser.posts) {
                post.setImageUrl(name);
            }
        }
        return "Successfully updated";
    }

    @Override
    public String deletePost(long id) {
        for (User user : DataBase.users) {
            user.posts.removeIf(post -> post.getId() == id);
        }
        return "Success deleted";
    }

    @Override
    public void getAllPostByUserId(long id) {
        for (User user : DataBase.users) {
            if (user.getId() == id) {
                System.out.println(user.posts);
            }
        }
    }
}
