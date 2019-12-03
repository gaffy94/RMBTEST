package com.rmb.test.TestApi.daos;

import com.rmb.test.TestApi.entities.TransactionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionInfoDao extends JpaRepository<TransactionInfo,Long> {
}
