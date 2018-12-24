package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Types {
    private Integer id;
    private String name;
    private Collection<House> housesById;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Types types = (Types) o;
        return Objects.equals(id, types.id) &&
                Objects.equals(name, types.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "typesByTypeid")
    public Collection<House> getHousesById() {
        return housesById;
    }

    public void setHousesById(Collection<House> housesById) {
        this.housesById = housesById;
    }
}
