package ogedengbe.tosan.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a role.
 * @author Tosan Ogedengbe
 */

@Entity(name = "Role")
@Table(name = "role")

public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int roleId;

    @Column(name = "rolename")
    private String roleName;

    @Column(name = "username")
    private String userName;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "roleId")
    private User user;
    private Set<Role> roleSet;


    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role.
     * @param roleId      the role id
     * @param roleName    the role name
     * @param userName    the user name
     */
    public Role(User user, int roleId, String roleName, String userName) {
        this.user = user;
        this.roleId = roleId;
        this.roleName = roleName;
        this.userName = userName;
    }

    public Role(User newUser, String roleName, String userName) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userName = userName;
    }

    public Role(String roleName, String userName) {
        this.roleName = roleName;
        this.userName = userName;
    }

    /**
     * Gets id.
     * @return the id
     */
    public int getId() {
        return roleId;
    }

    /**
     * Sets id.
     * @param id the id
     */
    public void setId(int id) {
        this.roleId = id;
    }

    /**
     * Gets role name.
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
     * Gets user.
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }


    /**
     * Gets roles.
     * @return the roles
     */
    public Set<Role> getRoleSet() {
        return roleSet;
    }

    /**
     * Sets roles.
     * @return roleSet the roles
     */
    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    /**
     * Add roles.
     * @param newRole the role
     */
    public void addRole(Role newRole) {
        roleSet.add(newRole);
    }

    /**
     * Remove roles.
     * @param newRole the role
     */
    public void removeRole(Role newRole) {
        roleSet.remove(newRole);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", userName=" + userName +
                '}';
    }

}



