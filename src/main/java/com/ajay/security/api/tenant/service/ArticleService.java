package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Article;
import com.ajay.security.api.tenant.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	public Article getOneArticle(Integer id) {
		return articleRepository.findById(id).get();
	}

	public String saveArticle(Article article) {
		return articleRepository.save(article) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateArticle(Article article) {
		return articleRepository.save(article) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneArticle(Integer id) {
		articleRepository.deleteById(id);
		return " successfully deleted!";
	}
}
