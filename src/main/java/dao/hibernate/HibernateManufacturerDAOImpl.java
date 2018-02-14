package dao.hibernate;

import dao.ManufacturerDAO;
import model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.UUID;

public class HibernateManufacturerDAOImpl implements ManufacturerDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


    public Manufacturer getById(UUID id) {
        Session session = this.sessionFactory.openSession();
        Manufacturer manufacturer = session.get(Manufacturer.class, id);
        session.close();
        return manufacturer;
    }

    @SuppressWarnings("unchecked")
    public List<Manufacturer> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Manufacturer> manufacturers = session.createQuery("from Manufacturer").list();
        transaction.commit();
        session.close();
        return manufacturers;
    }

    public void save(Manufacturer manufacturer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(manufacturer);
        transaction.commit();
        session.close();
    }

    public void update(Manufacturer manufacturer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(manufacturer);
        transaction.commit();
        session.close();
    }

    public void delete(Manufacturer manufacturer) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(manufacturer);
        transaction.commit();
        session.close();
    }

    public void deleteById(UUID id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Manufacturer manufacturer = session.get(Manufacturer.class, id);
        session.delete(manufacturer);
        transaction.commit();
        session.close();
    }
}
