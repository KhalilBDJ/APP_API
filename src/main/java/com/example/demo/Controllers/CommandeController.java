package com.example.demo.Controllers;

import com.example.demo.Repositories.CommandeRepository;
import com.example.demo.Repositories.LivreurRepository;
import com.example.demo.classes.Commande;
import com.example.demo.classes.Livreur;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("commande")
public class CommandeController {

    @Autowired
    public CommandeRepository commandeRepository;

    @Autowired
    public LivreurRepository livreurRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Commande> getAllCommande(){
        return commandeRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addCommande(Commande c){
        Livreur livreur;
        List<Livreur> livreursDisponibles = livreurRepository.findLivreurByDisponibilite("Disponible");
        if (livreursDisponibles == null){
            return;
        }
        else{
            livreur = livreursDisponibles.get(0);
        }
        livreur.setCommande(c);
        livreur.setDisponibilite("Indisponible");
        c.setLivreur(livreur);
        commandeRepository.save(c);
        livreurRepository.save(livreur);
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteCommande(@PathParam("id") Long id){
        Livreur livreur = livreurRepository.findLivreurByCommande_Id(id);
        livreur.setDisponibilite("Disponible");
        livreurRepository.save(livreur);
        commandeRepository.deleteCommandeById(id);
        //Livreur livreur = livreurRepository.findLivreurByCommande_Id(id);


    }



}
