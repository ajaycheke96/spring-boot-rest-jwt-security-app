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

import com.ajay.security.api.tenant.entity.ArticleType;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ArticleTypeService;

@RestController
@RequestMapping("/articleType")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArticleTypeController {

	@Autowired
	private ArticleTypeService articleTypeService;

	@GetMapping("/listAllArticleType")
	public ApiResponse getAllArticleType() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of ArticleType",
					articleTypeService.getAllArticleTypes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ArticleType Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneArticleType(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ArticleType",
					articleTypeService.getOneArticleType(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ArticleType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveArticleType")
	public ApiResponse saveArticleType(@RequestBody ArticleType articleType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ArticleType saved!",
					articleTypeService.saveArticleType(articleType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ArticleType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateArticleType")
	public ApiResponse updateArticleType(@RequestBody ArticleType articleType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ArticleType updated!",
					articleTypeService.saveArticleType(articleType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ArticleType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteArticleType")
	public ApiResponse deleteOneArticleType(@RequestBody ArticleType articleType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "ArticleType deleted!",
					articleTypeService.deleteOneArticleType(articleType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"ArticleType Service exception : " + e.getLocalizedMessage());
		}
	}

}
