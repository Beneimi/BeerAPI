package com.beneimi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String brewery;
    private String type;
    private Double rating;

    // avoid this "No default constructor for entity"
    public Beer() {
    }

    public Beer(Long id, String name, String brewery, String type, Double rating) {
        this.id = id;
        this.name = name;
        this.brewery = brewery;
        this.type = type;
        this.rating = rating;
    }

    public Beer(String name, String brewery, String type, Double rating) {
        this.name = name;
        this.brewery = brewery;
        this.type = type;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brewery='" + brewery + '\'' +
                ", type=" + type +'\'' +
                ", rating=" + rating +
                '}';
    }

}
