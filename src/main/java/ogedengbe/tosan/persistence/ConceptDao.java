package ogedengbe.tosan.persistence;

import ogedengbe.tosan.model.Concept;
import ogedengbe.tosan.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * The type ConceptDao.
 */

public class ConceptDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all entities
     * @return all the entities
     */
    public List<Concept> getAll() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Concept> query = builder.createQuery(Concept.class);
        Root<Concept> root = query.from(Concept.class);
        List<Concept> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    /**
     * Gets a concept by id
     * @param conceptId users id to search by
     * @return a concept
     */
    public Concept getById(int conceptId) {
        Session session = sessionFactory.openSession();
        Concept concept = session.get(Concept.class, conceptId);
        session.close();
        return concept;
    }


    /**
     * create a concept
     * @param concept Concept to be inserted
     * @return id of the inserted concept
     */
    public int insert(Concept concept) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(concept);
        transaction.commit();
        session.close();
        return id;
    }


    /**
     * update a concept
     * @param concept Concept to be updated
     */
    public void saveOrUpdate(Concept concept) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(concept);
        transaction.commit();
        session.close();
    }


    /**
     * delete a concept
     * @param concept Concept to be deleted
     */
    public void delete(Concept concept) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(concept);
        transaction.commit();
        session.close();
    }


    /**
     * Get concept by property (exact match)
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of users meeting the criteria search
     */
    public List<Concept> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Concept> query = builder.createQuery(Concept.class );
        Root<Concept> root = query.from(Concept.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Concept> concepts = session.createQuery( query ).getResultList();
        session.close();
        return concepts;
    }


    /**
     * Get concept by property (like)
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of users meeting the criteria search
     */
    public List<Concept> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Concept> query = builder.createQuery(Concept.class );
        Root<Concept> root = query.from(Concept.class );
        Expression<String> propertyPath = root.get(propertyName);
        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<Concept> concepts = session.createQuery( query ).getResultList();
        session.close();
        return concepts;
    }


    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}

