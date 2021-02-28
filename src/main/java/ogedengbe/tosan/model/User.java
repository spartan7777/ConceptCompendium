package ogedengbe.tosan.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a user.
 * @author Tosan Ogedengbe
 */

@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "userOne", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Concept> conceptSet = new HashSet<>();


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     * @param userId      the user id
     * @param firstName   the first name
     * @param lastName    the last name
     * @param userName    the user name
     * @param password    the password
     */
    public User(int userId, String firstName, String lastName, String userName, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Gets id.
     * @return the id
     */
    public int getId() {
        return userId;
    }

    /**
     * Sets id.
     * @param id the id
     */
    public void setId(int id) {
        this.userId = id;
    }

    /**
     * Gets first name.
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password.
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets concepts.
     * @return the concepts
     */
    public Set<Concept> getConceptSet() {
        return conceptSet;
    }

    /**
     * Sets concepts.
     * @return conceptSet the concepts
     */
    public void setConceptSet(Set<Concept> conceptSet) {
        this.conceptSet = conceptSet;
    }

    /**
     * Add concepts.
     * @param newConcept the concept
     */
    public void addConcept(Concept newConcept) {
        conceptSet.add(newConcept);
        newConcept.setUserId(this);
    }

    /**
     * Remove concepts.
     * @param newConcept the concept
     */
    public void removeConcept(Concept newConcept) {
        conceptSet.remove(newConcept);
        newConcept.setUserId(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password=" + password +
                '}';
    }

}
