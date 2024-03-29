package ogedengbe.tosan.persistence;

import ogedengbe.tosan.model.Concept;
import ogedengbe.tosan.model.User;
import ogedengbe.tosan.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type ConceptDao test.
 */


class ConceptDaoTest {

    ConceptDao dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new ConceptDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb3.sql");
    }


    /**
     * Verifies gets all concepts successfully.
     */
    @Test
    void getAllConceptsSuccess() {
        List<Concept> concepts = dao.getAll();
        assertEquals(16, concepts.size());
    }

    /**
     * Verifies gets concepts by category successfully.
     */
    @Test
    void getConceptsByCategorySuccess() {
        List<Concept> concepts = dao.getByPropertyLike("category", "Weapons");
        assertEquals(2, concepts.size());
    }

    /**
     * Verify successful retrival of concept by Id.
     */
    @Test
    void getByIdSuccess() {
        Concept retrievedConcept = dao.getById(6);
        assertNotNull(retrievedConcept);
        assertEquals("Millennium Falcon", retrievedConcept.getConceptName());
    }


    /**
     * Verify successful delete of concept
     */
    @Test
    void deleteConceptSuccess() {
        Concept deletedConcept = (Concept) dao.getById(13);
        dao.delete(dao.getById(13));
        assertNull(dao.getById(13));
    }


    /**
     * Verify successful update of concept
     */
    @Test
    void updateConceptSuccess() {
        String newConceptName = "Darth Maul";
        String newConceptDesc = "A Sith Lord created to serve the emperor";
        Concept conceptToUpdate = (Concept) dao.getById(3);
        conceptToUpdate.setConceptName(newConceptName);
        conceptToUpdate.setDescription(newConceptDesc);
        dao.saveOrUpdate(conceptToUpdate);
        Concept retrievedConcept = (Concept) dao.getById(3);
        assertEquals("Darth Maul", retrievedConcept.getConceptName());
        assertEquals("A Sith Lord created to serve the emperor", retrievedConcept.getDescription());
    }


    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Concept> resultSetOne = dao.getByPropertyEqual("conceptName", "Wookiee");
        List<Concept> resultSetTwo = dao.getByPropertyEqual("category", "Mecha");
        List<Concept> resultSetThree = dao.getByPropertyEqual("description", "The name for the energy that ties the universe together. Jedi and Sith can manipulate this energy.");
        assertEquals(1, resultSetOne.size());
        assertEquals(2, resultSetTwo.size());
        assertEquals(1, resultSetThree.size());
    }


    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Concept> concepts = dao.getByPropertyLike("description", "ship");
        assertEquals(3, concepts.size());
    }

}