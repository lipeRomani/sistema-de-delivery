package br.com.cantinhodamarmita.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "states")
public class State {

    @Id
    private String uf;
    private String name;

    public State(String uf, String name) {
        this.uf = uf;
        this.name = name;
    }

    public State(){}

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
