package com.huan.blog.service;

import com.huan.blog.models.User;


public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
