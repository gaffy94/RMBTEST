package com.rmb.test.TestApi.services;

import com.rmb.test.TestApi.models.Client;
import com.rmb.test.TestApi.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;

@Service
public class OauthClientService {
    @Autowired
    EntityManager em;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Response createClient(Client cl) {
        Response resp = new Response();
        try{
            em.createNativeQuery("INSERT INTO oauth_client_details (client_id, client_secret, additional_information, access_token_validity, refresh_token_validity, authorized_grant_types, scope) VALUES (?,?,?,?,?,?,?)")
                    .setParameter(1, cl.getClientId())
                    .setParameter(2, passwordEncoder.encode(cl.getClientSecret()))
                    .setParameter(3, cl.getAdditionalInfo())
                    .setParameter(4, "3600")
                    .setParameter(5, "3600")
                    .setParameter(6, "password")
                    .setParameter(7, cl.getClientId()+",read,write")
                    .executeUpdate();
            resp.setResponseCode("000");
            resp.setResponseMessage("Client Created Successfully");
        } catch(Exception e){
            e.printStackTrace();
            resp.setResponseCode("999");
            resp.setResponseMessage(e.getMessage());
        }
        return resp;
    }
}
