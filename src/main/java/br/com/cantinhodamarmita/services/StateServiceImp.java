package br.com.cantinhodamarmita.services;


import br.com.cantinhodamarmita.daos.StateDao;
import br.com.cantinhodamarmita.entitys.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImp implements StateService {

    private StateDao dao;

    @Autowired
    public StateServiceImp(StateDao dao) {
        this.dao = dao;
    }

    public StateServiceImp(){}

    @Override
    public List<State> findAll() {
        return dao.findAll();
    }
}
