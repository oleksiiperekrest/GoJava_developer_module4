package dao.hibernate;

import dao.ProductDAO;
import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.UUID;

public class HibernateProductDAOImpl implements ProductDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


    public Product getById(UUID id) {
        Session session = this.sessionFactory.openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    @SuppressWarnings("unchecked")
    public List<Product> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> products = session.createQuery("from Product").list();
        transaction.commit();
        session.close();
        return products;
    }

    public void save(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    public void update(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
        session.close();
    }

    public void delete(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
    }

    public void deleteById(UUID id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Product product = session.get(Product.class, id);
        session.delete(product);
        transaction.commit();
        session.close();
    }
}
