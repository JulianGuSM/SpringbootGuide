package com.example.demo.interfaces;

import com.example.demo.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author : Julian
 * @date : 2019/3/8 9:24
 *
 * Spring Data JPA focuses on using JPA to store data in a relational database
 * 其最引人注目的功能是能够在运行时从存储库接口自动创建存储库实现。
 * Spring Data JPA also allows you to define other query methods by simply declaring their method signature.
 * In the case of CustomerRepository, this is shown with a findByLastName() method.
 *
 * n a typical Java application, you’d expect to write a class that implements CustomerRepository.
 * But that’s what makes Spring Data JPA so powerful: You don’t have to write an implementation of the repository interface
 *  Spring Data JPA creates an implementation dynamically when you run the application.
 */

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
