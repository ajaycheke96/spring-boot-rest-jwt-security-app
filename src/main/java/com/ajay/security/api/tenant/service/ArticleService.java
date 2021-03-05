package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Article;
import com.ajay.security.api.tenant.entity.ArticleType;
import com.ajay.security.api.tenant.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

//	@Autowired
//	private UserService userService;

	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	public Article getOneArticle(Integer id) {
		return articleRepository.findById(id).get();
	}

	public Article saveArticle(Article article) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		article.setCreatedAt(timestamp);
		article.setUpdatedAt(timestamp);

		ArticleType articleType = article.getArticleType();
		articleType.setCreatedAt(timestamp);
		articleType.setUpdatedAt(timestamp);

		if (articleType != null)
			articleType.setArticles(List.of(article));

		article.setArticleType(articleType);

		return articleRepository.save(article);
	}

	public String deleteOneArticle(Article article) {
		articleRepository.delete(article);
		return " successfully deleted!";
	}
}
