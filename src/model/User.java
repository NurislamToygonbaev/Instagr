package model;

import enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String fullName;
    private Gender gender;
    private int age;
    private String email;
    private String password;
    public List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(long id, String fullName, Gender gender, int age, String email, String password, List<Post> posts) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User: " +
                "id= '" + id + '\'' +
                "fullName='" + fullName + '\'' +
                "gender=" + gender +
                "age=" + age +
                "email='" + email + '\'' +
                "posts=" + posts +
                "\n\n";
    }
}
