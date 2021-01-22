package com.ajay.security.api.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.security.api.tenant.entity.VehicleDocumentType;

@Repository
public interface VehicleDocumentTypeRepository extends JpaRepository<VehicleDocumentType, Integer> {

}
