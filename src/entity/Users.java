package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Users {
    private Integer id;
    private String name;
    private String phone;
    private String username;
    private String password;
    private String isadmin;
    private Collection<House> housesById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "isadmin")
    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) &&
                Objects.equals(name, users.name) &&
                Objects.equals(phone, users.phone) &&
                Objects.equals(username, users.username) &&
                Objects.equals(password, users.password) &&
                Objects.equals(isadmin, users.isadmin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, phone, username, password, isadmin);
    }

    @OneToMany(mappedBy = "usersByUserid")
    public Collection<House> getHousesById() {
        return housesById;
    }

    public void setHousesById(Collection<House> housesById) {
        this.housesById = housesById;
    }
}
