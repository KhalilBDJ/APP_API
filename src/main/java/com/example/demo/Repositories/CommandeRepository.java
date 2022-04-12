package com.example.demo.Repositories;

import com.example.demo.classes.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

    @Transactional
    public void deleteCommandeById(Long id);



}
