package com.example.demo.db2.dao;

import com.example.demo.beans.Money;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author : Julian
 * @date : 2019/4/3 16:33
 */
@Qualifier("db2SqlSessionTemplate")
public interface MoneyDao {
    /**
     * @param id money's id
     * @return Money
     */
    @Select("SELECT * FROM money WHERE id = #{id}")
    Money findMoneyById(@Param("id") int id);
}
