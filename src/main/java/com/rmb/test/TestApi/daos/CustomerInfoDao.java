package com.rmb.test.TestApi.daos;

import com.rmb.test.TestApi.entities.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInfoDao extends JpaRepository<CustomerInfo,Long> {
}
