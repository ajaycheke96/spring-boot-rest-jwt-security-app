package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.Article;
import com.ajay.security.api.tenant.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@GetMapping("/all")
	public List<Article> getAllArticle() {
		return articleService.getAllArticles();
	}

	@GetMapping("/one/{id}")
	public Article getOneArticle(@PathVariable Integer id) {
		return articleService.getOneArticle(id);
	}

	@PostMapping("/save")
	public String saveArticle(@RequestBody Article article) {
		return articleService.saveArticle(article);
	}

	@PutMapping("/update")
	public String updateArticle(@RequestBody Article article) {
		return articleService.updateArticle(article);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneArticle(@PathVariable Integer id) {
		return articleService.deleteOneArticle(id);
	}
}
