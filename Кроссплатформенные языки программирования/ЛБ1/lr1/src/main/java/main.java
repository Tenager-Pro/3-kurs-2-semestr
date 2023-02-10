package com.hib.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.hib.entities.Student;
import com.hib.init.Hibernateutil;

public class DemoFirst {

    public static void main(String[] args) {
        SessionFactory sessionFactory = Hibernateutil.getSeeionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = new Student();
        student.setFirstName("Bob");
        student.setAge(26);

        session.save(student);
        session.getTransaction().commit();

        session.close();
    }
}