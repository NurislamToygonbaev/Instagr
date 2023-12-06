import model.User;
import service.PostService;
import service.UserService;
import service.impl.PostServiceImpl;
import service.impl.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanForNumber = new Scanner(System.in);
        User currentUser = null;
        UserService userService = new UserServiceImpl();
        PostService postService = new PostServiceImpl();

        outerLoop:
        while (true){
            outerMenu();
            switch (scanner.nextLine()){
                case "1" -> {
                    if (userService.register() == null){
                        System.out.println("successfully created!!!");
                    }
                }
                case "2" -> {
                    currentUser = userService.login();
                    if (currentUser != null){
                        System.out.println("welcome " + currentUser.getFullName());
                        innerLoop:
                        while (true){
                            innerMenu();
                            switch (scanner.nextLine()){
                                case "0" -> {break innerLoop;}
                                case "1" -> {
                                    System.out.print("enter email to search: ");
                                    String email = scanner.nextLine();
                                    userService.getUserByEmail(email);
                                }
                                case "2" -> userService.getAllUsers();
                                case "3" -> System.out.println(postService.addPost());
                                case "4" -> {
                                   try {
                                       System.out.print("enter id: ");
                                       long id = scanForNumber.nextLong();
                                       System.out.println(postService.deletePost(id));
                                   } catch (Exception e){
                                       System.out.println("invalid input");
                                   }
                                }
                                case "5" -> postService.getAllPost(currentUser);
                                case "6" -> {
                                    try {
                                        System.out.print("enter id: ");
                                        long id = scanForNumber.nextLong();
                                        postService.getAllPostByUserId(id);
                                    } catch (Exception e){
                                        System.out.println("invalid input");
                                    }
                                }
                                case "7" -> {
                                    try {
                                        System.out.print("enter id: ");
                                        long id = scanForNumber.nextLong();
                                        System.out.println(postService.update(id, currentUser));
                                    } catch (Exception e){
                                        System.out.println("invalid input");
                                    }
                                }
                                default -> System.out.println("enter right choice!!!");
                            }
                        }
                    }
                }
                case "3" -> {break outerLoop;}
                default -> System.out.println("incorrect choice!!!");
            }
        }
    }

    private static void outerMenu(){
        System.out.println("""
                1. register
                2. login
                3. exit
                """);
    }

    private static void innerMenu(){
        System.out.println("""
                0. exit
                1. get user by email
                2. get all users
                3. add post
                4. delete post
                5. get all post
                6. get all post user's by id
                7. update post
                """);
    }
}