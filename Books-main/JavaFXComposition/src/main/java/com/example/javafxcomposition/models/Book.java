package com.example.javafxcomposition.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    private final SimpleIntegerProperty ISBN = new SimpleIntegerProperty();
    private SimpleStringProperty title = new SimpleStringProperty();
    private Author author;
    private SimpleStringProperty amount = new SimpleStringProperty();
    private SimpleStringProperty price = new SimpleStringProperty();

    public Book(String title, String amount, String price, Author author) {
        this.title = new SimpleStringProperty(title);
        this.amount = new SimpleStringProperty(amount);
        this.price = new SimpleStringProperty(price);
        this.author = author;
    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public int getISBN() {
        return ISBN.get();
    }

    public SimpleIntegerProperty ISBNProperty() {
        return ISBN;
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public String getAmount() {
        return amount.get();
    }

    public SimpleStringProperty amountProperty() {
        return amount;
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setISBN(int ISBN) {
        this.ISBN.set(ISBN);
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    @Override
    public String toString() {
        return getTitle() + " " + getAuthor().getName() + " " + getAuthor().getSurname() + ")";
    }
}
