package com.ajay.security.api.mastertenant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.mastertenant.entity.MasterTenantEntity;
import com.ajay.security.api.mastertenant.repository.MasterTenantRepository;

import javassist.NotFoundException;

@Service
@Transactional
public class MasterTenantService {

	@Autowired
	private MasterTenantRepository masterTenantRepository;
	
	public MasterTenantEntity findById(Integer id) throws NotFoundException {
		Optional<MasterTenantEntity> optional = masterTenantRepository.findById(id);
		if(optional.isEmpty()) {
			System.out.println("Datasource Not Found!! Please try again");
			throw new NotFoundException("Not Found!! Please try again");
		}
		return optional.get();
	}
	
	public MasterTenantEntity findByName(String tenantId){
		return masterTenantRepository.findByTenantId(tenantId);
	}
	
	public List<MasterTenantEntity> findAllTenants(){
		return masterTenantRepository.findAll();
	}
	
	public String saveOrUpdateTenant(MasterTenantEntity tenantEntity) {
		String msg=(tenantEntity.getId()!=null) ? "Tenant has updated successfully!!" : "Tenant has saved successfully!!";
		
		MasterTenantEntity savedTenant = masterTenantRepository.save(tenantEntity);
		msg=(savedTenant==null) ? null : msg;
		
		return msg;
	}
	
	public String deleteTenantById(Integer id) {
		masterTenantRepository.deleteById(id);
		return "Tenant has deleted successfully!!";
	}
}
