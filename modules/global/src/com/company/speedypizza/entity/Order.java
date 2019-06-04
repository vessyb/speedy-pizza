package com.company.speedypizza.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NamePattern("%s|number")
@Table(name = "SPEEDYPIZZA_ORDER")
@Entity(name = "speedypizza_Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -90713938513418840L;

    @NotNull
    @Column(name = "NUMBER_", nullable = false, unique = true)
    protected String number;

    @Column(name = "INSTRUCTIONS")
    protected String instructions;

    @NotNull
    @Column(name = "DELIVERY_TIME", nullable = false)
    protected BigDecimal deliveryTime;

    @NotNull
    @Column(name = "TOTAL", nullable = false)
    protected BigDecimal total;

    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "DATE_", nullable = false)
    protected Date date;

    @OneToMany(mappedBy = "order")
    protected List<Dish> dishes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(BigDecimal deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}