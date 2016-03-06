package br.com.cantinhodamarmita.daos;


import br.com.cantinhodamarmita.entitys.State;

import java.util.List;

public interface StateDao {

    List<State> findAll();

}
