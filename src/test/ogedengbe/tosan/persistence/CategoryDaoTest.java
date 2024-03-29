package ogedengbe.tosan.persistence;

import ogedengbe.tosan.model.Category;
import ogedengbe.tosan.test.util.Database;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


/**
 * The type CategoryDao test.
 */

public class CategoryDaoTest {

    CategoryDao dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new CategoryDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb3.sql");
    }

    /**
     * Verifies gets all categories successfully.
     */
    @Test
    void getAllCategorySuccess() {
        List<Category> categories = dao.getAll();
        assertEquals(9, categories.size());
    }

    /**
     * Verifies gets category by category successfully.
     */
    @Test
    void getCategoryByCategorySuccess() {
        List<Category> categories = dao.getByPropertyLike("categoryName", "Weapons");
        assertEquals(1, categories.size());
    }


    /**
     * Verify successful retrieval of category by Id.
     */
    @Test
    void getByIdSuccess() {
        Category retrievedCategory = dao.getById(6);
        assertNotNull(retrievedCategory);
        assertEquals("Resources", retrievedCategory.getCategoryName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Category> resultSetOne = dao.getByPropertyEqual("categoryName", "Vehicles");
        assertEquals(1, resultSetOne.size());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Category> categories = dao.getByPropertyLike("categoryName", "a");
        assertEquals(6, categories.size());
    }

}