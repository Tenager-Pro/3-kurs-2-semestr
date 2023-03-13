
package utils;

        import models.*;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
        import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Contract.class);
                configuration.addAnnotatedClass(Patient.class);
                configuration.addAnnotatedClass(PatientCard.class);
                configuration.addAnnotatedClass(Doctor.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }

    public static Session getSession() {
        Session session = getSessionFactory().getCurrentSession();

        if(session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
        }

        return session;
    }
}


