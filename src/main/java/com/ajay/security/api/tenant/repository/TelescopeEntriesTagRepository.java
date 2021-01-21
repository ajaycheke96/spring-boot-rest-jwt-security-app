package com.ajay.security.api.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.security.api.tenant.entity.TelescopeEntriesTag;

@Repository
public interface TelescopeEntriesTagRepository extends JpaRepository<TelescopeEntriesTag, String> {

	public TelescopeEntriesTag findByTag(String tag);

}
