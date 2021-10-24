package ogedengbe.tosan.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a concept.
 * @author Tosan Ogedengbe
 **/

@Entity(name = "Concept")
@Table(name = "concept")

public class ConceptTest {
    @Id
    @Column(name = "concept_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int conceptId;

    @Column(name = "name")
    private String conceptName;

    @Column(name = "category")
    private String category;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private UserTest userOne;

    /**
     * Instantiates a new Concept.
     */
    public ConceptTest() {
    }

    /**
     * Instantiates a new Concept.
     * @param conceptId     the concept id
     * @param conceptName   the concept name
     * @param category      the concept category
     * @param categoryId    the concept category id
     * @param description   the concept description
     */
    public ConceptTest(int conceptId, String conceptName, String category, int categoryId, String description) {
        this.conceptId = conceptId;
        this.conceptName = conceptName;
        this.category = category;
        this.categoryId = categoryId;
        this.description = description;
    }

    /**
     * Gets concept id.
     * @return the concept id
     */
    public int getConceptId() {
        return conceptId;
    }

    /**
     * Sets concept id.
     * @param conceptId the concept id
     */
    public void setConceptId(int conceptId) {
        this.conceptId = conceptId;
    }

    /**
     * Gets concept name.
     * @return the concept name
     */
    public String getConceptName() {
        return conceptName;
    }

    /**
     * Sets concept name.
     * @param conceptName the concept name
     */
    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }

    /**
     * Gets the category.
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category.
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the description.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the user.
     * @return the user
     */
    public UserTest getUser() {
        return userOne;
    }

    /**
     * Sets the User.
     * @param userOne the user tied to the concept
     */
    public void setUser(UserTest userOne) {
        this.userOne = userOne;
    }

    @Override
    public String toString() {
        return "ConceptTest{" +
                "id=" + conceptId +
                ", Concept Name='" + conceptName + '\'' +
                ", Category='" + category + '\'' +
                ", Category Id='" + categoryId + '\''+
                ", Description=" + description +
                '}';
    }

}






