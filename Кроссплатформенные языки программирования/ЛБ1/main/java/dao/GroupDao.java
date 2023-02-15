package dao;

import model.Group;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class GroupDao {
    public Group findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Group.class, id);
    }

    public void save(Group group) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(group);
        tx1.commit();
        session.close();
    }

    public void update(Group group) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(group);
        tx1.commit();
        session.close();
    }

    public void delete(Group group) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(group);
        tx1.commit();
        session.close();
    }

    public List<Group> findAll() {
        List<Group> groups = (List<Group>)  HibernateUtil.getSessionFactory().openSession().createQuery("From groups").list();
        return groups;
    }
}
