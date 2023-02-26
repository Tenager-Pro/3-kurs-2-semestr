package dao;

import models.Contract;
import models.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class PatientDao {

    public Patient findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Patient.class, id);
    }

    public void save(Patient patient) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(patient);
        tx1.commit();
        session.close();
    }

    public void update(Patient patient) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(patient);
        tx1.commit();
        session.close();
    }

    public void delete(Patient patient) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(patient);
        tx1.commit();
        session.close();
    }

//    public Contract findContractById(int id) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Contract.class, id);
//    }

    public List<Patient> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Patient> patients = (List<Patient>)  session.createQuery("FROM Patient").list();
        session.close();
        return patients;
    }
}