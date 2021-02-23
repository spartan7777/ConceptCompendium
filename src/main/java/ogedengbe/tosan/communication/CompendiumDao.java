package ogedengbe.tosan.communication;

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

public class CompendiumDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactoryOne = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets a list of all users
     * @ return all the users
     */
    public List<User> getAllUsers() {
        Session sessionOne = sessionFactoryOne.openSession();
        CriteriaBuilder builderOne = sessionOne.getCriteriaBuilder();
        CriteriaQuery<User> queryOne = builderOne.createQuery(User.class);
        Root<User> rootOne = queryOne.from(User.class);
        List<User> users = sessionOne.createQuery(queryOne).getResultList();
        sessionOne.close();
        //logger.info("Here is the select all statement " + users);
        return users;
    }

    /**
     * Gets users by last name
     * @param lastName the last name to search for
     * @return the users that are found
     */
    public List<User> getUsersByLastName(String lastName) {
        Session sessionOne = sessionFactoryOne.openSession();
        CriteriaBuilder builderOne = sessionOne.getCriteriaBuilder();
        CriteriaQuery<User> queryOne = builderOne.createQuery(User.class);
        Root<User> rootOne = queryOne.from(User.class);
        Expression<String> propertyPath = rootOne.get("lastName");
        queryOne.where(builderOne.like(propertyPath, "%" + lastName + "%"));
        List<User> users = sessionOne.createQuery(queryOne).getResultList();
        sessionOne.close();
        //logger.info("Here is the select all statement " + users);
        return users;
    }

    /**
     * Gets users by Id
     * @param id the user id to search for
     * @return the result user
     */
    public User getUsersById(int id) {
        Session sessionOne = sessionFactoryOne.openSession();
        User user = sessionOne.get(User.class, id);
        sessionOne.close();
        //logger.info("Here is the select all statement " + user);
        return user;
    }

    /**
     * Get user by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of users meeting the criteria
     */
    public List<User> getByPropertyEqual(String propertyName, String value) {
        Session sessionOne = sessionFactoryOne.openSession();
        logger.debug("Searching for user with " + propertyName + " = " + value);
        CriteriaBuilder builderOne = sessionOne.getCriteriaBuilder();
        CriteriaQuery<User> queryOne = builderOne.createQuery( User.class );
        Root<User> rootOne = queryOne.from( User.class );
        queryOne.select(rootOne).where(builderOne.equal(rootOne.get(propertyName), value));
        List<User> users = sessionOne.createQuery( queryOne ).getResultList();
        sessionOne.close();
        return users;
    }

    /**
     * Get user by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of users meeting the criteria
     */
    public List<User> getByPropertyLike(String propertyName, String value) {
        Session sessionOne = sessionFactoryOne.openSession();
        logger.debug("Searching for user with {} = {}",  propertyName, value);
        CriteriaBuilder builderOne = sessionOne.getCriteriaBuilder();
        CriteriaQuery<User> queryOne = builderOne.createQuery( User.class );
        Root<User> rootOne = queryOne.from( User.class );
        Expression<String> propertyPath = rootOne.get(propertyName);
        queryOne.where(builderOne.like(propertyPath, "%" + value + "%"));
        List<User> users = sessionOne.createQuery( queryOne ).getResultList();
        sessionOne.close();
        return users;
    }

    /**
     * create a user
     * @param user  User to be created
     * @return id of the created user
     */
    public int create(User user) {
        int id = 0;
        Session sessionOne = sessionFactoryOne.openSession();
        Transaction transactionOne = sessionOne.beginTransaction();
        id = (int)sessionOne.save(user);
        transactionOne.commit();
        sessionOne.close();
        return id;
    }

    /**
     * update a user
     * @param user  User to be updated
     */
    public void saveOrUpdate(User user) {
        Session sessionOne = sessionFactoryOne.openSession();
        Transaction transactionOne = sessionOne.beginTransaction();
        sessionOne.saveOrUpdate(user);
        transactionOne.commit();
        sessionOne.close();
    }

    /**
     * Delete a user
     * @param user User to be deleted
     */
    public void delete(User user) {
        Session sessionOne = sessionFactoryOne.openSession();
        Transaction transactionOne = sessionOne.beginTransaction();
        sessionOne.delete(user);
        transactionOne.commit();
        sessionOne.close();
    }


    /**
     * create a concept
     * @param concept  Concept to be created
     * @return id of the created concept
     */
    public int create(Concept concept) {
        int id = 0;
        Session sessionOne = sessionFactoryOne.openSession();
        Transaction transactionOne = sessionOne.beginTransaction();
        id = (int)sessionOne.save(id);
        transactionOne.commit();
        sessionOne.close();
        return id;
    }

    /**
     * update a concept
     * @param concept Concept to be updated
     */
    public void saveOrUpdate(Concept concept) {
        Session sessionOne = sessionFactoryOne.openSession();
        Transaction transactionOne = sessionOne.beginTransaction();
        sessionOne.saveOrUpdate(concept);
        transactionOne.commit();
        sessionOne.close();
    }

    /**
     * Delete a concept
     * @param concept Concept to be deleted
     */
    public void delete(Concept concept) {
        Session sessionOne = sessionFactoryOne.openSession();
        Transaction transactionOne = sessionOne.beginTransaction();
        sessionOne.delete(concept);
        transactionOne.commit();
        sessionOne.close();
    }


}

