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

    @Column(name = "name")
    private String categoryName;

    @ManyToOne
    private Concept concept;

    /**
     * Instantiates a new Category.
     */
    public Category() {
    }

    /**
     * Instantiates a new Category.
     * @param categoryId     the category id
     * @param categoryName   the category name

     */
    public Category(int categoryId, String categoryName) {
        this.concept = concept;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + categoryId +
                '}';
    }

}
