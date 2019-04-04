package com.huan.blog.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
