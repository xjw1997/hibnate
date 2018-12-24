package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class House {
    private Integer id;
    private String title;
    private String description;
    private Integer price;
    private Date pubdate;
    private Integer floorage;
    private String contact;
    private Users usersByUserid;
    private Types typesByTypeid;
    private Street streetByStreetid;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "PRICE")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "PUBDATE")
    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    @Basic
    @Column(name = "FLOORAGE")
    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }

    @Basic
    @Column(name = "CONTACT")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(id, house.id) &&
                Objects.equals(title, house.title) &&
                Objects.equals(description, house.description) &&
                Objects.equals(price, house.price) &&
                Objects.equals(pubdate, house.pubdate) &&
                Objects.equals(floorage, house.floorage) &&
                Objects.equals(contact, house.contact);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, description, price, pubdate, floorage, contact);
    }

    @ManyToOne
    @JoinColumn(name = "USERID", referencedColumnName = "id")
    public Users getUsersByUserid() {
        return usersByUserid;
    }

    public void setUsersByUserid(Users usersByUserid) {
        this.usersByUserid = usersByUserid;
    }

    @ManyToOne
    @JoinColumn(name = "TYPEID", referencedColumnName = "ID")
    public Types getTypesByTypeid() {
        return typesByTypeid;
    }

    public void setTypesByTypeid(Types typesByTypeid) {
        this.typesByTypeid = typesByTypeid;
    }

    @ManyToOne
    @JoinColumn(name = "STREETID", referencedColumnName = "ID")
    public Street getStreetByStreetid() {
        return streetByStreetid;
    }

    public void setStreetByStreetid(Street streetByStreetid) {
        this.streetByStreetid = streetByStreetid;
    }
}
