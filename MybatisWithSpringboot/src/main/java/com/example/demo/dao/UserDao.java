package com.example.demo.dao;

import com.example.demo.beans.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author : Julian
 * @date : 2019/4/3 9:55
 */
@Mapper
public interface UserDao {
    /**
     * 通过名字查询用户的所有信息
     * @param name 用户姓名
     * @return User
     */
    @Select("SELECT * FROM user WHERE name = #{name}")
    User findUserByName(@Param("name") String name);

    /**
     * 查询所有的用户信息
     * @return List<User>
     */
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    /**
     * 插入用户信息
     * @param name 用户姓名
     * @param age 用户年龄
     * @param money 用户账户余额
     */
    @Insert("INSERT INTO user(name, age, money) VALUES (#{name}, #{age}, #{money})")
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money);

    /**
     * 根据id更新用户信息
     * @param name 用户姓名
     * @param age 用户年龄
     * @param money 用户账户余额
     * @param id 用户id
     */
    @Update("UPDATE user SET name = #{name},age = #{age},money = #{money} WHERE id = #{id}")
    void updateUser(@Param("name") String name,@Param("age") Integer age,@Param("money") Double money,@Param("id") int id);

    /**
     * 根据用户id 删除用户信息
     * @param id 用户id
     */
    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(@Param("id") int id);
}
