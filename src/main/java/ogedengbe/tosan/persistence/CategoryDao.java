package ogedengbe.tosan.persistence;

import ogedengbe.tosan.model.Concept;
import ogedengbe.tosan.model.Category;
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
 * The type CategoryDao.
 */

public class CategoryDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all entities
     * @return all the entities
     */
    public List<Category> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        List<Category> categories = session.createQuery(query).getResultList();
        session.close();
        return categories;
    }

    /**
     * Gets a category by id
     * @param categoryId category id to search by
     * @return a category
     */
    public Category getById(int categoryId) {
        Session session = sessionFactory.openSession();
        Category category = session.get(Category.class, categoryId);
        session.close();
        return category;
    }


    /**
     * Get category by property (exact match)
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of categories meeting the criteria search
     */
    public List<Category> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class );
        Root<Category> root = query.from(Category.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Category> categories = session.createQuery( query ).getResultList();
        session.close();
        return categories;
    }


    /**
     * Get category by property (like)
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of users meeting the criteria search
     */
    public List<Category> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class );
        Root<Category> root = query.from(Category.class );
        Expression<String> propertyPath = root.get(propertyName);
        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<Category> categories = session.createQuery( query ).getResultList();
        session.close();
        return categories;
    }


    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}

