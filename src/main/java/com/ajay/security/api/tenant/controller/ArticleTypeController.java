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

import com.ajay.security.api.tenant.entity.ArticleType;
import com.ajay.security.api.tenant.service.ArticleTypeService;

@RestController
@RequestMapping("/articleType")
public class ArticleTypeController {

	@Autowired
	private ArticleTypeService articleTypeService;

	@GetMapping("/all")
	public List<ArticleType> getAllArticleType() {
		return articleTypeService.getAllArticleTypes();
	}

	@GetMapping("/one/{id}")
	public ArticleType getOneArticleType(@PathVariable Integer id) {
		return articleTypeService.getOneArticleType(id);
	}

	@PostMapping("/save")
	public String saveArticleType(@RequestBody ArticleType articleType) {
		return articleTypeService.saveArticleType(articleType);
	}

	@PutMapping("/update")
	public String updateArticleType(@RequestBody ArticleType articleType) {
		return articleTypeService.updateArticleType(articleType);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneArticleType(@PathVariable Integer id) {
		return articleTypeService.deleteOneArticleType(id);
	}

}
