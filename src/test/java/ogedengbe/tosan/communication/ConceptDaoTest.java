package ogedengbe.tosan.communication;

import ogedengbe.tosan.model.Concept;
import ogedengbe.tosan.model.Concept;
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
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Concept dao test
 */

public class ConceptDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactoryOne = SessionFactoryProvider.getSessionFactory();

    ConceptDao daoOne;

        /**
         * Creating the dao.
         */
        @BeforeEach
        void setUp() {
        daoOne = new ConceptDao();
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

        /**
         * Verifies gets all Concepts successfully.
         */
        @Test
        void getAllConceptsSuccess() {
        List<Concept> concepts = daoOne.getAllConcepts();
        assertEquals(6, concepts.size());
    }

        /**
         * Verifies a Concept is returned correctly based on id search
         */
        @Test
        void getConceptsByIdSuccess() {
        Concept retrievedConcept = daoOne.getConceptsById(3);
        assertNotNull(retrievedConcept);
        assertEquals("Tony", retrievedConcept.getConceptId());
    }

        /**
         * Verifies gets Concepts by name successfully.
         */
        @Test
        void getConceptsByNameSuccess() {
        List<Concept> retrievedConcepts = daoOne.getByPropertyLike("conceptName", "c");
        assertNotNull(retrievedConcepts);
        //assertEquals("Lightsaber", retrievedConcepts.getConceptName(4));
    }

        /**
         * Verifies gets Concepts by keyword one successfully.
         */
        @Test
        void getConceptsByKeywordOneSuccess() {
        List<Concept> retrievedConcepts = daoOne.getByPropertyLike("keywordOne", "c");
        assertNotNull(retrievedConcepts);
        //assertEquals("Tony", retrievedConcepts.getKeywordOne());
    }

        /**
         * Verifies gets Concepts by keyword two successfully.
         *
         */
        @Test
        void getConceptsByKeywordTwoSuccess() {
        List<Concept> retrievedConcepts = daoOne.getByPropertyLike("keywordTwo", "c");
        assertNotNull(retrievedConcepts);
        //assertEquals("Tony", retrievedConcepts.getKeywordTwo());
    }

        /**
         * Verifies gets Concepts by category successfully.
         *
         */
        @Test
        void getConceptsByCategorySuccess() {
        List<Concept> retrievedConcepts = daoOne.getByPropertyLike("category", "c");
        assertNotNull(retrievedConcepts);
        //assertEquals("Tony", retrievedConcepts.getCategory());
    }

        /**
         * Verifies gets Concepts by description successfully.
         *
         */
        @Test
        void getConceptsByDescriptionSuccess() {
        List<Concept> retrievedConcepts = daoOne.getByPropertyLike("description", "c");
        assertNotNull(retrievedConcepts);
        //assertEquals("Tony", retrievedConcepts.getDescription());
    }

        /**
         * Verify successful insert of a Concept
         */
        @Test
        void insertSuccess() {
        Concept newConcept = new Concept(9, 4, "Lightsaber", "Jedi", "Sacred", "Weapon", "Energy blade used by Jedi Knights");
        int conceptId = daoOne.create(newConcept);
        assertNotEquals(0, conceptId);
        Concept insertedConcept = daoOne.getConceptsById(conceptId);
        assertEquals("Bruce", insertedConcept.getConceptName());
    }

        /**
         * Verify successful delete of Concept
         */
        @Test
        void deleteSuccess() {
        daoOne.delete(daoOne.getConceptsById(3));
        assertNull(daoOne.getConceptsById(3));
    }

        /**
         * Verify successful update of Concept
         */
        @Test
        void updateSuccess() {
        String newConceptName = "Davis";
        Concept conceptToUpdate = daoOne.getConceptsById(3);
        conceptToUpdate.setConceptName(newConceptName);
        daoOne.saveOrUpdate(conceptToUpdate);
        Concept retrievedConcept = daoOne.getConceptsById(3);
        assertEquals(newConceptName, retrievedConcept.getConceptName());
    }

        /**
         * Verify successful get by property (equal match)
         */
        @Test
        void getByPropertyEqualSuccess() {
        List<Concept> concepts = daoOne.getByPropertyEqual("conceptName", "Vader");
        assertEquals(1, concepts.size());
        assertEquals(6, concepts.get(0).getConceptId());
    }

        /**
         * Verify successful get by property (like match)
         */
        @Test
        void getByPropertyLikeSuccess() {
        List<Concept> concepts = daoOne.getByPropertyLike("conceptName", "t");
        assertEquals(4, concepts.size());
    }

}


