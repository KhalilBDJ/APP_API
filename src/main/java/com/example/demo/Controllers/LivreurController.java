package com.example.demo.Controllers;

import com.example.demo.Repositories.CommandeRepository;
import com.example.demo.Repositories.LivreurRepository;
import com.example.demo.classes.Livreur;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("livreur")
public class LivreurController {

    @Autowired
    public LivreurRepository livreurRepository;

    @Autowired
    public CommandeRepository commandeRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Livreur> getLivreurs(){
        return livreurRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLivreur(Livreur livreur){
        livreurRepository.save(livreur);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{livreur}/{disponibilite}")
    public void changeDisponibilite(@PathParam("livreur") String nomPrenomLivreur,@PathParam("disponibilite") String disponibilite){
        Livreur livreur = livreurRepository.findLivreurByNomPrenom(nomPrenomLivreur);
        livreur.setDisponibilite(disponibilite);
        livreurRepository.save(livreur);
    }

    /*@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("disponible/{livreur}")
    public void estDisponible(@PathParam("livreur") String nomPrenom){
        Livreur livreurDispo = livreurRepository.findLivreurByNomPrenom(nomPrenom);
        if (livreurDispo.getCommande() != null){

            commandeRepository.delete(livreurDispo.getCommande());
            livreurDispo.setDisponibilite("Disponible");
        }
        livreurRepository.save(livreurDispo);
    }*/

    /*@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("enLivraison")
    public void enLivraison(){
        List<Livreur> livreursEnLivraison = livreurRepository.findAll();
        for (Livreur livreur: livreursEnLivraison) {
            if (livreur.commande != null){
                livreur.setDisponibilite("Indisponible");
            }
        }
    }*/
}
