package com.company.speedypizza.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|username")
@Table(name = "SPEEDYPIZZA_CLERK")
@Entity(name = "speedypizza_Clerk")
public class Clerk extends StandardEntity {
    private static final long serialVersionUID = -5368184557823793794L;

    @NotNull
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USERNAME_ID", unique = true)
    protected User username;

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
}