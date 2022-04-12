package com.example.demo;

import com.example.demo.Controllers.CommandeController;
import com.example.demo.Controllers.LivreurController;
import com.example.demo.classes.Commande;
import com.example.demo.classes.Livreur;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("uber")
@Configuration
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {


        register(Commande.class);
        register(Livreur.class);
        register(CommandeController.class);
        register(LivreurController.class);
        register(CorsFilter.class);
    }

}