package com.ajay.security.api.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.security.api.tenant.entity.FrontendPage;

@Repository
public interface FrontendPageRepository extends JpaRepository<FrontendPage, Integer> {

}
