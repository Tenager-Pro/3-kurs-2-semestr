package dao;

import models.PatientCard;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class PatientCardDao {

    public PatientCard findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(PatientCard.class, id);
    }

    public void save(PatientCard patientCard) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(patientCard);
        tx1.commit();
        session.close();
    }

    public void update(PatientCard patientCard) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(patientCard);
        tx1.commit();
        session.close();
    }

    public void delete(PatientCard patientCard) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(patientCard);
        tx1.commit();
        session.close();
    }

    public List<PatientCard> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<PatientCard> patientCards = (List<PatientCard>)  session.createQuery("From PatientCard").list();
        session.close();
        return patientCards;
    }


}
