package ogedengbe.tosan.persistence;

import ogedengbe.tosan.model.Concept;
import ogedengbe.tosan.model.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/**
 * The type RoleDao.
 */


class RoleDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all roles.
     * @return the all roles
     */
    public List<Role> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Role> query = builder.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);
        List<Role> roles = session.createQuery(query).getResultList();
        session.close();
        return roles;
    }

    /**
     * Gets a role by id
     * @param roleId role id to search by
     * @return a role
     */
    public Role getById(int roleId) {
        Session session = sessionFactory.openSession();
        Role role = session.get(Role.class, roleId);
        session.close();
        return role;
    }

    /**
     * create role
     * @param role  Role to be inserted
     * @return id of the inserted role
     */
    public int insert(Role role) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(role);
        transaction.commit();
        session.close();
        return id;
    }


    /**
     * update a role
     * @param role Role to be updated
     * @return role
     */
    public Role saveOrUpdate(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(role);
        transaction.commit();
        session.close();
        return role;
    }


    /**
     * Delete a role
     * @param role Role to be deleted
     */
    public void delete(Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(role);
        transaction.commit();
        session.close();
    }

    public String getRoleName(String roleName) {
        Session session = sessionFactory.openSession();
        Role role = session.get(Role.class, roleName);
        session.close();
        return roleName;
    }
}



