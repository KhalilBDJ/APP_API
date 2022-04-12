package com.example.demo.Repositories;

import com.example.demo.classes.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreurRepository extends JpaRepository<Livreur, Long> {
    Livreur findLivreurByNomPrenom(String nomPrenom);
    List<Livreur> findLivreurByDisponibilite(String disponibilite);
    Livreur findLivreurByCommande_Id(Long id);


}
