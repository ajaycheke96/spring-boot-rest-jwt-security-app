package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Article;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ArticleService;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@GetMapping("/listAllArticle")
	public ApiResponse getAllArticle() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Article", articleService.getAllArticles());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Article Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneArticle(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Article", articleService.getOneArticle(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Article Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveArticle")
	public ApiResponse saveArticle(@RequestBody Article article) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Article saved!",
					articleService.saveArticle(article));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Article Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateArticle")
	public ApiResponse updateArticle(@RequestBody Article article) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Article updated!",
					articleService.saveArticle(article));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Article Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteArticle")
	public ApiResponse deleteOneArticle(@RequestBody Article article) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Article deleted!",
					articleService.deleteOneArticle(article));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Article Service exception : " + e.getLocalizedMessage());
		}
	}
}
