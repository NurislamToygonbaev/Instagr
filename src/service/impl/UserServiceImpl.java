package service.impl;

import db.DataBase;
import enums.Gender;
import model.User;
import service.UserService;

import java.util.Scanner;

public class UserServiceImpl implements UserService {
    @Override
    public User register() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        user.setId(Generator.generaUser());
        while (true) {
            System.out.print("enter full name: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                user.setFullName(name);
                break;
            } else System.err.println("pusto");
        }
        while (true){
            System.out.print("enter gender (m/f): ");
            String gen = scanner.nextLine();
            if (gen.equalsIgnoreCase("m")) {
                user.setGender(Gender.MALE);
                break;
            } else if (gen.equalsIgnoreCase("f")) {
                user.setGender(Gender.FEMALE);
                break;
            } else System.out.println("incorrect");
        }
        while (true){
            try {
                System.out.print("enter age: ");
                int age = new Scanner(System.in).nextInt();
                if (age > 0){
                    user.setAge(age);
                    break;
                } else System.out.println("ters mumkun emes");
            } catch (Exception e){
                System.err.println("enter Integer valid");
            }
        }
        while (true){
            System.out.print("enter login: ");
            String login = scanner.nextLine();
            if (uniLog(login) == 1 && login.length() > 3){
                user.setEmail(login);
                break;
            } else System.out.println("invalid");
        }
        while (true){
            System.out.print("enter password: ");
            String pass = scanner.nextLine();
            if (pass.length() > 3){
                user.setPassword(pass);
                break;
            }else System.out.println("write more 4 symbol");
        }
        DataBase.users.add(user);
        return null;
    }

    @Override
    public User login() {
        Scanner scanner = new Scanner(System.in);
            System.out.print("enter login: ");
            String login = scanner.nextLine();

            System.out.print("enter password: ");
            String pass = scanner.nextLine();

        for (User user : DataBase.users) {
            if (login.equalsIgnoreCase(user.getEmail()) && pass.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public void getUserByEmail(String email) {
        for (User user : DataBase.users) {
            if (user.getEmail().equalsIgnoreCase(email)){
                System.out.println(user);
            }
        }
    }

    @Override
    public void getAllUsers() {
        for (User user : DataBase.users) {
            System.out.println(user);
        }
    }


    private static int uniLog(String log){
        for (User user : DataBase.users) {
            if (user.getEmail().equalsIgnoreCase(log)){
                return 0;
            }
        }
        return 1;
    }
}
