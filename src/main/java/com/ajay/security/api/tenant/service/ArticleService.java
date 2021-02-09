package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Article;
import com.ajay.security.api.tenant.entity.ArticleType;
import com.ajay.security.api.tenant.entity.User;
import com.ajay.security.api.tenant.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private UserService userService;

	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	public Article getOneArticle(Integer id) {
		return articleRepository.findById(id).get();
	}

	public String saveArticle(Article article) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		article.setCreatedAt(timestamp);
		article.setUpdatedAt(timestamp);

		ArticleType articleType = article.getArticleType();
		articleType.setCreatedAt(timestamp);
		articleType.setUpdatedAt(timestamp);

		if (articleType != null)
			articleType.setArticles(List.of(article));

		article.setArticleType(articleType);

		if (article.getUser() != null) {
			User user = userService.getOneUser(article.getUser().getId());
			if (user != null) {
				user.setArticles(List.of(article));
				article.setUser(user);
			}
		}

		return articleRepository.save(article) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateArticle(Article article) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		article.setUpdatedAt(timestamp);

		ArticleType articleType = article.getArticleType();
		if (articleType.getCreatedAt() == null)
			articleType.setCreatedAt(timestamp);
		articleType.setUpdatedAt(timestamp);

		if (articleType != null)
			articleType.setArticles(List.of(article));

		article.setArticleType(articleType);

		if (article.getUser() != null)
			article.getUser().setArticles(List.of(article));

		return articleRepository.save(article) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneArticle(Integer id) {
		articleRepository.deleteById(id);
		return " successfully deleted!";
	}
}
