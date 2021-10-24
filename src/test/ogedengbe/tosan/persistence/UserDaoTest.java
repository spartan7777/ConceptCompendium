package ogedengbe.tosan.persistence;

import ogedengbe.tosan.model.Concept;
import ogedengbe.tosan.model.User;
import ogedengbe.tosan.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type UserDao test.
 */


class UserDaoTest {

    UserDao dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new UserDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }


    /**
     * Verifies gets all users successfully.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = dao.getAll();
        assertEquals(6, users.size());
    }


    /**
     * Verifies gets users by last name successfully.
     */
    @Test
    void getUsersByLastNameSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "c");
        assertEquals(0, users.size());
    }

    /**
     * Verify successful retrival of user by Id.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Barney", retrievedUser.getFirstName());
    }


    /**
     * Verify successful insert of a user
     */
    @Test
    void insertUserSuccess() {
        User newUser = new User(7,"Bruce", "Banner", "bbanner", "hulksecret7");
        //int testId = dao.saveOrUpdate(newUser);
        assertNotEquals(0,dao.getById(7));
        User insertedUser = (User) dao.getById(7);
        assertEquals("Bruce", insertedUser.getFirstName());
    }


    /**
     * Verify successful insert of a user and concept
     */
    //@Test
    //void insertWithConceptSuccess() {
        //User newUser = new User(8,"Peter", "Parker", "spidermn", "dailybugle1");
        //String conceptDescription = "Concept 1";

        //Concept concept = new Concept(17, 7, "Kyber Crystal", "Resources", 6, "These are rare Force-attuned crystals that grow throughout the galaxy. They concentrate energy in a unique manner through resonating with the Force, and as such are used in the creation of lightsaber and other laser bladed weapons.");

        //newUser.addConcept(concept);

        //userId = dao.saveOrUpdate(newUser);
        //assertNotEquals(0,userId);
        //User insertedUser = (User) dao.getById(userId);
        //assertEquals("Peter", insertedUser.getFirstName());
        //assertEquals(17, insertedUser.getConceptSet().size());
    //}


    /**
     * Verify successful delete of user
     */
    @Test
    void deleteUserSuccess() {
        User deletedUser = (User) dao.getById(3);
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }


    /**
     * Verify successful update of user
     */
    @Test
    void updateUserSuccess() {
        String newLastName = "Davis";
        User userToUpdate = (User) dao.getById(3);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) dao.getById(3);
        assertEquals(newLastName, retrievedUser.getLastName());
    }


    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> resultSet = dao.getByPropertyEqual("lastName", "Vader");
        assertEquals(1, resultSet.size());
        //assertEquals(6, resultSet.get(0).getById());
    }


    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("firstName", "t");
        assertEquals(4, users.size());
    }

}




