package ogedengbe.tosan.communication;

import ogedengbe.tosan.model.User;
import ogedengbe.tosan.test.util.Database;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 */
class CompendiumDaoTest {

    CompendiumDao daoOne;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        daoOne = new CompendiumDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = daoOne.getAllUsers();
        assertEquals(6, users.size());
    }

    /**
     * Verifies gets users by last name successfully.
     */
    @Test
    void getUsersByLastNameSuccess() {
        List<User> users = daoOne.getUsersByLastName("c");
        assertEquals(3, users.size());
    }

    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = daoOne.getUsersById(3);
        assertNotNull(retrievedUser);
        assertEquals("Barney", retrievedUser.getFirstName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {
        User newUser = new User("Fred", "Flintstone", "fflintstone", LocalDate.parse("1168-01-01"));
        int id = daoOne.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = daoOne.getUsersById(id);
        assertEquals("Fred", insertedUser.getFirstName());
        // Could continue comparing all values, but
        // it may make sense to use .equals()
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }

    /**
     * Verify successful delete of user
     */
    @Test
    @Ignore
    void deleteSuccess() {
        daoOne.delete(daoOne.getUsersById(3));
        assertNull(daoOne.getUsersById(3));
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newLastName = "Davis";
        User userToUpdate = daoOne.getUsersById(3);
        userToUpdate.setLastName(newLastName);
        daoOne.saveOrUpdate(userToUpdate);
        User retrievedUser = daoOne.getUsersById(3);
        assertEquals(newLastName, retrievedUser.getLastName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = daoOne.getByPropertyLike("lastName", "Curry");
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = daoOne.getByPropertyLike("lastName", "c");
        assertEquals(3, users.size());
    }
}

