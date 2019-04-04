package com.huan.blog.repos;

import com.huan.blog.models.Blog;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface BlogRepo extends CrudRepository<Blog, Integer> {

}
