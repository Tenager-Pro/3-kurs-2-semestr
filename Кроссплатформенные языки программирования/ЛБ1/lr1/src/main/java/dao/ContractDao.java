package dao;
import models.Contract;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;
public class ContractDao {

    public Contract findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Contract.class, id);
    }

    public void save(Contract contract) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(contract);
        tx1.commit();
        session.close();
    }

    public void update(Contract contract) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(contract);
        tx1.commit();
        session.close();
    }

    public void delete(Contract contract) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(contract);
        tx1.commit();
        session.close();
    }

    public List<Contract> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Contract> contracts = (List<Contract>)  session.createQuery("From Contract").list();
        session.close();
        return contracts;
    }


}
