package service;

import model.User;

public interface PostService {
    String addPost();
    void getAllPost(User currentUser);
    String update(long id, User currentUser);
    String deletePost(long id);
    void  getAllPostByUserId(long id);
}
