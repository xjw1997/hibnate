package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Street {
    private Integer id;
    private String name;
    private Collection<House> housesById;
    private District districtByDistrictid;

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
        Street street = (Street) o;
        return Objects.equals(id, street.id) &&
                Objects.equals(name, street.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "streetByStreetid")
    public Collection<House> getHousesById() {
        return housesById;
    }

    public void setHousesById(Collection<House> housesById) {
        this.housesById = housesById;
    }

    @ManyToOne
    @JoinColumn(name = "DISTRICTID", referencedColumnName = "ID")
    public District getDistrictByDistrictid() {
        return districtByDistrictid;
    }

    public void setDistrictByDistrictid(District districtByDistrictid) {
        this.districtByDistrictid = districtByDistrictid;
    }
}
