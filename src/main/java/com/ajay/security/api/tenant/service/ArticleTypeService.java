package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.ArticleType;
import com.ajay.security.api.tenant.repository.ArticleTypeRepository;

@Service
public class ArticleTypeService {

	@Autowired
	private ArticleTypeRepository articleTypeRepository;

	public List<ArticleType> getAllArticleTypes() {
		return articleTypeRepository.findAll();
	}

	public ArticleType getOneArticleType(Integer id) {
		return articleTypeRepository.findById(id).get();
	}

	public ArticleType saveArticleType(ArticleType articleType) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (articleType.getCreatedAt() == null)
			articleType.setCreatedAt(currentTimestamp);
		articleType.setUpdatedAt(currentTimestamp);
		return articleTypeRepository.save(articleType);
	}

	public String deleteOneArticleType(ArticleType articleType) {
		articleTypeRepository.delete(articleType);
		return " successfully deleted!";
	}
}
