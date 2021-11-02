package ogedengbe.tosan.persistence;

import ogedengbe.tosan.model.Role;
import ogedengbe.tosan.model.User;
import ogedengbe.tosan.test.util.Database;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;



/**
 * The type RoleDao test.
 */


class RoleDaoTest {


    RoleDao dao;
    UserDao daoTwo;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new RoleDao();
        daoTwo = new UserDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb3.sql");
    }


    /**
     * Verifies gets all roles successfully.
     */
    @Test
    void getAllRolesSuccess() {
        List<Role> roles = dao.getAll();
        assertEquals(7, roles.size());
    }

    /**
     * Verify successful retrieval of role by Id.
     */
    @Test
    void getByIdSuccess() {
        Role retrievedRole = dao.getById(7);
        assertNotNull(retrievedRole);
        assertEquals("Admin", retrievedRole.getRoleName());
    }

    /**
     * Verify successful delete of role
     */
    @Test
    void deleteRoleSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful update of role
     */
    @Test
    void updateRoleSuccess() {
        String newRoleName = "Admin";
        Role roleToUpdate = dao.getById(5);
        roleToUpdate.setRoleName(newRoleName);
        dao.saveOrUpdate(roleToUpdate);
        Role retrievedRole = dao.getById(5);
        assertEquals("Admin", retrievedRole.getRoleName());
    }
}

