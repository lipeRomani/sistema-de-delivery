package br.com.cantinhodamarmita.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "districts")
public class District {

    @Id
    private String name;
    private double deliveryTax;

    @DBRef
    private City city;

    public District(){

    }

    public District(String name, double deliveryTax, City city) {
        this.name = name;
        this.deliveryTax = deliveryTax;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDeliveryTax() {
        return deliveryTax;
    }

    public void setDeliveryTax(double deliveryTax) {
        this.deliveryTax = deliveryTax;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
