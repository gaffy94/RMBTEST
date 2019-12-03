package com.rmb.test.TestApi.daos;

import com.rmb.test.TestApi.entities.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountInfoDao extends JpaRepository<AccountInfo,Long> {


}
