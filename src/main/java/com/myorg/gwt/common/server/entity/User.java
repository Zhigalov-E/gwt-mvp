package com.myorg.gwt.common.server.entity;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "users")
public class User implements Serializable  {

    @Id
    @Column(name = "user_id")
    @SequenceGenerator(name = "user_pk_sequence", sequenceName = "users_user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_pk_sequence")
    private Integer id;

    @Column(name = "login", unique = true, nullable = false, length = 45)
    private String login;

    @Column(name = "password", nullable = false, length = 32, columnDefinition = "bpchar")
    private String password;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "birthday", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date birthday;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Version
    @Column(name = "version")
    private Integer version;

    public User(String login, String password, String firstName, String lastName, Date birthday, String email, Integer version) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.version = version;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
