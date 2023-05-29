package com.product.product.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product.entity.UrlSort;
import com.product.product.service.UrlSortRepo;

@RestController
@RequestMapping("/urls")
@CrossOrigin("http://localhost:3000")
public class UrlSortnerController {
	
	@Autowired
	private UrlSortRepo repo;
	
	@PostMapping
	public UrlSort saveUrls(@RequestBody UrlSort u) {
		Random random = new Random();
		UrlSort url = new UrlSort();
		url.setName(u.getName());
		url.setOriginalUrl(u.getOriginalUrl());
		
		repo.save(u);
		System.out.println("original url"+url.getOriginalUrl());
		String chars = url.getOriginalUrl();
		System.out.println(chars);
		String sUrl = "";
		int index = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<6;i++) {
		 index = random.nextInt(chars.length());
		sb.append(chars.charAt(index));
		}
		sUrl = sb.toString();
		System.out.println("sorted url"+sUrl);
		u.setSortedUrl("telusko" + sUrl);
		repo.save(u);
		return u;
	}
	@GetMapping
	public List<UrlSort> getAllUrls(){
		return repo.findAll();
	}

}
