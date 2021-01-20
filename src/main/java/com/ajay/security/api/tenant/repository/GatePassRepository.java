package com.ajay.security.api.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.security.api.tenant.entity.GatePass;

@Repository
public interface GatePassRepository extends JpaRepository<GatePass, Integer> {

}
