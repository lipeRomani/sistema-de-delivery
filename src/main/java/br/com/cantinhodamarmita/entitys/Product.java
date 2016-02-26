package br.com.cantinhodamarmita.entitys;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "products")
public class Product {

    @Id
    private long id;
    private String name;
    private double value;
    private String description;
    private List<LocalDate> availableDates;
    private boolean awaysAvailable;
    private Status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LocalDate> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<LocalDate> availableDates) {
        this.availableDates = availableDates;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isAwaysAvailable() {
        return awaysAvailable;
    }

    public void setAwaysAvailable(boolean awaysAvailable) {
        this.awaysAvailable = awaysAvailable;
    }

    public enum Type{
        FOOD, DESSERT, PACKING, DRINK;
    }

    public enum Status{
        ACTIVE, INACTIVE;
    }
}
