package br.com.cantinhodamarmita.entitys;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;


public class AddressDto {

    @NotBlank
    private String name;
    @NotBlank
    private String number;
    @NotBlank
    private String street;

    private String complement;
    @NotBlank
    private String cep;
    @NotBlank
    private String stateId;
    @NotBlank
    private String cityId;
    @NotBlank
    private String districtId;
    @NotNull
    private Address.Type type;


    public AddressDto(){}

    public AddressDto(String name, String number, String street, String complement, String cep, String stateId, String cityId, String districtId, Address.Type type) {
        this.name = name;
        this.number = number;
        this.street = street;
        this.complement = complement;
        this.cep = cep;
        this.stateId = stateId;
        this.cityId = cityId;
        this.districtId = districtId;
        this.type = type;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Address.Type getType() {
        return type;
    }

    public void setType(Address.Type type) {
        this.type = type;
    }
}
