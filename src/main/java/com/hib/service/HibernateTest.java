package com.hib.service;


import com.hib.dto.User;
import com.hib.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateTest {
    public static void main(String[] args) {

        HibernateUtil hibernateUtil = new HibernateUtil();
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        User user1 = new User();
        user1.setLastName("Smith");
        user1.setFirstName("John");
        user1.setAge((byte)42);
        user1.setGender('M');

        User user2 = new User();
        user2.setLastName("Bauer");
        user2.setFirstName("Mary");
        user2.setAge((byte)38);
        user2.setGender('F');

        session.beginTransaction();
        session.save(user1);
        session.save(user2);
        session.getTransaction().commit();
        session.close();

        User user = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        user = (User)session.get(User.class,1L);
        System.out.println(user);
        session.close();

        if(sessionFactory != null)
            sessionFactory.close();
    }

}
