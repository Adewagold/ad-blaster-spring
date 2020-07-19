package com.adblaster.core.microservice.repository;

import com.adblaster.core.microservice.model.security.Authority;
import com.adblaster.core.microservice.model.security.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * *  Created by Adewale Adeleye on 2019-07-14
 **/
@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Authority findByName(AuthorityName authorityName);
}
