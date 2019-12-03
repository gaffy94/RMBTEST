package com.rmb.test.TestApi.controllers;

import com.rmb.test.TestApi.entities.AccountInfo;
import com.rmb.test.TestApi.entities.CustomerInfo;
import com.rmb.test.TestApi.entities.TransactionInfo;
import com.rmb.test.TestApi.models.Response;
import com.rmb.test.TestApi.services.TransactionInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@RestController
@RequestMapping("/transactions")
@Api(tags = "Transactions Info APIs")
public class TransactionsController {

    @Autowired
    TransactionInfoService transactionInfoService;

    @ApiOperation(value = "Creates/Modify a Transaction")
    @ApiResponses(value = { @ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })
    @PostMapping(name = "/create",value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    private Response createCustomer(@RequestBody @Valid TransactionInfo transactionInfo){
        return transactionInfoService.createTransaction(transactionInfo);
    }

    @ApiOperation(value = "Fetch Account By ID")
    @ApiResponses(value = { @ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })

    @GetMapping(name = "/Fetch By ID",value = "/fetch/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    private Optional<TransactionInfo> fetchAccountById(@RequestParam("id") Long id){
        return transactionInfoService.fetchTransactiontById(id);
    }


    @ApiOperation(value = "Fetch All Accounts")
    @ApiResponses(value = { @ApiResponse(code = SC_OK, message = "ok"),
            @ApiResponse(code = SC_BAD_REQUEST, message = "An unexpected error occurred")
    })

    @GetMapping(name = "/Fetch All",value = "/fetchall",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    private List<TransactionInfo> fetchAllAccounts(){
        return transactionInfoService.fetchAllTransactions();
    }

}
