package com.rmb.test.TestApi.controllers;

import com.rmb.test.TestApi.entities.CustomerInfo;
import com.rmb.test.TestApi.models.Client;
import com.rmb.test.TestApi.models.Response;
import com.rmb.test.TestApi.services.OauthClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@RestController
@RequestMapping("/client")
@Api(tags = "Manage Oauth Client APIs")
public class CreateClientController {

        @Autowired
        OauthClientService oauthClientService;

    @ApiOperation(value = "Creates Oauth Client")
    @ApiResponses(value = { @ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @PostMapping(name = "/create",value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    private Response createCustomer(@RequestBody @Valid Client cl){
        return oauthClientService.createClient(cl);
    }

}
