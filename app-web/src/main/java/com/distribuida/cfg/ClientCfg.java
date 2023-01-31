package com.distribuida.cfg;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import org.springframework.web.client.RestTemplate;

@ApplicationScoped
public class ClientCfg {

    @Produces
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
