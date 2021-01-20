package com.ajay.security.api.tenant.service;

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

		public String saveArticleType(ArticleType articleType) {
			return articleTypeRepository.save(articleType) != null ? " successfully saved!" : "Failed! Please try again!!";
		}

		public String updateArticleType(ArticleType articleType) {
			return articleTypeRepository.save(articleType) != null ? " successfully updated!"
					: "Failed! Please try again!!";
		}

		public String deleteOneArticleType(Integer id) {
			articleTypeRepository.deleteById(id);
			return " successfully deleted!";
		}
}
