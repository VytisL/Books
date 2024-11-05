package com.example.javafxcomposition.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Author {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty surname = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();
    private final SimpleStringProperty penname = new SimpleStringProperty();

    public Author(String name, String surname, String email){
        this.name.set(name);
        this.surname.set(surname);
        this.email.set(email);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPenname() {
        return penname.get();
    }

    public SimpleStringProperty pennameProperty() {
        return penname;
    }

    public void setPenname(String penname) {
        this.penname.set(penname);
    }

    @Override
    public String toString(){
        return "First name: " + getName() + "| Surname: " + getSurname() + "| Email: " + getEmail();
    }
}
