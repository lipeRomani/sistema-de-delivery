package br.com.cantinhodamarmita.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citys")
public class City {

    @Id
    private String name;

    @DBRef
    private State state;

    public City(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public City(){
        this.state = new State();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return name;
    }
}
