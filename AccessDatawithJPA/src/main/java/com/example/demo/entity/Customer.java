package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author : Julian
 * @date : 2019/3/8 8:26
 *
 * this class is annotated with @Entity,indicating it is a JPA entity
 * 注释@Table指定了Entity所要映射带数据库表
 * 其中@Table(name="表名")用来指定映射表的表名
 * 注释@Entity和@Table一般一块使用，如果缺省@Table注释，系统默认采用实体类名作为映射表的表名。
 *
 *      Here we have a Customer Class with three attributes :id , firstName, lastName
 *      We have two constructors
 *      the default constructor only exists for the JPA,we won't use it directly,so we designate as protected
 *      the other constructor is the one we will use to create instances of Customer to be saved to the database
 *
 */

@Entity
public class Customer {

    /**
     * 注解@id和@GeneratedValue都是JPA的标准用法
     * JPA提供的四种标准用法为 TABLE , SEQUENCE , IDENTITY , AUTO.
     * 1.TABLE：使用一个特定的数据库表格来保存主键。
     * 2.SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
     * 3.IDENTITY：主键由数据库自动生成（主要是自动增长型）
     * 4.AUTO：主键由程序控制。
     *
     *
     *      The Customer’s id property is annotated with @Id so that JPA will recognize it as the object’s ID
     *
     *      The other two properties, firstName and lastName are left unannotated
     *      缺省@Culoumn,系统自动映射到数据库中与其同名的列
     *      当实体的属性与其映射的数据库表的列不同名时需要使用@Column 标注说明
     *
     *      The convenient toString() method will print out the customer’s properties
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String firstName;
    private String lastName;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
