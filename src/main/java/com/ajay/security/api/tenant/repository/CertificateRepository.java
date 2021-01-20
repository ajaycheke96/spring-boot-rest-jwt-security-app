package com.ajay.security.api.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.security.api.tenant.entity.Certificate;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

}
