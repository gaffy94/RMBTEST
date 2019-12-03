package com.rmb.test.TestApi.services;

import com.rmb.test.TestApi.daos.CustomerInfoDao;
import com.rmb.test.TestApi.entities.AccountInfo;
import com.rmb.test.TestApi.entities.CustomerInfo;
import com.rmb.test.TestApi.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerInfoService {
    @Autowired
    CustomerInfoDao customerInfoDao;

    public Response createCustomer(CustomerInfo customerInfo) {
        Response resp = new Response();
        try{
            CustomerInfo save = customerInfoDao.save(customerInfo);
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

    public List<CustomerInfo> fetchAllCustomers() {
        return customerInfoDao.findAll();
    }

    public Optional<CustomerInfo> fetchCustomerById(Long id) {
        return customerInfoDao.findById(id);
    }
}
