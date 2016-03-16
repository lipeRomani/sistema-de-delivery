package br.com.cantinhodamarmita.entitys;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;


public class Address {

    private String name;
    private String number;
    private String street;
    private String complement;
    private String cep;
    @DBRef private District district;
    private String stateName;
    private String cityName;
    private String districtName;
    private Type type;


    public Address(String name, String number, String street, String complement, String cep, District district, String stateName, String cityName, String districtName, Type type) {
        this();
        this.name = name;
        this.number = number;
        this.street = street;
        this.complement = complement;
        this.cep = cep;
        this.district = district;
        this.stateName = stateName;
        this.cityName = cityName;
        this.districtName = districtName;
        this.type = type;
    }

    public Address(){
        this.district = new District();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type{
        COMMERCIAL("Comercial"), RESIDENCE("Residencial"), VACATION("Turismo");

        private String description;

        private Type(String description){
            this.description = description;
        }

        public String getDescription(){
            return description;
        }
    }
}
