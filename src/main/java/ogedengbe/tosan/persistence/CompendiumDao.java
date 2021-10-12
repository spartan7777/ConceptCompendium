package ogedengbe.tosan.persistence;

import ogedengbe.tosan.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * Compendium Dao - A generic DAO
 *
 */

public class CompendiumDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Generic Compendium Dao.
     * @param type the entity type, for example, User.
     */
    public CompendiumDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets an entity by the id
     * @param id entity id to search by
     * @return an entity
     */
    public <T> T getById(int id) {
        Session sessionOne = getSession();
        T entity = (T)sessionOne.get(type, id);
        sessionOne.close();
        return entity;
    }


    /**
     * Gets all entities
     * @return all the entities
     */
    public List<T> getAll() {
        Session sessionOne = getSession();

        CriteriaBuilder builderOne = sessionOne.getCriteriaBuilder();
        CriteriaQuery<T> queryOne = builderOne.createQuery(type);
        Root<T> root = queryOne.from(type);
        List<T> list = sessionOne.createQuery(queryOne).getResultList();
        sessionOne.close();
        return list;
    }

    /** Get by property (exact match)
     * sample usage: getByPropertyEqual("lastName", "Curry")
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of orders meeting the criteria search
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {
        Session sessionOne = getSession();

        logger.debug("Searching for order with " + propertyName + " = " + value);

        CriteriaBuilder builderOne = sessionOne.getCriteriaBuilder();
        CriteriaQuery<T> queryOne = builderOne.createQuery( type );
        Root<T> root = queryOne.from(type );
        queryOne.select(root).where(builderOne.equal(root.get(propertyName), value));
        List<T> entities = sessionOne.createQuery( queryOne ).getResultList();
        sessionOne.close();
        return entities;
    }


    /**
     * Get by property (like)
     * sample usage: getByPropertyLike("lastName", "C")
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of users meeting the criteria search
     */
    public List<User> getByPropertyLike(String propertyName, String value) {
        Session sessionOne = getSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builderOne = sessionOne.getCriteriaBuilder();
        CriteriaQuery<T> queryOne = builderOne.createQuery( type );
        Root<T> root = queryOne.from(type );
        Expression<String> propertyPath = root.get(propertyName);
        queryOne.select(root).where(builderOne.like(propertyPath, "%" + value + "%"));
        List<T> entities = sessionOne.createQuery( queryOne ).getResultList();
        sessionOne.close();
        return (List<User>) entities;
    }


//    /**
//     * Creates an entity
//     * @param entity entity to be created or inserted
//     * @return id of the inserted entity
//     */
//  public void insert(T entity) {
//        Session sessionOne = getSession();
//        Transaction transactionOne = sessionOne.beginTransaction();
//        int id = (int) sessionOne.save(entity);
//        transactionOne.commit();
//        sessionOne.close();
//    }


    /**
     * Updates an entity
     * @param entity User to be inserted or updated
     * @return
     */
    public int saveOrUpdate(T entity) {
        Session sessionOne = getSession();
        Transaction transactionOne = sessionOne.beginTransaction();
        sessionOne.saveOrUpdate(entity);
        transactionOne.commit();
        sessionOne.close();
    }


    /**
     * Deletes an entity.
     * @param entity entity to be deleted
     */
    public void delete(T entity) {
        Session sessionOne = getSession();
        Transaction transactionOne = sessionOne.beginTransaction();
        sessionOne.delete(entity);
        transactionOne.commit();
        sessionOne.close();
    }


    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }


}