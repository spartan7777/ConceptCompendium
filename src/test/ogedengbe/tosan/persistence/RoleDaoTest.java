package ogedengbe.tosan.persistence;


import ogedengbe.tosan.model.Role;
import ogedengbe.tosan.model.User;
import ogedengbe.tosan.test.util.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
        Assertions.assertEquals(7, roles.size());
    }

    /**
     * Verify successful retrieval of role and user by Id.
     */
    @Test
    void getByIdSuccess() {
        Role retrievedRole = dao.getById(7);
        Assertions.assertNotNull(retrievedRole);
        Assertions.assertEquals("Carter", retrievedRole.getRoleName());
        Assertions.assertEquals("Carter", retrievedRole.getUserName());
    }


    /**
     * Verify successful insert of a role
     */
    @Test
    void insertRoleSuccess() {
        Role newRole = new Role("admin", "spidermn");
        int roleId = dao.insert(newRole);
        Assertions.assertNotEquals(0, roleId);
        Role insertedRole = dao.getById(roleId);
        Assertions.assertEquals("Peter", insertedRole.getUserName());
    }

    /**
     * Verify successful insert of a user and role
     */
    @Test
    void insertUserWithRoleSuccess() {

        User newUser = new User("Peter", "Parker", "spidermn", "dailybugle1");
        Role newRole = new Role(newUser, "admin", "spidermn");

        newUser.addRole(newRole);

        int roleId = dao.insert(newRole);
        //User insertedUserTwo = dao.saveOrUpdate(newRole);

        Assertions.assertNotEquals(0,roleId);
        Assertions.assertNotEquals(0,roleId);
        Role insertedRole = dao.getById(roleId);
        Assertions.assertEquals("Peter", insertedRole.getUserName());
        Assertions.assertEquals(17, dao.getAll().size());
        Assertions.assertEquals(1, insertedRole.getRoleSet().size());
    }

    /**
     * Verify successful delete of role
     */
    @Test
    void deleteRoleSuccess() {
        dao.delete(dao.getById(3));
        Assertions.assertNull(dao.getById(3));
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
        Assertions.assertEquals("Admin", retrievedRole.getRoleName());
    }
}
