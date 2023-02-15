package dao;

import model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class TeacherDao {
    public Teacher findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Teacher.class, id);
    }

    public void save(Teacher teacher) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(teacher);
        tx1.commit();
        session.close();
    }

    public void update(Teacher teacher) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(teacher);
        tx1.commit();
        session.close();
    }

    public void delete(Teacher teacher) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(teacher);
        tx1.commit();
        session.close();
    }

    public List<Teacher> findAll() {
        List<Teacher> teachers = (List<Teacher>)  HibernateUtil.getSessionFactory().openSession().createQuery("From teachers").list();
        return teachers;
    }
}
