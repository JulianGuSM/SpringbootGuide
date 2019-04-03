package com.example.demo.db1.dao;

import com.example.demo.beans.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author : Julian
 * @date : 2019/4/3 16:28
 */
@Qualifier("db1SqlSessionTemplate")
public interface UserDao {
    /**
     * @param name user's name
     * @return User
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findUserByName(String name);
}
