package com.company.demo.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|title")
@Table(name = "DEMO_CLIENT")
@Entity(name = "demo_Client")
public class Client extends StandardEntity {
    @NotNull
    @Column(name = "TITLE", nullable = false)
    protected String title;

    @Column(name = "ADDRESS")
    protected String address;

    @Column(name = "STARS")
    protected Integer stars;

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}