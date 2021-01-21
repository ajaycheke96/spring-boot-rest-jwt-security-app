package com.ajay.security.api.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.security.api.tenant.entity.TelescopeEntry;

@Repository
public interface TelescopeEntryRepository extends JpaRepository<TelescopeEntry, Integer> {

	public TelescopeEntry findBySequence(Integer sequence);
}
