package com.example.controller;

import com.example.entity.Address;
import com.example.entity.Person;
import com.example.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import javax.transaction.Transaction;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class SpringBootJDBCTemplate {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/api/insert")
    public String index(){
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {

//        entityTransaction.
            entityTransaction.begin();
//        Connection connection = dataSource.getConnection(); // (1)
            //            connection.setAutoCommit(false); // (1)
//            Person person = new Person();
//            person.setLastName("lllll");             person.setFirstName("aaaaa");            person.setId(12l);
//            entityManager.persist(person);
//            Address address = new Address();             address.setAddressLine1("1111");            address.setAddressLine2("2222");            address.setCountry("india");
//            address.setId(11l);            address.setPinCode(null);            address.setState("gujarat");            address.setCity("valsad");
//            entityManager.persist(address);
//            entityTransaction.commit();
        }catch (Exception ex){
            entityTransaction.rollback();
            return ex.toString();
        }
        return"data inserted Successfully";
    }
}
