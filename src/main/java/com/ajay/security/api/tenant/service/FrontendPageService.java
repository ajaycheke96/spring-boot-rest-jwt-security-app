package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FrontendPage;
import com.ajay.security.api.tenant.repository.FrontendPageRepository;

@Service
@Transactional
public class FrontendPageService {

	@Autowired
	private FrontendPageRepository frontendPageRepository;

	public List<FrontendPage> getAllFrontendPages() {
		return frontendPageRepository.findAll();
	}

	public FrontendPage getOneFrontendPage(Integer id) {
		return frontendPageRepository.findById(id).get();
	}

	public FrontendPage saveFrontendPage(FrontendPage frontendPage) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (frontendPage.getCreatedAt() == null)
			frontendPage.setCreatedAt(currentTimestamp);
		frontendPage.setUpdatedAt(currentTimestamp);

		// For FrontendMenuses list
		if (!frontendPage.getFrontendMenuses().isEmpty())
			frontendPage.getFrontendMenuses().forEach(frontendMenu -> {
				if (frontendMenu.getCreatedAt() == null)
					frontendMenu.setCreatedAt(currentTimestamp);
				frontendMenu.setUpdatedAt(currentTimestamp);

				// For frontendBlocks list
				if (!frontendMenu.getFrontendBlocks().isEmpty())
					frontendMenu.getFrontendBlocks().forEach(frontendBlock -> {
						if (frontendBlock.getCreatedAt() == null)
							frontendBlock.setCreatedAt(currentTimestamp);
						frontendBlock.setUpdatedAt(currentTimestamp);
					});

				// For frontendMenuses list
				if (!frontendMenu.getFrontendMenuses().isEmpty())
					frontendMenu.getFrontendMenuses().forEach(childFrontendMenu -> {
						if (childFrontendMenu.getCreatedAt() == null)
							childFrontendMenu.setCreatedAt(currentTimestamp);
						childFrontendMenu.setUpdatedAt(currentTimestamp);
						
						// For Child FrontendBlocks list
						if (!childFrontendMenu.getFrontendBlocks().isEmpty())
							childFrontendMenu.getFrontendBlocks().forEach(childFrontendBlock -> {
								if (childFrontendBlock.getCreatedAt() == null)
									childFrontendBlock.setCreatedAt(currentTimestamp);
								childFrontendBlock.setUpdatedAt(currentTimestamp);
							});
					});
			});

		return frontendPageRepository.save(frontendPage);
	}

	public String deleteOneFrontendPage(FrontendPage frontendPage) {
		String result = null;
		if (frontendPageRepository.existsById(frontendPage.getId())) {
			frontendPageRepository.delete(frontendPage);
			result = "FrontendPage deleted!";
		} else {
			result = "FrontendPage not found! Or Already deleted!";
		}
		return result;
	}
}
