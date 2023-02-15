package dao;

import model.BaseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class BaseDao {
    public BaseEntity findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(BaseEntity.class, id);
    }

    public void save(BaseEntity entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entity);
        tx1.commit();
        session.close();
    }

    public void update(BaseEntity entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entity);
        tx1.commit();
        session.close();
    }

    public void delete(BaseEntity entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(entity);
        tx1.commit();
        session.close();
    }
}
