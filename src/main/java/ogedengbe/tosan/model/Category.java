package ogedengbe.tosan.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a category.
 * @author Tosan Ogedengbe
 **/

@Entity(name = "Category")
@Table(name = "category")

public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int categoryId;

    @Column(name = "category")
    private String categoryName;

    @Column(name = "definition")
    private String definition;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Concept concept;

    /**
     * Instantiates a new Category.
     * @param categoryId   the category id
     * @param categoryName the category name
     * @param definition   the category definition
     */
    public Category(int categoryId, String categoryName, String definition) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.definition = definition;
    }

    public Category(Concept concept, String categoryName, String definition) {
        this.concept = concept;
        this.categoryName = categoryName;
        this.definition = definition;
    }

    public Category(String categoryName, String definition) {
        this.categoryName = categoryName;
        this.definition = definition;
    }

    public Category() {
    }

    /**
     * Gets category id.
     * @return the category id
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Sets category id.
     * @param categoryId the category id
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets category name.
     * @return the category name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets category name.
     * @param categoryName the category name
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets category definition.
     * @return the category definition
     */
    public String getCategoryDefinition() {
        return definition;
    }

    /**
     * Sets category definition.
     * @param definition the category definition
     */
    public void setCategoryDefinition(String definition) {
        this.definition = definition;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Concept getConcept() {
        return concept;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + categoryId +
                ", Category='" + categoryName + '\''+
                ", Definition=" + definition +
                '}';
    }

}



