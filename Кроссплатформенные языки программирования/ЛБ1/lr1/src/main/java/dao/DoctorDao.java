package dao;

import models.Doctor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DoctorDao {

    public Doctor findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Doctor.class, id);
    }

    public void save(Doctor doctor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(doctor);
        tx1.commit();
        session.close();
    }

    public void update(Doctor doctor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(doctor);
        tx1.commit();
        session.close();
    }

    public void delete(Doctor doctor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(doctor);
        tx1.commit();
        session.close();
    }

    public List<Doctor> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Doctor> doctors = (List<Doctor>)  session.createQuery("From Doctor").list();
        session.close();
        return doctors;
    }


}
