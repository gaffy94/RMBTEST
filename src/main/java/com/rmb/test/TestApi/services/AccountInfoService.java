package com.rmb.test.TestApi.services;

import com.rmb.test.TestApi.daos.AccountInfoDao;
import com.rmb.test.TestApi.entities.AccountInfo;
import com.rmb.test.TestApi.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountInfoService {
    @Autowired
    AccountInfoDao accountInfoDao;

    public Response createAccount(AccountInfo accountInfo) {
        Response resp = new Response();
        try{
            AccountInfo save = accountInfoDao.save(accountInfo);
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

    public Optional<AccountInfo> fetchAccountById(Long id) {
        return accountInfoDao.findById(id);
    }

    public List<AccountInfo> fetchAllAccounts() {
        return accountInfoDao.findAll();
    }
}
