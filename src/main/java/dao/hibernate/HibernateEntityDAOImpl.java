package dao.hibernate;

import dao.GenericDAO;
import model.SuperEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.UUID;

public class HibernateEntityDAOImpl implements GenericDAO<SuperEntity, UUID> {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public SuperEntity getById(UUID id) {
        Session session = this.sessionFactory.openSession();
        SuperEntity entity = session.get(SuperEntity.class, id);
        session.close();
        return entity;
    }

    public List<SuperEntity> getAll() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<SuperEntity> entities = session.createQuery("from ").list();
        transaction.commit();
        session.close();
        return entities;
    }

    public void save(SuperEntity superEntity) {

    }

    public void update(SuperEntity superEntity) {

    }

    public void delete(SuperEntity superEntity) {

    }

    public void deleteById(UUID uuid) {

    }


}
