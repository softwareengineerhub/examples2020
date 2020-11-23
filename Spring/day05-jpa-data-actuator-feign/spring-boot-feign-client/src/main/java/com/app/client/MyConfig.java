/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.client;

import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author asusadmin
 */
@Configuration
@Import(FeignClientsConfiguration.class)
public class MyConfig {


    @Bean
    public PersonRestClient personRestClient(Client client, Decoder decoder, Encoder encoder, Contract contract){
        return Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(contract)
                .target(PersonRestClient.class, "http://127.0.0.1:8080/");
    }


}
