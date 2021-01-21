package com.ajay.security.api.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.security.api.tenant.entity.StudentGroupCollection;

@Repository
public interface StudentGroupCollectionRepository extends JpaRepository<StudentGroupCollection, Integer> {

}
