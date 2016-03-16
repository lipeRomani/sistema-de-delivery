package br.com.cantinhodamarmita.services;

import br.com.cantinhodamarmita.entitys.User;
import br.com.cantinhodamarmita.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class SheduledService {

    private UserRepository repository;

    @Autowired
    public SheduledService(UserRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRate = 5000)
    public void teste(){
        User user = repository.findByEmail("felipearomani@gmail.com");
        System.out.println("Ola " + user.getName() + " ,agora são: " + LocalTime.now());
    }

}
