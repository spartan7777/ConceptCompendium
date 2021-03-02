package ogedengbe.tosan.communication;

import ogedengbe.tosan.model.Concept;
import ogedengbe.tosan.model.User;
import ogedengbe.tosan.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * The type User dao test.
 */
//class UserDaoTest {

//    UserDao daoOne;

    /**
     * Creating the dao.
     */
//    @BeforeEach
 //   void setUp() {
//        daoOne = new UserDao();
 //       Database database = Database.getInstance();
//        database.runSQL("cleandb.sql");
//    }

    /**
     * Verifies gets all users successfully.
     */
//    @Test
 //   void getAllUsersSuccess() {
 //       List<User> users = daoOne.getAllUsers();
 //       assertEquals(6, users.size());
//    }

    /**
     * Verifies gets users by last name successfully.
     */
 //   @Test
 //   void getUsersByLastNameSuccess() {
//        List<User> users = daoOne.getUsersByLastName("c");
 //       assertEquals(3, users.size());
 //   }

    /**
     * Verifies a user is returned correctly based on id search
     */
//    @Test
 //   void getByIdSuccess() {
//        User retrievedUser = daoOne.getUsersById(3);
//        assertNotNull(retrievedUser);
//        assertEquals("Barney", retrievedUser.getFirstName());
 //   }

    /**
     * Verify successful insert of a user with concept
     */
//    @Test
//    void insertWithConceptSuccess() {
 //       User newUser = new User(7,"Bruce", "Banner", "bbanner", "hulksecret7");

 //       int conceptId = 9;
 //       int userId = daoOne.create(newUser);
 //       String conceptName = "Lightsaber";
 //       String keywordOne = "Jedi";
 //       String keywordTwo = "Sacred";
 //       String category = "Weapon";
 //       String description = "Energy blade used by Jedi Knights";

 //       Concept newConcept = new Concept(conceptId, conceptName, keywordOne, keywordTwo, category, description);

 //       newUser.addConcept(newConcept);

        //int userId = daoOne.create(newUser);
  //      assertNotEquals(0, userId);
  //      User insertedUser = daoOne.getUsersById(userId);
  //      assertEquals("Bruce", insertedUser.getFirstName());
  //      assertEquals(1, insertedUser.getConceptSet().size());
  //  }

    /**
     * Verify successful delete of user
     */
 //   @Test
 //   void deleteSuccess() {
 //       daoOne.delete(daoOne.getUsersById(3));
 //       assertNull(daoOne.getUsersById(3));
 //   }

    /**
     * Verify successful update of user
     */
 //   @Test
 //   void updateSuccess() {
 //       String newLastName = "Davis";
  //      User userToUpdate = daoOne.getUsersById(3);
  //      userToUpdate.setLastName(newLastName);
  //      daoOne.saveOrUpdate(userToUpdate);
  //      User retrievedUser = daoOne.getUsersById(3);
  //      assertEquals(newLastName, retrievedUser.getLastName());
  //  }

    /**
     * Verify successful get by property (equal match)
     */
 //   @Test
 //   void getByPropertyEqualSuccess() {
 //       List<User> users = daoOne.getByPropertyLike("lastName", "Curry");
 //       assertEquals(1, users.size());
 //       assertEquals(3, users.get(0).getId());
 //   }

    /**
     * Verify successful get by property (like match)
     */
 //   @Test
 //   void getByPropertyLikeSuccess() {
 //       List<User> users = daoOne.getByPropertyLike("lastName", "c");
 //       assertEquals(3, users.size());
 //   }
//}
