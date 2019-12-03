package com.rmb.test.TestApi.services;

import com.rmb.test.TestApi.daos.TransactionInfoDao;
import com.rmb.test.TestApi.entities.AccountInfo;
import com.rmb.test.TestApi.entities.TransactionInfo;
import com.rmb.test.TestApi.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionInfoService {
    @Autowired
    TransactionInfoDao transactionInfoDao;

    public Response createTransaction(TransactionInfo transactionInfo) {

        Response resp = new Response();
        try{
            TransactionInfo save = transactionInfoDao.save(transactionInfo);
            resp.setResponseMessage("SUCCESS");
            resp.setResponseCode("000");
            resp.setData(save);
        }catch(Exception e){
            e.printStackTrace();
            resp.setResponseCode("999");
            resp.setResponseMessage(e.getMessage());
        }
        return resp;
    }

    public Optional<TransactionInfo> fetchTransactiontById(Long id) {
        return transactionInfoDao.findById(id);
    }

    public List<TransactionInfo> fetchAllTransactions() {
        return transactionInfoDao.findAll();
    }
}
