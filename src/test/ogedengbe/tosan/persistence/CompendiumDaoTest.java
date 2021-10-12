package ogedengbe.tosan.persistence;

import ogedengbe.tosan.model.Concept;
import ogedengbe.tosan.model.User;
import ogedengbe.tosan.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type CompendiumDao test.
 */


class CompendiumDaoTest {

    CompendiumDao dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new CompendiumDao();
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
     * Verifies gets all concepts successfully.
     */
    @Test
    void getAllConceptsSuccess() {
        List<Concept> conceptSet = dao.getAll();
        assertEquals(6, conceptSet.size());
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
     * Verifies gets concepts by name successfully.
     */
    @Test
    void getConceptsByNameSuccess() {
        List<Concept> conceptSet = dao.getByPropertyLike("conceptName", "c");
        assertEquals(0, conceptSet.size());
    }


    /**
     * Verifies gets concepts by keyword one successfully.
     */
    @Test
    void getConceptsByKeywordOneSuccess() {
        List<Concept> conceptSet = dao.getByPropertyLike("keywordOne", "c");
        assertEquals(0, conceptSet.size());
    }


    /**
     * Verifies gets concepts by keyword two successfully.
     */
    @Test
    void getConceptsByKeywordTwoSuccess() {
        List<Concept> conceptSet = dao.getByPropertyLike("keywordTwo", "c");
        assertEquals(0, conceptSet.size());
    }


    /**
     * Verifies gets concepts by category successfully.
     */
    @Test
    void getConceptsByCategorySuccess() {
        List<Concept> conceptSet = dao.getByPropertyLike("category", "c");
        assertEquals(0, conceptSet.size());
    }


    /**
     * Verifies gets concepts by description successfully.
     */
    @Test
    void getConceptsByDescriptionSuccess() {
        List<Concept> conceptSet = dao.getByPropertyLike("description", "c");
        assertEquals(0, conceptSet.size());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertUserSuccess() {
        User newUser = new User(7,"Bruce", "Banner", "bbanner", "hulksecret7");
        int userId = dao.saveOrUpdate(newUser);
        assertNotEquals(0,userId);
        User insertedUser = (User) dao.getById(userId);
        assertEquals("Bruce", insertedUser.getFirstName());
    }


    /**
     * Verify successful insert of a concept
     */
    @Test
    void insertConceptSuccess() {
        Concept newConcept = new Concept(7, "Bruce", "Banner", "bbanner", "hulksecret7", "here is desc");
        int conceptId = dao.saveOrUpdate(newConcept);
        assertNotEquals(0,conceptId);
        Concept insertedConcept = (Concept) dao.getById(conceptId);
        assertEquals("Bruce", insertedConcept.getConceptName());
    }

    /**
     * Verify successful insert of a user and concept
     */
    @Test
    void insertWithConceptSuccess() {
        User newUser = new User(7,"Bruce", "Banner", "bbanner", "hulksecret7");
        Concept testConcept;

        int userId = dao.saveOrUpdate(newUser);
        assertNotEquals(0,userId);
        User insertedUser = (User) dao.getById(userId);
        assertEquals("Bruce", insertedUser.getFirstName());
    }


    /**
     * Verify successful delete of user
     */
    @Test
    void deleteUserSuccess() {
        User deletedUser = dao.getById(3);
        deletedUser.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }


    /**
     * Verify successful delete of a concept
     */
    @Test
    void deleteConceptSuccess() {
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
     * Verify successful update of concept
     */
    @Test
    void updateConceptSuccess() {
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
        List<User> users = dao.getByPropertyEqual("lastName", "Vader");
        assertEquals(1, users.size());
        assertEquals(6, users.get(0).getId());
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



