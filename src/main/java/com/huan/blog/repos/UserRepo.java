package com.huan.blog.repos;

import com.huan.blog.models.User;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;


@Transactional
public interface UserRepo extends CrudRepository<User, Integer> {
  User findByUsername(String username);
}
