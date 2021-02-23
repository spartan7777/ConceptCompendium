package ogedengbe.tosan.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a user.
 * @author Tosan Ogedengbe
 **/

@Entity(name = "Concept")
@Table(name = "concept")

public class Concept {
    @Id
    @Column(name = "concept_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int conceptId;

    @Column(name = "name")
    private String conceptName;

    @Column(name = "keyword_one")
    private String keywordOne;

    @Column(name = "keyword_two")
    private String keywordTwo;

    private String category;

    private String description;

    @ManyToOne
    private User userOne;

    /**
     * Instantiates a new Concept.
     */
    public Concept() {
    }

    /**
     * Instantiates a new Concept.
     * @param conceptId     the concept id
     * @param conceptName   the concept name
     * @param keywordOne    the concept's first keyword
     * @param keywordTwo    the concept's second keyword
     * @param category      the concept category
     * @param description   the concept description
     */
    public Concept(int conceptId, String conceptName, String keywordOne, String keywordTwo, String category, String description) {
        this.conceptId = conceptId;
        this.conceptName = conceptName;
        this.keywordOne = keywordOne;
        this.keywordTwo = keywordTwo;
        this.category = category;
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
     * Gets keyword one.
     * @return keyword one
     */
    public String getKeywordOne() {
        return keywordOne;
    }

    /**
     * Sets keyword one.
     * @param keywordOne keyword one
     */
    public void setKeywordOne(String keywordOne) {
        this.keywordOne = keywordOne;
    }

    /**
     * Gets keyword two.
     * @return keyword two
     */
    public String getKeywordTwo() {
        return keywordTwo;
    }

    /**
     * Sets keyword two.
     * @param keywordTwo keyword two
     */
    public void setKeywordTwo(String keywordTwo) {
        this.keywordTwo = keywordTwo;
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

    @Override
    public String toString() {
        return "Concept{" +
                "id=" + conceptId +
                ", Concept Name='" + conceptName + '\'' +
                ", Keyword One='" + keywordOne + '\'' +
                ", Keyword Two='" + keywordTwo + '\'' +
                ", Category='" + category + '\'' +
                ", Description=" + description +
                '}';
    }
}


