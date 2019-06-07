package com.company.speedypizza.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NamePattern("%s|username")
@Table(name = "SPEEDYPIZZA_CUSTOMER")
@Entity(name = "speedypizza_Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -4239334025488336731L;

    @NotNull
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USERNAME_ID", unique = true)
    protected User username;

    @NotNull
    @Column(name = "PHONE_NUMBER", nullable = false)
    protected String phoneNumber;

    @Column(name = "DISCOUNT")
    protected BigDecimal discount;

    @NotNull
    @Column(name = "ADDRESS", nullable = false)
    protected String address;

    @OneToMany(mappedBy = "customer")
    protected List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
}