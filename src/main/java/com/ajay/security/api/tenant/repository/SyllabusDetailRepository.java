package com.ajay.security.api.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.security.api.tenant.entity.SyllabusDetail;

@Repository
public interface SyllabusDetailRepository extends JpaRepository<SyllabusDetail, Integer> {

}
