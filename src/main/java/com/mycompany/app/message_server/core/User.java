package com.mycompany.app.message_server.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class User {
    private String login;
    private String password;
    private String fio;
    private Date birthDate;
    private boolean isAdmin;
    private String registerDate;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public User(String login, String password, String fio, Date birthDate, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.fio = fio;
        this.birthDate = birthDate;
        this.isAdmin = isAdmin;
        this.registerDate = LocalDateTime.now().format(formatter);

    }

    public String getRegisterDate() {
        return registerDate;
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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
