package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class District {
    private Integer id;
    private String name;
    private Collection<Street> streetsById;

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
        District district = (District) o;
        return Objects.equals(id, district.id) &&
                Objects.equals(name, district.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "districtByDistrictid")
    public Collection<Street> getStreetsById() {
        return streetsById;
    }

    public void setStreetsById(Collection<Street> streetsById) {
        this.streetsById = streetsById;
    }
}
