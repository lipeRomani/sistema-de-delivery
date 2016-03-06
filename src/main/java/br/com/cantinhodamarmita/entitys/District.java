package br.com.cantinhodamarmita.entitys;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "districts")
public class District {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotEmpty
    private double deliveryTax;

    @DBRef
    @NotNull
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
