package com.gy.love.loveapi.repository;

import com.gy.love.loveapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gaoyun
 * 2018/4/18 11:01
 * 描述:
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String userName);
}
